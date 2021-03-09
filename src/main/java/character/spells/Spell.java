package character.spells;

public class Spell {
    private String name;
    private String description;
    private String higherLevelDescription;
    private String classes;
    private int level;
    private int dmgDieSize;
    private int dmgDieNumber;
    private int dmgMod;
    private int spellType; //Spell types: 0:attackRoll, 1:strSave, 2:dexSave, 3:conSave, 4: intSave, 5:wisSave, 6:chaSave, 7:desc-only
    private boolean concentration;
    public Spell(int spellType, int level, String name, String description,String higherLevelDescription, int dmgDieNumber, int dmgDieSize, int dmgMod, boolean concentration, String classes) {
        this.name = name;
        this.level = level;
        this.description = description;
        this.higherLevelDescription = higherLevelDescription;
        this.dmgDieNumber = dmgDieNumber;
        this.dmgDieSize = dmgDieSize;
        this.dmgMod = dmgMod;
        this.classes = classes;
        this.spellType = spellType;
        this.concentration = concentration;
    }
    public String getName() {
        return this.name;
    }
    public String getDesc() {
        return this.description;
    }
    public String getHigherLevelDesc() {
        return this.higherLevelDescription;
    }
    public String getClasses() {
        return this.classes;
    }
    public int getLevel() {
        return this.level;
    }
    public int getDmgDieSize() {
        return dmgDieSize;
    }
    public int getDmgDieNumber() {
        return dmgDieNumber;
    }
    public int getDmgMod() {
        return dmgMod;
    }
    public int getSpellType() {
        return spellType;
    }
    public boolean isConcentration() {
        return concentration;
    }
}
