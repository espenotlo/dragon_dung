package character.classes;

import character.Proficiencies;

import java.util.ArrayList;
import java.util.HashMap;

public class ClassDataBase {
    private final ArrayList<BaseClass> classes;

    public ClassDataBase() {
        classes = new ArrayList<>();
        HashMap<String, String> classFeatures = new HashMap<>();
        classFeatures.put("something", "something");
        HashMap<String, String> subClassFeatures = new HashMap<>();
        subClassFeatures.put("something", "something");
        Proficiencies proficiencies = new Proficiencies();
        proficiencies.addSaveProf("Strength");
        proficiencies.addSaveProf("Constitution");
        classes.add(new BaseClass("Artificer", null, 8, 0, classFeatures, subClassFeatures, proficiencies));
        classes.add(new BaseClass("Barbarian", null, 12, 1, classFeatures, subClassFeatures, proficiencies));
        classes.add(new BaseClass("Bard", null, 8, 0, classFeatures, subClassFeatures, proficiencies));
        classes.add(new BaseClass("Blood Hunter", null, 10, 0, classFeatures, subClassFeatures, proficiencies));
        classes.add(new BaseClass("Cleric", "Divine Domain", 8, 0, classFeatures, subClassFeatures, proficiencies));
        classes.add(new BaseClass("Druid", null, 8, 0, classFeatures, subClassFeatures, proficiencies));
        classes.add(new BaseClass("Fighter", null, 10, 0, classFeatures, subClassFeatures, proficiencies));
        classes.add(new BaseClass("Monk", null, 8, 2, classFeatures, subClassFeatures, proficiencies));
        classes.add(new BaseClass("Paladin", null, 10, 0, classFeatures, subClassFeatures, proficiencies));
        classes.add(new BaseClass("Ranger", null, 10, 0, classFeatures, subClassFeatures, proficiencies));
        classes.add(new BaseClass("Rogue", null, 8, 0, classFeatures, subClassFeatures, proficiencies));
        classes.add(new BaseClass("Sorcerer", "Sorcerous Origin", 6, 0, classFeatures, subClassFeatures, proficiencies));
        classes.add(new BaseClass("Warlock", "Otherworldly Patron", 8, 0, classFeatures, subClassFeatures, proficiencies));
        classes.add(new BaseClass("Wizard", null, 6, 0, classFeatures, subClassFeatures, proficiencies));
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
