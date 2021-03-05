package backgrounds;

import java.util.ArrayList;
import java.util.Arrays;

public class Background {
    private final String name;
    private final String description;
    private final String proficiencies;
    private final String[] feature;
    private final String items;
    private final int gold;

    public Background(String name, String description, String[] feature, String proficiencies, String items, int gold) {
        this.name = name;
        this.description = description;
        this.feature = feature;
        this.proficiencies = proficiencies;
        this.items = items;
        this.gold = gold;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return this.description;
    }
    public String getProficiencies() {
        return this.proficiencies;
    }
    public String[] getFeature() {
        return this.feature;
    }
    public String getItems() {
        return this.items;
    }
    public int getGold() {
        return this.gold;
    }
}
