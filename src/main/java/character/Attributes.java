package character;

import static java.lang.Math.floor;
import static java.lang.Math.round;

public class Attributes {
    private final Attribute strength;
    private final Attribute dexterity;
    private final Attribute constitution;
    private final Attribute intelligence;
    private final Attribute wisdom;
    private final Attribute charisma;

    public Attributes() {
        this.strength = new Attribute ("Strength", 10, "   Strength\n" +
                "   Measures\n" +
                "   Natural athleticism, bodily power\n" +
                "\n" +
                "   Important for\n" +
                "   Barbarian, fighter, paladin\n" +
                "\n" +
                "   Racial Increases\n" +
                "   Mountain dwarf (+2)\n" +
                "   Dragonborn (+2)\n" +
                "   Half-orc (+2)\n" +
                "   Human (+1)");
        this.dexterity = new Attribute ("Dexterity", 10, "   Dexterity\n" +
                "   Measures\n" +
                "   Physical agility, reflexes, balance, poise\n" +
                "\n" +
                "   Important for\n" +
                "   Monk, ranger, rogue\n" +
                "\n" +
                "   Racial Increases\n" +
                "   Elf (+2)\n" +
                "   Halfling (+2)\n" +
                "   Forest gnome (+1)\n" +
                "   Human (+1)");
        this.constitution = new Attribute ("Constitution", 10,"   Constitution\n" +
                "   Measures\n" +
                "   Health, stamina, vital force\n" +
                "\n" +
                "   Important for\n" +
                "   Everyone\n" +
                "\n" +
                "   Racial Increases\n" +
                "   Dwarf (+2), " +
                "   Stout halfling (+1)\n" +
                "   Rock gnome (+1)\n" +
                "   Half-orc (+1)\n" +
                "   Human (+1)");
        this.intelligence = new Attribute ("Intelligence", 10,"   Intelligence\n" +
                "   Measures\n" +
                "   Mental acuity, information recall, analytical skill\n" +
                "\n" +
                "   Important for\n" +
                "   Wizard\n" +
                "\n" +
                "   Racial Increases\n" +
                "   High elf (+1)\n" +
                "   Gnome (+2)\n" +
                "   Tiefling (+1)\n" +
                "   Human (+1)");
        this.wisdom = new Attribute ("Wisdom", 10,"   Wisdom\n" +
                "   Measures\n" +
                "   Awareness, intuition, insight\n" +
                "\n" +
                "   Important for\n" +
                "   Cleric, druid\n" +
                "\n" +
                "   Racial Increases\n" +
                "   Hill dwarf (+1)\n" +
                "Wood elf (+1)\n" +
                "Human (+1)");
        this.charisma = new Attribute ("Charisma", 10, "   Charisma\n" +
                "   Measures\n" +
                "   Confidence, eloquence, leadership\n" +
                "\n" +
                "   Important for\n" +
                "   Bard, sorcerer, warlock\n" +
                "\n" +
                "   Racial Increases\n" +
                "   Half-elf (+2)\n" +
                "   Drow (+1)\n" +
                "   Lightfoot halfling (+1)\n" +
                "   Dragonborn (+1)\n" +
                "   Tiefling (+2)\n" +
                "   Human (+1)");
    }

    public Attributes(int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
        this.strength = new Attribute("Strength", strength,"\n\n\n\nStrength\n" +
                "Measures\n" +
                "Natural athleticism, bodily power\n" +
                "\n" +
                "Important for\n" +
                "Barbarian, fighter, paladin\n" +
                "\n" +
                "Racial Increases\n" +
                "Mountain dwarf (+2), Dragonborn (+2), Half-orc (+2), Human (+1)");
        this.dexterity = new Attribute("Dexterity", dexterity,"\n\n\n\nDexterity\n" +
                "Measures\n" +
                "Physical agility, reflexes, balance, poise\n" +
                "\n" +
                "Important for\n" +
                "Monk, ranger, rogue\n" +
                "\n" +
                "Racial Increases\n" +
                "Elf (+2), Halfling (+2), Forest gnome (+1), Human (+1)\n");
        this.constitution = new Attribute("Constitution", constitution,"\n\n\n\nConstitution\n" +
                "Measures\n" +
                "Health, stamina, vital force\n" +
                "\n" +
                "Important for\n" +
                "Everyone\n" +
                "\n" +
                "Racial Increases\n" +
                "Dwarf (+2), Stout halfling (+1), Rock gnome (+1), Half-orc (+1), Human (+1)");
        this.intelligence = new Attribute("Intelligence", intelligence,"\n\n\n\nIntelligence\n" +
                "Measures\n" +
                "Mental acuity, information recall, analytical skill\n" +
                "\n" +
                "Important for\n" +
                "Wizard\n" +
                "\n" +
                "Racial Increases\n" +
                "High elf (+1), Gnome (+2), Tiefling (+1), Human (+1)");
        this.wisdom = new Attribute("Wisdom", wisdom,"\n\n\n\nWisdom\n" +
                "Measures\n" +
                "Awareness, intuition, insight\n" +
                "\n" +
                "Important for\n" +
                "Cleric, druid\n" +
                "\n" +
                "Racial Increases\n" +
                "Hill dwarf (+1), Wood elf (+1), Human (+1)");
        this.charisma = new Attribute("Charisma", charisma,"\n\n\n\nCharisma\n" +
                "Measures\n" +
                "Confidence, eloquence, leadership\n" +
                "\n" +
                "Important for\n" +
                "Bard, sorcerer, warlock\n" +
                "\n" +
                "Racial Increases\n" +
                "Half-elf (+2), Drow (+1), Lightfoot halfling (+1), Dragonborn (+1), Tiefling (+2), Human (+1)");
    }

    public Attribute getAttribute(String name) {
        return switch (name) {
            case "Strength" -> this.strength;
            case "Dexterity" -> this.dexterity;
            case "Constitution" -> this.constitution;
            case "Intelligence" -> this.intelligence;
            case "Wisdom" -> this.wisdom;
            default -> this.charisma;
        };
    }
    public int getValue(String name) {
        return switch (name) {
            case "Strength" -> this.strength.getValue();
            case "Dexterity" -> this.dexterity.getValue();
            case "Constitution" -> this.constitution.getValue();
            case "Intelligence" -> this.intelligence.getValue();
            case "Wisdom" -> this.wisdom.getValue();
            default -> this.charisma.getValue();
        };
    }
    public int getMod(String name) {
        return switch (name) {
            case "Strength" -> this.strength.getMod();
            case "Dexterity" -> this.dexterity.getMod();
            case "Constitution" -> this.constitution.getMod();
            case "Intelligence" -> this.intelligence.getMod();
            case "Wisdom" -> this.wisdom.getMod();
            default -> this.charisma.getMod();
        };
    }
    public void setStrength(int value) {
        this.strength.setValue(value);
    }
    public void setDexterity(int value) {
        this.dexterity.setValue(value);
    }
    public void setConstitution(int value) {
        this.constitution.setValue(value);
    }
    public void setIntelligence(int value) {
        this.intelligence.setValue(value);
    }
    public void setWisdom(int value) {
        this.wisdom.setValue(value);
    }
    public void setCharisma(int value) {
        this.charisma.setValue(value);
    }
    public void setAll(int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
        this.strength.setValue(strength);
        this.dexterity.setValue(dexterity);
        this.constitution.setValue(constitution);
        this.intelligence.setValue(intelligence);
        this.wisdom.setValue(wisdom);
        this.charisma.setValue(charisma);
    }
}
