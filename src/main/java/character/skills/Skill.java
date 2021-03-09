package character.skills;

public class Skill {
    private final String name;
    private final String attribute;
    public Skill(String name, String attribute) {
        this.name = name;
        this.attribute = attribute;
    }

    public String getName() {
        return this.name;
    }

    public String getAttribute() {
        return this.attribute;
    }
}
