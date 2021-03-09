package character.races;

import character.Proficiencies;

import java.util.HashMap;

public class Subrace {
    private final Race parentRace;
    private final String subraceName;
    private final String subraceDescription;
    private final HashMap<String, String> subraceFeatures;
    private final int speedModifier;
    private final int darkvisionModifier;
    private final Proficiencies proficiencies;
    private final HashMap<String, Integer> asi;

    public Subrace(Race parent, String subraceName, String subraceDescription, HashMap<String, String> subraceFeatures, int speed, int darkvision, Proficiencies proficiencies, HashMap<String, Integer> asi) {
        this.parentRace = parent;
        this.subraceName = subraceName;
        this.subraceDescription = subraceDescription;
        this.subraceFeatures = subraceFeatures;
        this.speedModifier = speed;
        this.darkvisionModifier = darkvision;
        this.proficiencies = proficiencies;
        this.asi = asi;

    }

    public String getSubraceName() {
        return this.subraceName;
    }

    public String getSubraceDescription() {
        return this.subraceDescription;
    }

    public HashMap<String, String> getSubraceFeatures() {
        return this.subraceFeatures;
    }

    public String getSubraceFeaturesAsString() {
        StringBuilder sb = new StringBuilder();
        for (String string : this.subraceFeatures.keySet()) {
            sb.append(string).append(":\n").append(this.subraceFeatures.get(string)).append("\n");
        }
        return sb.toString();
    }

    public Proficiencies getProficiencies() {
        return this.proficiencies;
    }

    public int getSpeedModifier() {
        return this.speedModifier;
    }

    public int getDarkvisionModifier() {
        return this.darkvisionModifier;
    }

    public HashMap<String, Integer> getAsi() {
        HashMap<String, Integer> returnMap = new HashMap<>();
        returnMap.put("Strength", (this.asi.get("Strength") + this.parentRace.getAsi().get("Strength")));
        returnMap.put("Dexterity", (this.asi.get("Dexterity") + this.parentRace.getAsi().get("Dexterity")));
        returnMap.put("Constitution", (this.asi.get("Constitution") + this.parentRace.getAsi().get("Constitution")));
        returnMap.put("Intelligence", (this.asi.get("Intelligence") + this.parentRace.getAsi().get("Intelligence")));
        returnMap.put("Wisdom", (this.asi.get("Wisdom") + this.parentRace.getAsi().get("Wisdom")));
        returnMap.put("Charisma", (this.asi.get("Charisma") + this.parentRace.getAsi().get("Charisma")));
        return returnMap;
    }

    public Race getParentRace() {
        return this.parentRace;
    }
}
