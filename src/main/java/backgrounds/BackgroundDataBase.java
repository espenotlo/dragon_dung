package backgrounds;

import java.util.ArrayList;

public class BackgroundDataBase {
    private final ArrayList<Background> backgrounds;

    public BackgroundDataBase() {
        backgrounds = new ArrayList<>();
        backgrounds.add(new Background("Outlander","You grew up in the wilds, far from civilization and the comforts of town and technology. " +
                "You’ve witnessed the migration of herds larger than forests, survived weather more extreme than any city-dweller could comprehend, " +
                "and enjoyed the solitude of being the only thinking creature for miles in any direction. The wilds are in your blood, whether you were a nomad, " +
                "an explorer, a recluse, a hunter-gatherer, or even a marauder. Even in places where you don’t know the specific features of the terrain, " +
                "you know the ways of the wild.",
                new String[] {"Wanderer","Remember places you've visited, and find food for up to six people per day."}
                ,"Athletics, Survival, Instrument, Language","Quarterstaff, Hunting Trap, Traveler's Clothes, Hunting Trophy",10));
        backgrounds.add(new Background("Soldier","War has been your life for as long as you care to remember. " +
                "You studied the use of weapons and armor, learned basic survival techniques, including how to stay alive on the battlefield. " +
                "You might have been part of a standing national army or a mercenary company, or a local militia."
                , new String[] {"Military Rank","You have a military rank from your career as a soldier. " +
                "Soldiers loyal to your former military organization still recognize your authority and influence, " +
                "and they defer to you if they are of a lower rank. " +
                "You can invoke your rank to exert influence over other soldiers and requisition simple equipment or horses for temporary use. " +
                "You can also usually gain access to friendly military encampments and fortresses where your rank is recognized."}
                , "Athletics, Intimidation, Gaming Set, Vehicles(land)", "Insignia of Rank, Battle Trophy, Gaming Set, Common Clothes"
                , 10));
        backgrounds.add(new Background("Criminal","You are an experienced criminal with a history of breaking the law. " +
                "You have spent a lot of time among other criminals and still have contacts within the criminal underworld. " +
                "You’re far closer than most people to the world of murder, theft, and violence that pervades the underbelly of civilization, " +
                "and you have survived up to this point by flouting the rules and regulations of society."
                , new String[] {"Criminal Contact", "You have a reliable and trustworthy contact who acts as your liaison to a network of other criminals. " +
                "You know how to get messages to and from your contact, even over great distances; specifically, you know the local messengers, " +
                "corrupt caravan masters, and seedy sailors who can deliver messages for you."}
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
