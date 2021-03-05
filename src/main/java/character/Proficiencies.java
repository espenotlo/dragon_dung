package character;

import java.util.ArrayList;

public class Proficiencies {
    private ArrayList<String> skills;
    private ArrayList<String> savingThrows;
    private ArrayList<String> tools;
    private ArrayList<String> languages;
    private ArrayList<String> weapons;
    private ArrayList<String> armor;

    public Proficiencies() {
        skills = new ArrayList<>();
        savingThrows = new ArrayList<>();
        tools = new ArrayList<>();
        languages = new ArrayList<>();
        weapons = new ArrayList<>();
        armor = new ArrayList<>();

    }
    public void addSkillProf(String skillName) {
        boolean isProficient = false;
        for (String i : skills) {
            if (i.equals(skillName)) {
                System.out.println("Skill already proficient!");
                isProficient = true;
            }
        }
        if (!isProficient) {
            skills.add(skillName);
        }
    }
    public ArrayList<String> getWeapons() {
        return weapons;
    }
}
