package classes;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BaseClass {
    private final String name;
    private String subClass;
    private int level;
    private final int hpDice;
    private final int unarmoredDefense;
    private final HashMap<String, String> features;
    private final HashMap<String, String> subClassFeatures;

    public BaseClass(String className) {
        this.name = className;
        this.hpDice = getHp(className);
        this.unarmoredDefense = getUA(className);
        this.features = new HashMap<>();
        this.subClassFeatures = new HashMap<>();
        this.subClass = null;
        this.level = 1;
    }
    public BaseClass(String className, String subClass) {
        this.name = className;
        this.hpDice = getHp(className);
        this.unarmoredDefense = getUA(className);
        this.features = new HashMap<>();
        this.subClassFeatures = new HashMap<>();
        this.subClass = subClass;
        this.level = 1;
    }
    private int getUA(String className) {
        int UA = 0;
        if (className.equals("Barbarian")) {
            UA = 1;
        } else if (className.equals("Monk")) {
            UA = 2;
        }
        return UA;
    }
    private int getHp(String className) {
        int hp = 8;
        if (className.equals("Barbarian")) {
            hp = 12;
        } else if ("Blood Hunter, Fighter, Paladin, Ranger".contains(className)) {
            hp = 10;
        } else if ("Sorcerer, Wizard".contains(className)) {
            hp = 6;
        }
        return hp;
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

    public HashMap<String, String> getFeatures() {
        return features;
    }
    public boolean hasFeature(String name) {
        boolean hasFeature = false;
        Iterator<Map.Entry<String,String>> it = features.entrySet().iterator();
        while (it.hasNext() && !hasFeature) {
            Map.Entry<String, String> feature = it.next();
            if (feature.getKey().equals(name)) {
                hasFeature = true;
            }
        }
        return hasFeature;
    }
    public boolean hasSubClassFeature(String name) {
        boolean hasFeature = false;
        Iterator<Map.Entry<String, String>> it = subClassFeatures.entrySet().iterator();
        while (it.hasNext() && !hasFeature) {
            Map.Entry<String,String> feature = it.next();
            if (feature.getKey().equals(name)) {
                hasFeature = true;
            }
        }
        return hasFeature;
    }
    public String getSubClass() {
        return subClass;
    }
    public void setSubClass(String subClass) {
        this.subClass = subClass;
    }
    public int getLevel() {
        return level;
    }
}
