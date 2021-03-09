package character.races;

import character.Proficiencies;

import java.util.ArrayList;
import java.util.HashMap;

public class RaceLibrary {
    private HashMap<String, Race> races = new HashMap<>();
    private ArrayList<Subrace> subraces;

    public RaceLibrary() {
        generateRaces();
        generateSubraces();
    }

    private void generateRaces() {
        races = new HashMap<>();
        HashMap<String, String> raceFeatures = new HashMap<>();
        Proficiencies proficiencies = new Proficiencies();
        HashMap<String, Integer> asi = new HashMap<>();

        raceFeatures.put("Ability Score Increase", "Your Dexterity score increases by 2.");
        raceFeatures.put("Size", "Elves range from under 5 to over 6 feet tall and have slender builds. Your size is Medium.");
        raceFeatures.put("Speed", "Your base walking speed is 30 feet.");
        raceFeatures.put("Darkvision", "You have darkvision with a radius of 60 feet.");
        raceFeatures.put("Keen Senses", "You have proficiency in the Perception skill.");
        raceFeatures.put("Fey Ancestry", "You have advantage on saving throws against being charmed, and magic can’t put you to sleep.");
        raceFeatures.put("Trance", "Elves don’t need to sleep. Instead, they meditate deeply, remaining semiconscious, for 4 hours a day. ");
        raceFeatures.put("Languages", "You can speak, read, and write Common and Elvish.");

        proficiencies.addLanguageProf("Common");
        proficiencies.addLanguageProf("Elvish");
        proficiencies.addSkillProf("Perception");
        proficiencies.addSavingThrowAdvantage("Charmed");

        asi.put("Strength", 0);
        asi.put("Dexterity", 2);
        asi.put("Constitution", 0);
        asi.put("Intelligence", 0);
        asi.put("Wisdom", 0);
        asi.put("Charisma", 0);

        races.put("Elf", new Race("Elf", "Elves are a magical people of otherworldly grace, living in the world but not entirely part of it. " +
                "They live in places of ethereal beauty, in the midst of ancient forests or in silvery spires glittering with faerie light, " +
                "where soft music drifts through the air and gentle fragrances waft on the breeze. Elves love nature and magic, art and artistry, " +
                "music and poetry, and the good things of the world.", raceFeatures, proficiencies, new HashMap<>(asi), 30, 60 ));

        raceFeatures.clear();
        raceFeatures.put("Ability Score Increase", "Your Dexterity score increases by 2.");
        raceFeatures.put("Size","Halflings average about 3 feet tall and weigh about 40 pounds. Your size is Small.");
        raceFeatures.put("Speed","Your base walking speed is 25 feet.");
        raceFeatures.put("Lucky","When you roll a 1 on the d20 for an attack roll, ability check, or saving throw, " +
                "you can reroll the die and must use the new roll.");
        raceFeatures.put("Brave","You have advantage on saving throws against being frightened.");
        raceFeatures.put("Halfling Nimbleness","You can move through the space of any creature that is of a size larger than yours.");
        raceFeatures.put("Languages","You can speak, read, and write Common and Halfling. ");

        proficiencies.clear();
        proficiencies.addSavingThrowAdvantage("Frightened");
        proficiencies.addLanguageProf("Common");
        proficiencies.addLanguageProf("Halfling");

        races.put("Halfling", new Race("Halfling", "The comforts of home are the goals of most halflings’ lives: a place to settle in peace and quiet, " +
                "far from marauding monsters and clashing armies; a blazing fire and a generous meal; fine drink and fine conversation. " +
                "Though some halflings live out their days in remote agricultural communities, others form nomadic bands that travel constantly, " +
                "lured by the open road and the wide horizon to discover the wonders of new lands and peoples. But even these wanderers love peace, " +
                "food, hearth, and home, though home might be a wagon jostling along a dirt road or a raft floating downriver."
                , raceFeatures, proficiencies, new HashMap<>(asi), 30, 0));

        raceFeatures.clear();
        raceFeatures.put("Ability Score Increase","Your Constitution score increases by 2.");
        raceFeatures.put("Size","Dwarves stand between 4 and 5 feet tall and average about 150 pounds. Your size is Medium.");
        raceFeatures.put("Speed","Your base walking speed is 25 feet. Your speed is not reduced by wearing heavy armor.");
        raceFeatures.put("Darkvision","You have darkvision with a radius of 60 feet.");
        raceFeatures.put("Dwarven Resilience","You have advantage on saving throws against poison, and you have resistance against poison damage.");
        raceFeatures.put("Dwarven Combat Training","You have proficiency with the battleaxe, handaxe, light hammer, and warhammer.");
        raceFeatures.put("Tool Proficiency","You gain proficiency with the artisan’s tools of your choice: smith’s tools, brewer’s supplies, or mason’s tools.");
        raceFeatures.put("Stonecunning","Whenever you make an Intelligence (History) check related to the origin of stonework, " +
                "you are considered proficient in the History skill and add double your proficiency bonus to the check, instead of your normal proficiency bonus.");
        raceFeatures.put("Languages","You can speak, read, and write Common and Dwarvish.");

        proficiencies.clear();
        String[] weapons = {"Battleaxe", "Handaxe", "Light hammer", "Warhammer"};
        proficiencies.addWeapons(weapons);
        proficiencies.addToolProf("Smith's Tools");

        asi.put("Dexterity", 0);
        asi.put("Constitution", 2);

        races.put("Dwarf", new Race("Dwarf", "Kingdoms rich in ancient grandeur, halls carved into the roots of mountains, " +
                "the echoing of picks and hammers in deep mines and blazing forges, a commitment to clan and tradition, " +
                "and a burning hatred of goblins and orcs—these common threads unite all dwarves.", raceFeatures, proficiencies, new HashMap<>(asi), 25, 60));

        raceFeatures.clear();
        raceFeatures.put("Draconic Ancestry", "Your breath weapon and damage Resistance are determined by the Dragon type, as shown in the table.");
        raceFeatures.put("Breath Weapon", "You can use your action to exhale destructive energy. Your Draconic ancestry determines the size, shape, and damage type of the exhalation. " +
                "\nWhen you use your breath weapon, each creature in the area of the exhalation must make a saving throw, the type of which is determined by your Draconic ancestry. The DC for this saving throw equals 8 + your Constitution modifier + your Proficiency Bonus. A creature takes 2d6 damage on a failed save, and half as much damage on a successful one. The damage increases to 3d6 at 6th level, 4d6 at 11th level, and 5d6 at 16th level.\n" +
                "\n" +
                "After you use your breath weapon, you can’t use it again until you complete a short or Long Rest.");
        raceFeatures.put("Damage Resistance", "You have resistance to the damage type associated with your Draconic ancestry.");
        raceFeatures.put("Languages", " You can speak, read, and write Common and Draconic.");

        proficiencies.clear();
        proficiencies.addLanguageProf("Common");
        proficiencies.addLanguageProf("Draconic");

        asi.put("Constitution", 0);
        asi.put("Strength", 2);
        asi.put("Charisma", 1);

        races.put("Dragonborn", new Race("Dragonborn", "Born of Dragons, as their name proclaims, " +
                "the dragonborn walk proudly through a world that greets them with fearful incomprehension. " +
                "Shaped by draconic gods or the Dragons themselves, dragonborn originally hatched from Dragon eggs as a unique race, " +
                "combining the best attributes of Dragons and Humanoids. Some dragonborn are faithful servants to true Dragons, " +
                "others form the ranks of soldiers in great wars, and still others find themselves adrift, with no clear calling in life."
                , raceFeatures, proficiencies, new HashMap<>(asi), 30, 0));

        raceFeatures.clear();

        proficiencies.clear();

        asi.put("Strength", 0);
        asi.put("Charisma", 0);

        races.put("Human", new Race("Human", "In the reckonings of most worlds, Humans are the youngest of the common character.races. " +
                "Perhaps it is because of their shorter lives that they strive to achieve as much as they can in the years they are given. " +
                "Or maybe they feel they have something to prove to the elder character.races, " +
                "and that’s why they build their mighty empires on the foundation of conquest and trade. Whatever drives them, " +
                "Humans are the innovators, the achievers, and the pioneers of the worlds.",
                raceFeatures, proficiencies, new HashMap<>(asi), 30, 0));
    }

