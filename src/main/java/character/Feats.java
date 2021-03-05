package character;

import feats.Feat;
import feats.FeatDataBase;

import java.util.ArrayList;
import java.util.Iterator;

public class Feats {
    private final FeatDataBase featDataBase;
    private final ArrayList<Feat> knownFeats;

    public Feats() {
        this.featDataBase = new FeatDataBase();
        this.knownFeats = new ArrayList<>();
    }
    public ArrayList<Feat> getKnownFeats() {
        return this.knownFeats;
    }

    public boolean hasFeat(String name) {
        boolean found = false;
        Iterator<Feat> it = this.knownFeats.iterator();
        while (!found && it.hasNext()) {
            Feat feat = it.next();
            if (feat.getName().equals(name)) {
                found = true;
            }
        }
        return found;
    }
    public void addFeat(String featName) {
        Iterator<Feat> it = this.featDataBase.getFeatDataBase().iterator();
        boolean found = false;
        while (it.hasNext() && !found) {
            Feat f = it.next();
            if (f.getName().equals(featName)) {
                found = true;
                for (Feat feat : this.knownFeats) {
                    if (feat.getName().equals(featName)) {
                        System.out.println(featName + " is already known!");
                    } else {
                        this.knownFeats.add(f);
                    }
                }
            }
        }
        if (!found) {
            System.out.println(featName + " is not in the database.");
        }
    }

    public FeatDataBase getFeatDataBase() {
        return featDataBase;
    }
}
