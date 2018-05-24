package be.cegeka.battle;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

public class ArmyTest {

    @Test
    public void firstSoldierOfArmyMustBeFrontMan() {
        Army army = new Army();
        army.enlist(new Soldier("Soldier1"));
        army.enlist(new Soldier("Soldier2"));

        ArrayList<Soldier> soldiers = army.getSoldiers();
        assertTrue(soldiers.get(0).getIsFrontman());
    }
}
