package character;

import spells.Spell;
import spells.SpellDataBase;

import java.util.ArrayList;
import java.util.Iterator;

public class SpellBook {
    private final SpellDataBase spellDataBase;
    private ArrayList<Spell> availableSpells;
    private ArrayList<Spell> spellBook;
    private ArrayList<Spell> preparedSpells;

    public SpellBook(String className, String subClass) {
        this.spellDataBase = new SpellDataBase();
        this.availableSpells = getAvailableSpells(className, subClass);
        this.spellBook = new ArrayList<>();
        this.preparedSpells = new ArrayList<>();
    }
    public SpellBook(String className) {
        this.spellDataBase = new SpellDataBase();
        this.availableSpells = getAvailableSpells(className);
        this.spellBook = new ArrayList<>();
        this.preparedSpells = new ArrayList<>();
    }
    public ArrayList<Spell> getAvailableSpells(String className, String subClass) {
        ArrayList <Spell> returnSpells = new ArrayList<>();
        for (Spell spell : spellDataBase.getSpells()) {
            if (spell.getClasses().contains(className) || spell.getClasses().contains(subClass)) {
                returnSpells.add(spell);
            }
        }
        return returnSpells;
    }
    public ArrayList<Spell> getAvailableSpells(String className) {
        ArrayList <Spell> returnSpells = new ArrayList<>();
        for (Spell spell : spellDataBase.getSpells()) {
            if (spell.getClasses().contains(className)) {
                returnSpells.add(spell);
            }
        }
        return returnSpells;
    }
    public void addSpell(String spellName) {
        boolean searching = true;
        Iterator<Spell> it = availableSpells.iterator();
        while (it.hasNext() && searching) {
            Spell spell = it.next();
            if (spell.getName().equals(spellName)) {
                spellBook.add(spell);
                if (spell.getLevel() == 0) {
                    preparedSpells.add(spell);
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
        Iterator<Spell> it = spellBook.iterator();
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
        Iterator<Spell> it = spellBook.iterator();
        while (it.hasNext() && searching) {
            Spell i = it.next();
            if (i.getName().equals(name)) {
                returnSpell = i;
                searching = false;
            }
        }
        return returnSpell;
    }
    public ArrayList<Spell> getSpellBook() {
        return this.spellBook;
    }

    public SpellDataBase getSpellDataBase() {
        return spellDataBase;
    }
    public Spell searchPreparedSpells(String name) {
        Spell returnSpell = null;
        boolean searching = true;
        Iterator<Spell> it = spellBook.iterator();
        while (it.hasNext() && searching) {
            Spell i = it.next();
            if (i.getName().equals(name)) {
                returnSpell = i;
                searching = false;
            }
        }
        return returnSpell;
    }
}
