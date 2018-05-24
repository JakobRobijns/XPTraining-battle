package be.cegeka.battle;

import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Test;

public class HeadquartersTest {

    @Test
    public void reportArmyAddsIdentifier() {
        Headquarters headquarters = new Headquarters();
        int identifier = headquarters.reportArmy("Army");
        Map<Integer, String> armies = headquarters.getArmies();
        assertTrue(armies.containsKey(identifier));
    }
}
