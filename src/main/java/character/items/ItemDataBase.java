package character.items;

import java.util.ArrayList;
import java.util.Iterator;

public class ItemDataBase {
    private final ArrayList<Item> items;

    public ItemDataBase() {
        items = new ArrayList<>();
        items.add(new Item(0,"Longsword",8,15,3,1,10,0));
        items.add(new Item(1,"Greataxe",12,30,7, 0));
        items.add(new Item(1,"Greatsword",6,50,6,2,0,0));
        items.add(new Item(2,"Shortbow",6,25,2,0));
        items.add(new Item(3,"Scimitar",6,25,3,0));
        items.add(new Item(3,"Dagger",4,2,1,0));
        items.add(new Item(4, "Leather Armor", 1, 10,10,0));
        items.add(new Item(4, "Studded Leather Armor", 2, 45, 13,0));
        items.add(new Item(5,"Scale Mail", 4,50,45,0));
        items.add(new Item(6,"Chain Mail",6,75,55,0));
        items.add(new Item(7, "Shield",2,10,6,0));
    }
    public Item searchDB(String name) {
        Item returnItem = null;
        boolean searching = true;
        Iterator<Item> it = items.iterator();
        while (it.hasNext() && searching) {
            Item i = it.next();
            if (i.getName().equalsIgnoreCase(name)) {
                returnItem = i;
                searching = false;
            }
        }
        return returnItem;
    }
    public ArrayList<Item> getWeapons() {
        ArrayList<Item> weapons = new ArrayList<>();
        for (Item i : items) {
            if (i.getWeapon()) {
                weapons.add(i);
            }
        }
        return weapons;
    }
    public ArrayList<Item> getArmors() {
        ArrayList<Item> armors = new ArrayList<>();
        for (Item i : items) {
            if (i.getArmor()) {
                armors.add(i);
            }
        }
        return armors;
    }
    public ArrayList<Item> getLightArmors() {
        ArrayList<Item> lightArmors = new ArrayList<>();
        for (Item i : items) {
            if (i.getType() == 2) {
                lightArmors.add(i);
            }
        }
        return lightArmors;
    }
    public ArrayList<Item> getMediumArmors() {
        ArrayList<Item> mediumArmors = new ArrayList<>();
        for (Item i : items) {
            if (i.getType() == 2) {
                mediumArmors.add(i);
            }
        }
        return mediumArmors;
    }
    public ArrayList<Item> getHeavyArmors() {
        ArrayList<Item> heavyArmors = new ArrayList<>();
        for (Item i : items) {
            if (i.getType() == 2) {
                heavyArmors.add(i);
            }
        }
        return heavyArmors;
    }
}
