package utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class DiceRoller {

    public DiceRoller() {
    }
    public int roll(String die) {
        int diceRoll = 0;
        int number = 1;
        int size = 0;
        int drop = 0;
        String[] mainParts;
        if (die.contains("k")) {
            String[] parts = die.split("k");
            mainParts = parts[0].split("d");
            drop = Integer.parseInt(mainParts[0]) - Integer.parseInt(parts[1]);
        } else {
            mainParts = die.split("d");
        }
        if (mainParts.length > 1) {
            number = Integer.parseInt(mainParts[0]);
            size = Integer.parseInt(mainParts[1]);
        } else {
            size = Integer.parseInt(mainParts[0]);
        }
        Random r = new Random();
        ArrayList<Integer> rolls = new ArrayList<>();
        while (rolls.size() < number) {
            rolls.add(r.nextInt(size) + 1);
        }
        for (int roll : rolls) {
            diceRoll += roll;
        }
        while (rolls.size() > number - drop) {
            diceRoll -= Collections.min(rolls);
            rolls.remove(Collections.min(rolls));
        }
        return diceRoll;
    }
}
