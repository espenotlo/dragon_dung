package character;

import java.util.ArrayList;

public class Proficiencies {
    private final ArrayList<String> skills;
    private final ArrayList<String> savingThrows;
    private final ArrayList<String> tools;
    private final ArrayList<String> languages;
    private final ArrayList<String> weapons;
    private final ArrayList<String> armors;

    public Proficiencies() {
        skills = new ArrayList<>();
        savingThrows = new ArrayList<>();
        tools = new ArrayList<>();
        languages = new ArrayList<>();
        weapons = new ArrayList<>();
        armors = new ArrayList<>();

    }
    public void addSkillProf(String skill) {
        boolean isProficient = false;
        for (String i : skills) {
            if (i.equals(skill)) {
                System.out.println("Already proficient with " + skill + "!");
                isProficient = true;
            }
        }
        if (!isProficient) {
            skills.add(skill);
        }
    }

    public void addSaveProf(String savingThrow) {
        boolean isProficient = false;
        for (String i : savingThrows) {
            if (i.equals(savingThrow)) {
                System.out.println("Already proficient with " + savingThrow + "!");
                isProficient = true;
            }
        }
        if (!isProficient) {
            savingThrows.add(savingThrow);
        }
    }

    public void addToolProf(String tool) {
        boolean isProficient = false;
        for (String i : tools) {
            if (i.equals(tool)) {
                System.out.println("Already proficient with " + tool + "!");
                isProficient = true;
            }
        }
        if (!isProficient) {
            tools.add(tool);
        }
    }
    public void addWeaponProf(String weapon) {
        boolean isProficient = false;
        for (String i : weapons) {
            if (i.equals(weapon)) {
                System.out.println("Already proficient with " + weapon + "!");
                isProficient = true;
            }
        }
        if (!isProficient) {
            weapons.add(weapon);
        }
    }

    public void addLanguageProf(String language) {
        boolean isProficient = false;
        for (String i : languages) {
            if (i.equals(language)) {
                System.out.println("Already proficient with " + language + "!");
                isProficient = true;
            }
        }
        if (!isProficient) {
            languages.add(language);
        }
    }

    public void addArmorProf(String armor) {
        boolean isProficient = false;
        for (String i : armors) {
            if (i.equals(armor)) {
                System.out.println("Already proficient with " + armor + "!");
                isProficient = true;
            }
        }
        if (!isProficient) {
            armors.add(armor);
        }
    }
    public ArrayList<String> getSkills() {
        return this.skills;
    }

    public ArrayList<String> getWeapons() {
        return weapons;
    }

    public ArrayList<String> getSavingThrows() {
        return this.savingThrows;
    }

    public ArrayList<String> getTools() {
        return this.tools;
    }

    public ArrayList<String> getLanguages() {
        return this.languages;
    }

    public ArrayList<String> getArmors() {
        return this.armors;
    }
}
