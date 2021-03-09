package character.races;

import character.Proficiencies;

import java.util.HashMap;

public class Race {
    private final String raceName;
    private final String raceDescription;
    private final HashMap<String, String> raceFeatures;
    private final Proficiencies proficiencies;
    private final int speed;
    private final int darkvision;
    private final HashMap<String, Integer> asi;

    public Race(String name, String raceDescription, HashMap<String, String> raceFeatures, Proficiencies proficiencies, HashMap<String, Integer> asi, int speed, int darkvision) {
        this.raceName = name;
        this.raceDescription = raceDescription;
        this.raceFeatures = raceFeatures;
        this.proficiencies = proficiencies;
        this.asi = asi;
        this.speed = speed;
        this.darkvision = darkvision;
    }
public Race(String name, String raceDescription, HashMap<String, String> raceFeatures, Proficiencies proficiencies, HashMap<String, Integer> asi) {
        this.raceName = name;
        this.raceDescription = raceDescription;
        this.raceFeatures = raceFeatures;
        this.proficiencies = proficiencies;
        this.asi = asi;
        this.speed = 30;
        this.darkvision = 0;
    }

    public String getRaceName() {
        return this.raceName;
    }

    public HashMap<String, String> getRaceFeatures() {
        return this.raceFeatures;
    }

    public String getRaceDescription() {
        return this.raceDescription;
    }

    public String getRaceFeaturesAsString() {
        StringBuilder sb = new StringBuilder();
        for (String featureName: raceFeatures.keySet()) {
            sb.append(featureName).append(":\n").append(raceFeatures.get(featureName)).append("\n");
        }
        return sb.toString();
    }

    public int getSpeed() {
        return this.speed;
    }

    public int getDarkvision() {
        return this.darkvision;
    }

    public HashMap<String, Integer> getAsi() {
        return this.asi;
    }
}