    private void generateSubraces() {
        this.subraces = new ArrayList<>();
        HashMap<String, String> subraceFeatures = new HashMap<>();
        HashMap<String, Integer> asi = new HashMap<>();
        Proficiencies proficiencies = new Proficiencies();

        asi.put("Strength", 0);
        asi.put("Dexterity", 0);
        asi.put("Constitution", 0);
        asi.put("Intelligence", 1);
        asi.put("Wisdom", 0);
        asi.put("Charisma", 0 );

        subraceFeatures.put("Ability Score Increase", "+1 Intelligence");
        subraceFeatures.put("Elf Weapon Training", "You have proficiency with the longsword, shortsword, shortbow, and longbow.");
        subraceFeatures.put("Cantrip", "You know one cantrip of your choice from the wizard spell list. Intelligence is your spellcasting ability for it.");
        subraceFeatures.put("Extra Language", "You can speak, read, and write one extra language of your choice.");

        String[] elfWeapons = {"Longsword", "Shortsword", "Shortbow", "Longbow"};
        proficiencies.addWeapons(elfWeapons);
        proficiencies.addLanguageProf("Any");

        this.subraces.add(new Subrace(races.get("Elf"), "High Elf", "As a high elf, you have a keen mind and a mastery of at least the basics of magic. " +
                "In Faerûn, there are two kinds of high elves. The sun elves are haughty and reclusive, " +
                "believing themselves to be superior to non-elves and even other elves. The moon elves are more common and more friendly, " +
                "and often encountered among humans and other character.races.", subraceFeatures, 0, 0, proficiencies, new HashMap<>(asi)));
        subraceFeatures.clear();

        subraceFeatures.put("Ability Score Increase", "+1 Wisdom");
        subraceFeatures.put("Elf Weapon Training", "You have proficiency with the longsword, shortsword, shortbow, and longbow.");
        subraceFeatures.put("Fleet of Foot", "Your base walking speed increases to 35 feet.");
        subraceFeatures.put("Mask of the Wild", "You can attempt to hide even when you are only lightly obscured by foliage, heavy rain, " +
                "falling snow, mist, and other natural phenomena.");

        proficiencies.clear();
        proficiencies.addWeapons(elfWeapons);

        asi.put("Intelligence", 0);
        asi.put("Wisdom", 1);

        this.subraces.add(new Subrace(races.get("Elf"), "Wood Elf", "As a wood elf, you have keen senses and intuition, " +
                "and your fleet feet carry you quickly and stealthily through your native forests. " +
                "Wood elves (also called wild elves, green elves, or forest elves) are reclusive and distrusting of non-elves."
                , subraceFeatures, 5, 0, proficiencies, new HashMap<>(asi)));

        subraceFeatures.clear();
        subraceFeatures.put("Ability Score Increase", "+1 Charisma");
        subraceFeatures.put("Superior Darkvision", "Your darkvision has a radius of 120 feet.");
        subraceFeatures.put("Sunlight Sensitivity", "You have disadvantage on attack rolls and on Perception checks that rely on sight when you, " +
                "the target of your attack, or whatever you are trying to perceive is in direct sunlight.");
        subraceFeatures.put("Drow Magic", "You know the dancing lights cantrip. When you reach 3rd level, " +
                "you can cast the faerie fire spell once with this trait and regain the ability to do so when you finish a long rest. " +
                "When you reach 5th level, you can cast the darkness spell once with this trait and regain the ability to do so when you finish a long rest. " +
                "Charisma is your spellcasting ability for these character.spells.");
        subraceFeatures.put("Drow Weapon Training", "You have proficiency with rapiers, shortswords, and hand crossbows.");

        proficiencies.clear();
        String [] drowWeapons = {"Rapier", "Shortsword", "Hand Crossbow"};
        proficiencies.addWeapons(drowWeapons);

        asi.put("Wisdom", 0);
        asi.put("Charisma", 1);

        this.subraces.add(new Subrace(races.get("Elf"), "Dark Elf", "Descended from an earlier subrace of elves, " +
                "the drow were banished from the surface world for following the goddess Lolth down the path of evil. " +
                "Now they have built their own civilization in the depths of the Underdark, patterned after the Way of Lolth. " +
                "Also called dark elves, the drow have skin that resembles charcoal or obsidian, as well as stark white or pale yellow hair. " +
                "They commonly have very pale eyes (so pale as to be mistaken for white) in shades of lilac, silver, pink, red, and blue. " +
                "They tend to be smaller and thinner than most elves.", subraceFeatures, 0, 60, proficiencies, new HashMap<>(asi)));

        subraceFeatures.clear();
        subraceFeatures.put("Ability Score Increase", "Your ability scores each increase by 1.");
        subraceFeatures.put("Extra Language", "You can speak, read, and write one extra language of your choice.");

        proficiencies.clear();
        proficiencies.addLanguageProf("Any");

        asi.put("Strength", 1);
        asi.put("Dexterity", 1);
        asi.put("Constitution", 1);
        asi.put("Intelligence", 1);
        asi.put("Wisdom", 1);
        asi.put("Charisma", 1);

        this.subraces.add(new Subrace(races.get("Human"), "Standard Human", "In the reckonings of most worlds, " +
                "humans are the youngest of the common character.races, late to arrive on the world scene and short-lived in comparison to dwarves, " +
                "elves, and dragons. Perhaps it is because of their shorter lives that they strive to achieve as much as they can in the years they are given. " +
                "Or maybe they feel they have something to prove to the elder character.races, and that’s why they build their mighty empires on the foundation of conquest and trade. " +
                "Whatever drives them, humans are the innovators, the achievers, and the pioneers of the worlds."
                , subraceFeatures, 0, 0, proficiencies, new HashMap<>(asi)));

        subraceFeatures.clear();
        subraceFeatures.put("Ability Score Increase", "Two different ability scores of your choice increase by 1.");
        subraceFeatures.put("Skills", "You gain proficiency in one skill of your choice.");
        subraceFeatures.put("Feat", "You gain one feat of your choice.");

        proficiencies.clear();
        proficiencies.addSkillProf("Any");
        //TODO: Add ASI & feat.

        asi.put("Strength", 0);
        asi.put("Dexterity", 0);
        asi.put("Constitution", 0);
        asi.put("Intelligence", 0);
        asi.put("Wisdom", 0);
        asi.put("Charisma", 0);

        this.subraces.add(new Subrace(races.get("Human"), "Variant Human", "If your campaign uses the optional feat rules from the Player’s Handbook, " +
                "your Dungeon Master might allow these variant traits, all of which replace the human’s Ability Score Increase trait."
                , subraceFeatures, 0, 0, proficiencies, new HashMap<>(asi)));

        subraceFeatures.clear();
        subraceFeatures.put("Ability Score Increase", "Your Strength score increases by 2.");
        subraceFeatures.put("Dwarven Armor Training", "You have proficiency with light and medium armor.");

        proficiencies.clear();
        proficiencies.addArmorProf("Light");
        proficiencies.addArmorProf("Medium");

        asi.put("Strength", 2);

        this.subraces.add(new Subrace(races.get("Dwarf"),"Mountain Dwarf", "As a mountain dwarf, you’re strong and hardy, " +
                "accustomed to a difficult life in rugged terrain. You’re probably on the tall side (for a dwarf), " +
                "and tend toward lighter coloration. The shield dwarves of northern Faerûn are mountain dwarves."
                , subraceFeatures, 0, 0, proficiencies, new HashMap<>(asi)));

        subraceFeatures.clear();
        subraceFeatures.put("Ability Score Increase", "Your Wisdom score increases by 1.");
        subraceFeatures.put("Dwarven Toughness", "Your hit point maximum increases by 1, and it increases by 1 every time you gain a level.");

        proficiencies.clear();

        asi.put("Strength", 0);
        asi.put("Wisdom", 1);

        this.subraces.add(new Subrace(races.get("Dwarf"), "Hill Dwarf", "As a hill dwarf, you have keen senses, deep intuition, " +
                "and remarkable resilience. The gold dwarves of Faerûn in their mighty southern kingdom are hill dwarves."
                , subraceFeatures, 0, 0, proficiencies, new HashMap<>(asi)));

        subraceFeatures.clear();
        subraceFeatures.put("Ability Score Increase", "Your Constitution score increases by 1.");
        subraceFeatures.put("Stout Resilience", "You have advantage on saving throws against poison, and you have resistance against poison damage.");

        asi.put("Wisdom", 0);
        asi.put("Constitution", 1);

        this.subraces.add(new Subrace(races.get("Halfling"),"Stout Halfling", "As a stout halfling, " +
                "you’re hardier than average and have some resistance to poison. " +
                "Some say that stouts have dwarven blood. In the Forgotten Realms, " +
                "these halflings are called stronghearts, and they’re most common in the south.", subraceFeatures, 0, 0, proficiencies, new HashMap<>(asi)));

        subraceFeatures.clear();
        subraceFeatures.put("Ability Score Increase", "Your Charisma score increases by 1.");
        subraceFeatures.put("Naturally Stealthy", "You can attempt to hide even when you are obscured only by a creature that is at least one size larger than you.");

        asi.put("Constitution", 0);
        asi.put("Charisma", 1);

        this.subraces.add(new Subrace(races.get("Halfling"), "Lightfoot Halfling", "Lightfoots are more prone to wanderlust than other halflings, " +
                "and often dwell alongside other character.races or take up a nomadic life. In the world of Greyhawk, " +
                "these halflings are called hairfeet or tallfellows.", subraceFeatures, 0,0, proficiencies, new HashMap<>(asi)));
    }

    public Race getRace(String name) {
        return this.races.get(name);
    }

    public String[] getRaces() {
        return this.races.keySet().toArray(new String[0]);
    }

    public String[] getSubraces(String race) {
        ArrayList<String> subraceList = new ArrayList<>();
        for (Subrace subrace : this.subraces) {
            if (subrace.getParentRace().getRaceName().equals(race)) {
                subraceList.add(subrace.getSubraceName());
            }
        }
        if (subraceList.size() == 0) {
            subraceList.add("N/A");
        }
        return subraceList.toArray(new String[0]);
    }

    public Subrace getSubrace(String subrace) {
        Subrace returnSubrace = null;
        for (Subrace s : this.subraces) {
            if (s.getSubraceName().equals(subrace)) {
                returnSubrace = s;
            }
        }
        return returnSubrace;
    }

}
