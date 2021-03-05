package backgrounds;

import java.util.ArrayList;
import java.util.Arrays;

public class BackgroundDataBase {
    private final ArrayList<Background> backgrounds;

    public BackgroundDataBase() {
        backgrounds = new ArrayList<>();
        backgrounds.add(new Background("Outlander","You grew up in the wilds, far from civilization and the comforts of town and technology. You’ve witnessed the migration of herds larger than forests, survived weather more extreme than any city-dweller could comprehend, and enjoyed the solitude of being the only thinking creature for miles in any direction. The wilds are in your blood, whether you were a nomad, an explorer, a recluse, a hunter-gatherer, or even a marauder. Even in places where you don’t know the specific features of the terrain, you know the ways of the wild."
                ,new String[] {"Wanderer","Remember places you've visited, and find food for up to six people per day."}
                ,"Athletics, Survival, Instrument, Language","Quarterstaff, Hunting Trap, Traveler's Clothes, Hunting Trophy",10));
        backgrounds.add(new Background("Soldier","",new String[] {"Rank","Your rank carries benefits."}
                , "Athletics, Intimidation, Gaming Set, Vehicles(land)", "Insignia of Rank, Battle Trophy, Gaming Set, Common Clothes", 10));
        backgrounds.add(new Background("Criminal","", new String[] {"Criminal Contact", "Something."}
                , "Deception, Stealth, Gaming Set, Thieves' Tools","Crowbar, Common Clothes",15));
    }
    public Background getBackground(String name) {
        Background returnBackground = null;
        for (Background background : backgrounds) {
            if (background.getName().equals(name)) {
                returnBackground = background;
            }
        }
        return returnBackground;
    }
    public ArrayList<Background> getBackgrounds() {
        backgrounds.sort((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
        return this.backgrounds;
    }
}
