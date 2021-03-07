package classes;

import character.Proficiencies;

import java.util.HashMap;
import java.util.Iterator;

public class BaseClass {
    private final String name;
    private String subClass;
    private int level;
    private final int hpDice;
    private final int unarmoredDefense;
    private final HashMap<String, String> classFeatures;
    private HashMap<String, String> subClassFeatures;
    private final Proficiencies proficiencies;

    public BaseClass(String className, String subClass, int hpDice, int unarmoredDefense, HashMap<String, String> classFeatures, HashMap<String, String> subClassFeatures, Proficiencies proficiencies) {
        this.name = className;
        this.hpDice = hpDice;
        this.unarmoredDefense = unarmoredDefense;
        this.classFeatures = classFeatures;
        this.subClassFeatures = subClassFeatures;
        this.subClass = subClass;
        this.level = 1;
        this.proficiencies = proficiencies;
    }

    public String getName() {
        return this.name;
    }
    public int getUnarmoredDefense() {
        return unarmoredDefense;
    }
    public int getHpDice() {
        return hpDice;
    }
    public boolean getIsCaster(String className) {
        boolean isCaster = true;
        if ("Barbarian, Fighter, Monk, Rogue".contains(className)) {
            isCaster = false;
        }
        return isCaster;
    }
    public String getCastingStat() {
        String returnString = null;
        if ("Bard, Paladin, Sorcerer, Warlock".contains(this.name)) {
            returnString = "Charisma";
        } else if ("Cleric, Druid, Monk, Ranger".contains(this.name)) {
            returnString = "Wisdom";
        } else if ("Artificer, Blood Hunter, Fighter, Rogue, Wizard".contains(name)) {
            returnString = "Intelligence";
        }
        return returnString;
    }

    public HashMap<String, String> getClassFeatures() {
        return this.classFeatures;
    }

    public HashMap<String, String> getSubClassFeatures() {
        return this.subClassFeatures;
    }

    public boolean hasClassFeature(String name) {
        boolean hasFeature = false;
        Iterator<String> it = classFeatures.keySet().iterator();
        while (it.hasNext() && !hasFeature) {
            String feature = it.next();
            if (feature.equals(name)) {
                hasFeature = true;
            }
        }
        return hasFeature;
    }

    public boolean hasSubClassFeature(String name) {
        boolean hasFeature = false;
        Iterator<String> it = subClassFeatures.keySet().iterator();
        while (it.hasNext() && !hasFeature) {
            String feature = it.next();
            if (feature.equals(name)) {
                hasFeature = true;
            }
        }
        return hasFeature;
    }

    public String getSubClass() {
        return subClass;
    }

    public void setSubClass(String subClass, HashMap<String, String> subClassFeatures) {
        this.subClass = subClass;
        this.subClassFeatures = subClassFeatures;
    }

    public Proficiencies getProficiencies() {
        return this.proficiencies;
    }

    public int getLevel() {
        return level;
    }
    public void increaseLevel() {
        this.level ++;
    }
}
