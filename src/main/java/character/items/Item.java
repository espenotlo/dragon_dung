package character.items;

/** An item that  can be either a piece of weapon, armor or non-equippables. Types to be added: consumables, tools.
 *
 */
public class Item {
    private final String name;
    private boolean isArmor = false;
    private boolean isWeapon = false;
    private final int numberOfDice;
    private final int versatileDamage;
    private final int value;
    private final int weight;
    private final int type;
    private final int dmgOrAcBonus;
    private final int magicBonus;


    /** Constructs an item of given type with given parameters.
     * type 0-3 = weapon, type 4 = light armor, type 5 = medium armor, type 6 = heavy armor, type 7 = miscArmor, 8+ = non-equipment
     *
     * @param type  The type of the item (0: Versatile weapon, 1:Str Weapon, 2: Dex Weapon, 3: Finesse weapon, 4:LightArmor, 5:MediumArmor, 6:HeavyArmor, , 7: miscArmor, 8+:non-equipment
     * @param name  The name of the item
     * @param dmgOrAcBonus  The damage Die if it is a weapon, or the ac bonus if it is an armor.
     * @param value The gold value of the item
     * @param weight    The item's weight in lbs
     */
    public Item(int type, String name, int dmgOrAcBonus, int value, int weight, int magicBonus) {
        if (type > 3 && type < 7) {
            isArmor = true;
        } else if (type < 4) {
            isWeapon = true;
        }
        this.dmgOrAcBonus = dmgOrAcBonus;
        this.numberOfDice = 1;
        this.versatileDamage = 0;
        this.name = name;
        this.value = value;
        this.weight = weight;
        this.type = type;
        this.magicBonus = magicBonus;
    }
    public Item(int type, String name, int dmgOrAcBonus, int value, int weight, int numberOfDice, int versatileDamage, int magicBonus) {
        if (type > 3 && type < 7) {
            isArmor = true;
        } else if (type < 4) {
            isWeapon = true;
        }
        this.dmgOrAcBonus = dmgOrAcBonus;
        this.numberOfDice = numberOfDice;
        this.versatileDamage = versatileDamage;
        this.name = name;
        this.value = value;
        this.weight = weight;
        this.type = type;
        this.magicBonus = magicBonus;
    }
    public Boolean getArmor() {
        return isArmor;
    }
    public Boolean getWeapon() {
        return isWeapon;
    }
    public int getBonus() {
        return dmgOrAcBonus;
    }
    public int getValue() {
        return value;
    }
    public int getWeight() {
        return weight;
    }
    public String getName() {
        return name;
    }
    public int getType() {
        return type;
    }
    public int getNumberOfDice() {
        return this.numberOfDice;
    }
    public int getVersatileDamage() {
        return this.versatileDamage;
    }
    public int getMagicBonus() {
        return this.magicBonus;
    }
}
