package spells;

import java.util.ArrayList;
import java.util.Random;

public class SpellDataBase {
    private final ArrayList<Spell> spells;

    public SpellDataBase() {
        spells = new ArrayList<>();
        //adding cantrips
        spells.add(new Spell(4,0,"Vicious Mockery","desc",null,1,4,0,false,"Bard"));
        spells.add(new Spell(0,0,"Eldritch Blast","desc", null,1, 10,0,false,"Warlock"));
        spells.add(new Spell(0,0,"Fire Bolt", "desc", null,1,10,0,false,"Artificer, Sorcerer, Wizard"));
        //adding 1st lv spells
        spells.add(new Spell(2,1,"Burning Hands","desc","desc",3,6,0,false,"Light Domain, The Fiend, The Genie, Sorcerer, Wizard"));
    }
    public ArrayList<Spell> getSpells() {
        return spells;
    }
}
