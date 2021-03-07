package character;

import backgrounds.Background;
import backgrounds.BackgroundDataBase;
import classes.ClassDataBase;
import classes.BaseClass;
import items.Item;
import races.Race;
import races.RaceLibrary;
import spells.Spell;

import java.util.Iterator;
import java.util.Random;

public class Character {
    private final String name;
    private final BaseClass baseClass;
    private final Race race;
    private final Background background;
    private final Attributes attributes;
    private final Feats feats;
    private final Inventory inv;
    private final Proficiencies proficiencies;
    private final SpellBook spellBook;
    private int ac;
    private int maxHp;
    private int currentHp;
    private int tempHp;
    private int proficiencyBonus;

    public Character() {
        this.name = "Democrates";
        this.baseClass = new ClassDataBase().getClass("Fighter");
        this.race = new RaceLibrary().getRace("Human");
        this.background = new BackgroundDataBase().getBackground("Outlander");
        this.attributes = new Attributes(16, 13, 14, 10, 10, 12);
        this.feats = new Feats();
        this.inv = new Inventory();
        this.proficiencies = new Proficiencies();
        updateMaxHp();
        this.currentHp = this.maxHp;
        this.tempHp = 0;
        this.spellBook = new SpellBook(this.baseClass.getName());
        updateProfBonus();
        updateAc();
    }

    public Character(String name, String baseClass, String race, String background
            , int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
        this.name = name;
        this.baseClass = new ClassDataBase().getClass(baseClass);
        this.race = new RaceLibrary().getRace(race);
        this.background = new BackgroundDataBase().getBackground(background);
        this.attributes = new Attributes(strength, dexterity, constitution, intelligence, wisdom, charisma);
        this.feats = new Feats();
        this.inv = new Inventory();
        this.proficiencies = new Proficiencies();
        this.currentHp = this.maxHp;
        this.tempHp = 0;
        this.spellBook = new SpellBook(this.baseClass.getName(), this.baseClass.getSubClass());
        updateProfBonus();
        updateAc();
        updateMaxHp();
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
    public Attributes getAttributes() {
        return attributes;
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
        if (null == this.baseClass.getSubClass()) {} else {
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
}