package races;

import java.util.HashMap;

public class Race {
    private RaceLibrary raceDataBase;
    private String name;
    private String subRace;
    private HashMap<String,String> features;

    public Race(String raceName, String subRace) {
        this.name = raceName;
        this.subRace = subRace;
    }
    public String getName() {
        return this.name;
    }
    public String getSubRace() {
        return this.subRace;
    }
    public String getRaceName() {
        return this.subRace + " " + this.name;
    }
}
