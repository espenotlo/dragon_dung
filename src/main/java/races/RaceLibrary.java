package races;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class RaceLibrary {
    private ArrayList<Race> races;

    public RaceLibrary() {
        races = new ArrayList<>();
        HashMap<String, String> features = new HashMap<>();
        races.add(new Race("Human", "Standard"));
        races.add(new Race("Elf", "Wood"));
        races.add(new Race("Elf", "High"));
        races.add(new Race("Dwarf", "Mountain"));
        races.add(new Race("Dwarf", "Hill"));
        races.add(new Race("Dragonborn", null));
        races.add(new Race("Halfling", "Lightfoot"));
    }
    public Race getRace(String name) {
        Race returnRace = null;
        for (Race race : races) {
            if (race.getName().equals(name)) {
                returnRace = race;
            }
        }
        return returnRace;
    }
    public ArrayList<Race> getRaces() {
        return this.races;
    }
    public ArrayList<String> getSubraces(String race) {
        ArrayList<String> subRaceList = new ArrayList<>();
        for (Race r : this.races) {
            if (r.getName().equals(race)) {
                subRaceList.add(r.getSubRace());
            }
        }
        return subRaceList;
    }
}
