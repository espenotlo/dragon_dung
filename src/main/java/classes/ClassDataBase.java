package classes;

import java.util.ArrayList;

public class ClassDataBase {
    private ArrayList<BaseClass> classes;

    public ClassDataBase() {
        classes = new ArrayList<>();
        classes.add(new BaseClass("Artificer"));
        classes.add(new BaseClass("Barbarian"));
        classes.add(new BaseClass("Bard"));
        classes.add(new BaseClass("Blood Hunter"));
        classes.add(new BaseClass("Cleric"));
        classes.add(new BaseClass("Druid"));
        classes.add(new BaseClass("Fighter"));
        classes.add(new BaseClass("Monk"));
        classes.add(new BaseClass("Paladin"));
        classes.add(new BaseClass("Ranger"));
        classes.add(new BaseClass("Rogue"));
        classes.add(new BaseClass("Sorcerer"));
        classes.add(new BaseClass("Warlock"));
        classes.add(new BaseClass("Wizard"));
    }
    public BaseClass getClass(String name) {
        BaseClass returnBaseClass = null;
        for (BaseClass baseClass : classes) {
            if (baseClass.getName().equals(name)) {
                returnBaseClass = baseClass;
            }
        }
        return returnBaseClass;
    }
}
