package character;

import backgrounds.Background;
import backgrounds.BackgroundDataBase;
import character.attributes.Attributes;
import character.skills.Skills;
import character.classes.ClassDataBase;
import character.classes.BaseClass;
import character.feats.Feats;
import character.items.Inventory;
import character.items.Item;
import character.races.Race;
import character.races.RaceLibrary;
import character.races.Subrace;
import character.spells.Spell;
import character.spells.SpellBook;

import java.util.Iterator;
import java.util.Random;

import static java.lang.Math.*;

public class Character {
    private final String name;
    private final BaseClass baseClass;
    private final Race race;
    private final Subrace subrace;
    private final Background background;
    private final Attributes attributes;
    private final Feats feats;
    private final Inventory inv;
    private final Proficiencies proficiencies;
    private final SpellBook spellBook;
    private final Skills skills;
    private int ac;
    private int maxHp;
    private int currentHp;
    private int tempHp;
    private int proficiencyBonus;
    private int currentHitDice;
    private int deathSaveFailures;
    private int deathSaveSuccesses;
    private int level;
    private int speed;

    public Character() {
        this.name = "Democrates";
        this.baseClass = new ClassDataBase().getClass("Fighter");
        this.subrace = new RaceLibrary().getSubrace("Standard Human");
        this.race = this.subrace.getParentRace();
        this.background = new BackgroundDataBase().getBackground("Outlander");
        this.attributes = new Attributes(13, 12, 11, 10, 9, 8);
        setAttributes();
        this.feats = new Feats();
        updateMaxHp();
        this.currentHp = this.maxHp;
        this.inv = new Inventory();
        this.proficiencies = new Proficiencies();
        this.tempHp = 0;
        this.spellBook = new SpellBook(this.baseClass.getName());
        this.skills = new Skills();
        this.level = 1;
        this.currentHitDice = this.level;
        this.speed = this.subrace.getSpeedModifier() + this.race.getSpeed();
        updateProfBonus();
        updateAc();
    }

    public Character(String name, String baseClass, String subrace, String background
            , int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
        this.name = name;
        this.baseClass = new ClassDataBase().getClass(baseClass);
        this.subrace = new RaceLibrary().getSubrace(subrace);
        this.race = this.subrace.getParentRace();
        this.background = new BackgroundDataBase().getBackground(background);
        this.attributes = new Attributes(strength, dexterity, constitution, intelligence, wisdom, charisma);
        this.feats = new Feats();
        this.inv = new Inventory();
        this.proficiencies = new Proficiencies();
        this.currentHp = this.maxHp;
        this.tempHp = 0;
        this.spellBook = new SpellBook(this.baseClass.getName(), this.baseClass.getSubClass());
        this.skills = new Skills();
        this.level = 1;
        this.currentHitDice = this.level;
        setAttributes();
        updateProfBonus();
        updateAc();
        updateMaxHp();
    }

    private void setAttributes() {
        int strength = this.attributes.getValue("Strength") + this.subrace.getAsi().get("Strength");
        int dexterity = this.attributes.getValue("Dexterity") + this.subrace.getAsi().get("Dexterity");
        int constitution = this.attributes.getValue("Constitution") + this.subrace.getAsi().get("Constitution");
        int intelligence = this.attributes.getValue("Intelligence") + this.subrace.getAsi().get("Intelligence");
        int wisdom = this.attributes.getValue("Wisdom") + this.subrace.getAsi().get("Wisdom");
        int charisma = this.attributes.getValue("Charisma") + this.subrace.getAsi().get("Charisma");
        this.attributes.setAll(strength, dexterity, constitution, intelligence, wisdom, charisma);
    }

    public void updateAc() {
        if (!this.inv.searchArmor()) {
            if (this.baseClass.getUnarmoredDefense()== 1) {
                ac = 10 + attributes.getMod("Dexterity") + attributes.getMod("Constitution");
            } else if (this.baseClass.getUnarmoredDefense()==2){
                ac = 10 + attributes.getMod("Dexterity") + attributes.getMod("Wisdom");
            } else {
                ac = 10 + attributes.getMod("Dexterity");
            }
        } else {
            for (Item i : inv.getEquipped()) {
                if (i.getArmor()) {
                    if (i.getType() == 4) {
                        this.ac = 10 + this.attributes.getMod("Dexterity") + i.getBonus() + i.getMagicBonus();
                    } else if (i.getType() == 5) {
                        if (this.attributes.getMod("Dexterity") > 2) {
                            this.ac = 12 + i.getBonus() + i.getMagicBonus();
                        } else {
                            this.ac = 10 + this.attributes.getMod("Dexterity") + i.getBonus() + i.getMagicBonus();
                        }
                    } else {
                        this.ac = 10 + i.getBonus() + i.getMagicBonus();
                    }
                }
            }
        }
        for (Item i : inv.getEquipped()) {
            if (i.getType() == 7) {
                this.ac += i.getBonus() + i.getMagicBonus();
            }
        }
    }

