package character.spells;

import java.util.HashMap;
import java.util.Iterator;

public class SpellBook {
    private final SpellDataBase spellDataBase;
    private final HashMap<String, Spell> availableSpells;
    private final HashMap<String, Spell> spellBook;
    private final HashMap<String, Spell> preparedSpells;

    public SpellBook(String className, String subClass) {
        this.spellDataBase = new SpellDataBase();
        this.availableSpells = getAvailableSpells(className, subClass);
        this.spellBook = new HashMap<>();
        this.preparedSpells = new HashMap<>();
    }
    public SpellBook(String className) {
        this.spellDataBase = new SpellDataBase();
        this.availableSpells = getAvailableSpells(className);
        this.spellBook = new HashMap<>();
        this.preparedSpells = new HashMap<>();
    }
    public HashMap<String, Spell> getAvailableSpells(String className, String subClass) {
        HashMap <String, Spell> returnSpells = new HashMap<>();
        for (Spell spell : spellDataBase.getSpells()) {
            if (spell.getClasses().contains(className) || spell.getClasses().contains(subClass)) {
                returnSpells.put(spell.getName(), spell);
            }
        }
        return returnSpells;
    }
    public HashMap<String, Spell> getAvailableSpells(String className) {
        HashMap <String, Spell> returnSpells = new HashMap<>();
        for (Spell spell : spellDataBase.getSpells()) {
            if (spell.getClasses().contains(className)) {
                returnSpells.put(spell.getName(), spell);
            }
        }
        return returnSpells;
    }
    public void addSpell(String spellName) {
        boolean searching = true;
        Iterator<Spell> it = availableSpells.values().iterator();
        while (it.hasNext() && searching) {
            Spell spell = it.next();
            if (spell.getName().equals(spellName)) {
                spellBook.put(spell.getName(), spell);
                if (spell.getLevel() == 0) {
                    preparedSpells.put(spell.getName(), spell);
                    searching = false;
                }
            }
            if (searching) {
                it = spellDataBase.getSpells().iterator();
                while (it.hasNext() && searching) {
                    Spell invalidSpell = it.next();
                    if (invalidSpell.getName().equals(spellName)) {
                        System.out.println(spellName + " is not available for your class.");
                        searching = false;
                    }
                }
                if (searching) {
                    System.out.println("Couldn't find " + spellName + " in the database.");
                }
            }
        }
    }
    public void removeSpell(String spellName) {
        Iterator<Spell> it = spellBook.values().iterator();
        boolean searching = true;
        while (it.hasNext() && searching) {
            Spell spell = it.next();
            if (spell.getName().equals(spellName)) {
                System.out.println("Removed " + spell.getName() + " from the spellbook.");
                it.remove();
                searching = false;
            }
        }
        if (searching) {
            System.out.println("No spell with the name " + spellName + " in the spellbook.");
        }
    }
    public Spell searchSpellBook(String name) {
        Spell returnSpell = null;
        boolean searching = true;
        Iterator<Spell> it = spellBook.values().iterator();
        while (it.hasNext() && searching) {
            Spell i = it.next();
            if (i.getName().equals(name)) {
                returnSpell = i;
                searching = false;
            }
        }
        return returnSpell;
    }
    public HashMap<String, Spell> getSpellBook() {
        return this.spellBook;
    }

    public SpellDataBase getSpellDataBase() {
        return spellDataBase;
    }

    public HashMap<String, Spell> getPreparedSpells() {
        return this.preparedSpells;
    }
}
