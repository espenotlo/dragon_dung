package character;

import items.Item;
import items.ItemDataBase;

import java.util.ArrayList;
import java.util.Iterator;

public class Inventory {
    private final ArrayList<Item> inventory;
    private final ArrayList<items.Item> equipped;
    private final ItemDataBase itemDataBase;

    public Inventory() {
        itemDataBase = new ItemDataBase();
        equipped = new ArrayList<>();
        inventory = new ArrayList<>();
    }
    public ArrayList<Item> getEquipped() {
        return equipped;
    }

    public void addItem(String name) {
        Item item = itemDataBase.searchDB(name);
        if (item == null) {
            System.out.println("No item with this name");
        } else {
            inventory.add(item);
            System.out.println("Added " + item.getName() + " to inventory.");
        }
    }
    public void removeItem(String name) {
        boolean searching = true;
        Iterator<Item> it = inventory.iterator();
        while (it.hasNext() && searching) {
            Item i = it.next();
            if (i.getName().equals(name)) {
                for (Item item : equipped) {
                    if (item.getName().equals(name)) {
                        System.out.println(item.getName() + " must be un-equipped prior to removal.");
                    } else {
                        System.out.println("Removed" + i.getName());
                        it.remove();
                        searching = false;
                    }
                }
            }
        }
        if (searching) {
            System.out.println("No item with that name");
        }
    }
    public Item searchInv(String name) {
        Item returnItem = null;
        boolean searching = true;
        Iterator<Item> it = inventory.iterator();
        while (it.hasNext() && searching) {
            Item i = it.next();
            if (i.getName().equals(name)) {
                returnItem = i;
                searching = false;
            }
        }
        return returnItem;
    }
    public void equipItem(String name) {
        Item i = searchInv(name);
        if (i==null) {
            System.out.println("No such item in inventory");
        } else if (i.getArmor()) {
            if (searchArmor()) {
                System.out.println("Another armor is equipped. Un-equip old armor first.");
            } else {
                equipped.add(i);
                System.out.println("Equipped " + i.getName());
            }
        } else if (i.getWeapon()) {
            equipped.add(i);
        } else {
            System.out.println(i.getName() + " is not equippable.");
        }
    }
    /** searches equipped for given item, and removes it if present, or lets the user know if it isn't.
     * Also updates AC if it was an armor.
     *
     * @param name  the name of the item to be removed
     */
    public void unEquipItem(String name) {
        boolean itemFound = false;
        Iterator<Item> it = equipped.iterator();
        while (it.hasNext() && !itemFound) {
            Item i = it.next();
            if (i.getName().equals(name)) {
                System.out.println("Unequipped " + i.getName() + ".");
                it.remove();
                itemFound = true;
            }
        }
        if (!itemFound) {
            System.out.println("No such item equipped");
        }
    }
    public Item searchEquipped(String name) {
        Item returnItem = null;
        boolean searching = true;
        Iterator<Item> it = equipped.iterator();
        while (it.hasNext() && searching) {
            Item i = it.next();
            if (i.getName().equals(name)) {
                returnItem = i;
                searching = false;
            }
        }
        return returnItem;
    }
    public boolean searchArmor() {
        boolean hasArmor = false;
        Iterator<Item> it = equipped.iterator();
        while (it.hasNext() && !hasArmor) {
            Item i = it.next();
            if (i.getArmor()) {
                hasArmor = true;
            }
        }
        return hasArmor;
    }

    public ItemDataBase getItemDataBase() {
        return itemDataBase;
    }
}
