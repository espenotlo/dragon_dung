package character;

import java.util.HashMap;

public class Skills {
    private final HashMap<String, String> skills;

    public Skills() {
        this.skills = new HashMap<>();
        this.skills.put("Acrobatics", "Dexterity");
        this.skills.put("Animal Handling", "Wisdom");
        this.skills.put("Arcana", "Intelligence");
        this.skills.put("Athletics", "Strength");
        this.skills.put("Deception", "Charisma");
        this.skills.put("History", "Intelligence");
        this.skills.put("Insight", "Wisdom");
        this.skills.put("Intimidation", "Charisma");
        this.skills.put("Investigation", "Intelligence");
        this.skills.put("Medicine", "Wisdom");
        this.skills.put("Nature", "Intelligence");
        this.skills.put("Perception", "Wisdom");
        this.skills.put("Performance", "Charisma");
        this.skills.put("Persuasion", "Charisma");
        this.skills.put("Religion", "Intelligence");
        this.skills.put("Sleight of Hand", "Dexterity");
        this.skills.put("Stealth", "Dexterity");
        this.skills.put("Survival", "Wisdom");
    }
    public HashMap<String, String> getSkills() {
        return this.skills;
    }

    public String getAttribute(String skill) {
        return this.skills.get(skill);
    }
}