    public String getName() {
        return name;
    }


    public BaseClass getBaseClass() {
        return baseClass;
    }

    public Race getRace() {
        return race;
    }

    public Subrace getSubrace() {
        return this.subrace;
    }

    public int getLevel() {
        return this.level;
    }

    public int getCurrentHitDice() {
        return this.currentHitDice;
    }

    public void spendHitDie() {
        if (this.currentHitDice > 0) {
            this.currentHitDice --;
            heal(roll("1d" + (this.getBaseClass().getHpDice() + this.attributes.getMod("Constitution"))));
        }
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public String getSavingThrowAsString(String attribute) {
        int returnInt;
        if (this.proficiencies.getSavingThrows().contains(attribute)) {
            returnInt = this.attributes.getMod(attribute) + this.proficiencyBonus;
        }
        else {
            returnInt = this.attributes.getMod(attribute);
        }
        if (returnInt >= 0) {
            return "+" + returnInt;
        } else {
            return "" + returnInt;
        }
    }

    public int getSkillMod(String skill) {
        int skillMod = 0;
        for (String s : this.proficiencies.getSkills()) {
            if (s.equals(skill)) {
                skillMod += this.proficiencyBonus;
            }
        }
        skillMod += this.attributes.getMod(this.skills.getAttribute(skill));
        return skillMod;
    }

    public String getSkillModAsString(String skill) {
        int skillMod = 0;
        for (String s : this.proficiencies.getSkills()) {
            if (s.equals(skill)) {
                skillMod += this.proficiencyBonus;
            }
        }
        skillMod += this.attributes.getMod(this.skills.getAttribute(skill));
        if (skillMod >= 0) {
            return "+" + skillMod;
        } else {
            return "" + skillMod;
        }
    }

    public int getAc() {
        return ac;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public int getTempHp() {
        return tempHp;
    }

    private int getCastingMod() {
        return attributes.getMod(this.baseClass.getCastingStat());
    }

    public void damage(int damage) {
        int dmg = damage;
        while (dmg > 0 && tempHp > 0 ) {
            tempHp--;
            dmg--;
        }
        while (dmg > 0 && currentHp > 0) {
            currentHp--;
            dmg--;
        }
    }

    public void heal(int healing) {
        currentHp += healing;
        if (currentHp > maxHp) {
            currentHp = maxHp;
        }
    }

    public void longRest() {
        currentHp = maxHp;
        if (this.currentHitDice < this.level) {
            this.currentHitDice += round(this.level/2f);
            if (this.currentHitDice > this.level) {
                this.currentHitDice = this.level;
            }
        }
        tempHp = 0;
        deathSaveSuccesses = 0;
        deathSaveFailures = 0;
    }

    public void deathSave() {
        int save = roll("1d20");
        if (save >= 10) {
            if (save == 20) {
                deathSaveSuccesses = 3;
            } else {
                deathSaveSuccesses = min((deathSaveSuccesses + 1), 3);
            }
        } else if (save == 1) {
            deathSaveFailures = min((deathSaveFailures + 2), 3);
        } else {
            deathSaveFailures = min((deathSaveFailures + 1), 3);
        }
    }

    public int skillCheck(String skill) {
        return roll("1d20") + getSkillMod(skill);
    }

    public boolean isDead() {
        return this.deathSaveFailures >= 3;
    }

    public int getDeathSaveFailures() {
        return this.deathSaveFailures;
    }

    public int getDeathSaveSuccesses() {
        return this.deathSaveSuccesses;
    }

    public int spellAttack() {
        Random r = new Random();
        int diceRoll = r.nextInt(20) + 1;
        int mods = this.attributes.getMod(this.baseClass.getCastingStat()) + this.proficiencyBonus;
        int total = diceRoll + mods;
        System.out.println("Dice roll: " + diceRoll);
        System.out.println("plus modifiers of: " + mods);
        System.out.println("for a total of: " + total + " to hit.");
        return total;
    }

    public int spellDamage(String spellName) {
        Spell spell = this.spellBook.getPreparedSpells().get(spellName);
        Random r = new Random();
        int diceRoll = 0;
        int i = 0;
        while (i <= spell.getDmgDieNumber()) {
            diceRoll += r.nextInt(spell.getDmgDieSize()+1);
        }
        int bonuses = spell.getDmgMod();

        if (spell.getName().equals("Eldritch Blast") && baseClass.hasSubClassFeature("Agonizing Blast")) {
            bonuses += attributes.getMod("Charisma");
        }
        return diceRoll + bonuses;
    }

    public int weaponAttack(String weaponName) {
        Random r = new Random();
        int diceRoll = r.nextInt(20) + 1;
        Item weapon = this.inv.searchEquipped(weaponName);
        boolean proficient = false;
        Iterator<String> it = proficiencies.getWeapons().iterator();
        while (it.hasNext() && !proficient) {
            String i = it.next();
            if (i.equals(weapon.getName())) {
                proficient = true;
            }
        }
        int statMod = 0;
        if (weapon.getType() < 2) {
            statMod = this.attributes.getMod("Strength");
        } else if (weapon.getType() == 2){
            statMod = this.attributes.getMod("Dexterity");
        } else {
            statMod = Math.max(attributes.getMod("Strength"), attributes.getMod("Dexterity"));
        }
        System.out.println("Dice roll: " + diceRoll);
        System.out.println("plus modifiers of " + statMod);
        return diceRoll + this.proficiencyBonus + statMod;
    }

    public int weaponDamage(String weaponName) {
        Item weapon = this.inv.searchEquipped(weaponName);
        int diceRoll = roll(weapon.getNumberOfDice()+"d"+weapon.getBonus());
        int statMod = 0;
        if (weapon.getType() < 2) {
            statMod = this.attributes.getMod("Strength");
        } else if (weapon.getType() == 2) {
            statMod = this.attributes.getMod("Dexterity");
        } else {
            statMod = Math.max(attributes.getMod("Strength"), attributes.getMod("Dexterity"));
        }
        return diceRoll + statMod;
    }

    public int versatileWeaponDamage(String weaponName) {
        Item weapon = this.inv.searchEquipped(weaponName);
        int diceRoll = roll(weapon.getNumberOfDice()+"d"+weapon.getVersatileDamage());
        int statMod = 0;
        if (weapon.getType() < 2) {
            statMod = this.attributes.getMod("Strength");
        } else if (weapon.getType() == 2) {
            statMod = this.attributes.getMod("Dexterity");
        } else {
            statMod = Math.max(attributes.getMod("Strength"), attributes.getMod("Dexterity"));
        }
        return diceRoll + statMod;
    }

    public int offHandDamage(String weaponName) {
        Item weapon = this.inv.searchInv(weaponName);
        return roll(weapon.getNumberOfDice()+"d"+weapon.getBonus());
    }

    private void updateMaxHp() {
        int newHp = this.baseClass.getHpDice() + this.attributes.getMod("Constitution");
        int i = 1;
        while (i < this.baseClass.getLevel()) {
            newHp += (this.baseClass.getHpDice()/2)+1+this.attributes.getMod("Constitution");
            i++;
        }
        if (this.race.getRaceName().equals("Hill Dwarf")) {
            newHp += this.baseClass.getLevel();
        }
        if (null != this.baseClass.getSubClass()) {
            if (this.baseClass.getSubClass().equals("Draconic Bloodline")) {
                newHp += this.baseClass.getLevel();
            }
        }
        if (feats.hasFeat("Tough")) {
            newHp += this.baseClass.getLevel() * 2;
        }
        this.maxHp = newHp;
    }

    public int roll(String die) {
        int diceRoll = 0;
        int number = 1;
        int size = 0;
        String[] parts = die.split("d");
        if (parts.length > 1) {
            number = Integer.parseInt(parts[0]);
            size = Integer.parseInt(parts[1]);
        } else {
            size = Integer.parseInt(parts[0]);
        }
        Random r = new Random();
        int i = 0;
        while (i < number) {
            diceRoll += r.nextInt(size) + 1;
            i++;
        }
        return diceRoll;
    }

    public Background getBackground() {
        return background;
    }

    private void updateProfBonus() {
        int level = this.baseClass.getLevel();
        int profBonus = 6;
        if (level < 5) {
            profBonus = 2;
        } else if (level < 9) {
            profBonus = 3;
        } else if (level < 13) {
            profBonus = 4;
        } else if (level < 17) {
            profBonus = 5;
        }
        this.proficiencyBonus = profBonus;
    }

    public void equipItem(String name) {
        this.inv.equipItem(name);
        Item i = this.inv.searchEquipped(name);
        if (i.getType() < 8 && i.getType() > 3) {
            updateAc();
        }
    }

    public void unEquip(String name) {
        Item i = this.inv.searchEquipped(name);
        this.inv.unEquipItem(name);
        if (i.getType() < 8 && i.getType() > 3) {
            updateAc();
        }
    }

    public void resetDeathSaves() {
        this.deathSaveSuccesses = 0;
        this.deathSaveFailures = 0;
    }
}