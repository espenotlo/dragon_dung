package feats;

import java.util.ArrayList;

public class FeatDataBase {
    private final ArrayList<Feat> feats;

    public FeatDataBase() {
        this.feats = new ArrayList<>();
        this.feats.add(new Feat("Heavy Armor Master", "You reduce all mundane physical damage you take by 3 while clad in heavy armor."));
    }
    public ArrayList<Feat> getFeatDataBase() {
        return feats;
    }
}
