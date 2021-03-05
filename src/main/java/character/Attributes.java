package character;

import static java.lang.Math.floor;
import static java.lang.Math.round;

public class Attributes {
    private int strength;
    private int strMod;
    private int dexterity;
    private int dexMod;
    private int constitution;
    private int conMod;
    private int intelligence;
    private int intMod;
    private int wisdom;
    private int wisMod;
    private int charisma;
    private int chaMod;

    public Attributes() {
        this.strength = 10;
        this.dexterity = 10;
        this.constitution = 10;
        this.intelligence = 10;
        this.wisdom = 10;
        this.charisma = 10;
        updateMods();
    }
    public Attributes(int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
        updateMods();
    }
    public void updateMods() {
        if (this.strength - 10 > 0) {
            strMod = (int) floor((this.strength - 10) / 2f);
        } else {
            strMod = round((this.strength - 10) / 2f);
        }
        if (this.dexterity - 10 > 0) {
            dexMod = (int) floor((this.dexterity - 10) / 2f);
        } else {
            dexMod = round((this.dexterity - 10) / 2f);
        }
        if (this.constitution - 10 > 0) {
            conMod = (int) floor((this.constitution - 10) / 2f);
        } else {
            conMod = round((this.constitution - 10) / 2f);
        }
        if (this.intelligence - 10 > 0) {
            intMod = (int) floor((this.intelligence - 10) / 2f);
        } else {
            intMod = round((this.intelligence - 10) / 2f);
        }
        if (this.wisdom - 10 > 0) {
            wisMod = (int) floor((this.wisdom - 10) / 2f);
        } else {
            wisMod = round((this.wisdom - 10) / 2f);
        }
        if (this.charisma - 10 > 0) {
            chaMod = (int) floor((this.charisma - 10) / 2f);
        } else {
            chaMod = round((this.charisma - 10) / 2f);
        }
    }
    public int getAttribute(String name) {
        return switch (name) {
            case "Strength" -> this.strength;
            case "Dexterity" -> this.dexterity;
            case "Constitution" -> this.constitution;
            case "Intelligence" -> this.intelligence;
            case "Wisdom" -> this.wisdom;
            default -> this.charisma;
        };
    }
    public int getMod(String name) {
        return switch (name) {
            case "Strength" -> this.strMod;
            case "Dexterity" -> this.dexMod;
            case "Constitution" -> this.conMod;
            case "Intelligence" -> this.intMod;
            case "Wisdom" -> this.wisMod;
            default -> this.chaMod;
        };
    }
    public void setStrength(int value) {
        this.strength = value;
        updateMods();
    }
    public void setDexterity(int value) {
        this.dexterity = value;
        updateMods();
    }
    public void setConstitution(int value) {
        this.constitution = value;
        updateMods();
    }
    public void setIntelligence(int value) {
        this.intelligence = value;
        updateMods();
    }
    public void setWisdom(int value) {
        this.wisdom = value;
        updateMods();
    }
    public void setCharisma(int value) {
        this.charisma = value;
        updateMods();
    }
    public void setAll(int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
        updateMods();
    }
}
