package be.cegeka.battle;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

public class ArmyTest {

    @Test
    public void firstSoldierOfArmyMustBeFrontMan_Test() {
        Army army = new Army();
        army.enlist(new Soldier("Soldier1"));
        army.enlist(new Soldier("Soldier2"));

        ArrayList<Soldier> soldiers = army.getSoldiers();
        assertTrue(soldiers.get(0).getIsFrontman());
    }


    @Test
    public void DefenderWins_Test() {
        Army army1 = new Army();
        Army army2 = new Army();
        // Hier automatisch valse gegevens invullen?
        army1.enlist(new Soldier("Jan", new Spear()));
        army1.enlist(new Soldier("Piet", new Spear()));
        army1.enlist(new Soldier("Joris", new Spear()));
        army1.enlist(new Soldier("Korneel"));

        army2.enlist(new Soldier("Jan", new Axe()));
        army2.enlist(new Soldier("Piet", new Axe()));
        army2.enlist(new Soldier("Joris"));
        army2.enlist(new Soldier("Korneel"));

        assertFalse(army1.engage(army2));
    }

    @Test
    public void AttackerWins_Test() {
        Army army1 = new Army();
        Army army2 = new Army();
        // Hier automatisch valse gegevens invullen?
        army1.enlist(new Soldier("Jan", new Spear()));
        army1.enlist(new Soldier("Piet", new Spear()));
        army1.enlist(new Soldier("Joris", new Axe()));
        army1.enlist(new Soldier("Korneel"));

        army2.enlist(new Soldier("Jan", new Spear()));
        army2.enlist(new Soldier("Piet", new Spear()));
        army2.enlist(new Soldier("Joris"));
        army2.enlist(new Soldier("Korneel"));

        assertTrue(army1.engage(army2));
    }


}
