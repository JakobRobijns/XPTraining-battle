package be.cegeka.battle;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Headquarters {

    private Map<Integer, String> armies = new HashMap<>();

    public int reportArmy(String armyName) {
        int randomInt;
        do {
            randomInt = ThreadLocalRandom.current().nextInt();
        } while (armies.containsKey(randomInt));
        armies.put(randomInt, armyName);
        return randomInt;
    }

    public Map<Integer, String> getArmies() {
        return armies;
    }
}
