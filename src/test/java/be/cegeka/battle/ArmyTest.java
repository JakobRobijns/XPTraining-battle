package be.cegeka.battle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class ArmyTest {

    private Army army1;

    private Army army2;

    private IHeadquarters hqMock;


    @Before
    public void setUp() throws Exception {
        army1 = new Army();
        army2 = new Army();
        hqMock = mock(IHeadquarters.class);
        army1.setHQ(hqMock);
        army2.setHQ(hqMock);
    }


    @Test
    public void firstSoldierOfArmyMustBeFrontMan_Test() {
        army1.enlist(new Soldier("Soldier1"));
        army1.enlist(new Soldier("Soldier2"));

        ArrayList<Soldier> soldiers = army1.getSoldiers();
        assertTrue(soldiers.get(0).getIsFrontman());
    }


    @Test
    public void DefenderWins_Test() {

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

    @Test
    public void soldierEnlists_isRegisteredToHQ() {

        army1.enlist(new Soldier("Jan", new Spear()));

        verify(hqMock).reportEnlistment("Jan");
    }


    @Test
    public void soldierEnlists_getIDfromHQ() {
        Soldier soldier = new Soldier("Jan", new Spear());
        when(hqMock.reportEnlistment(soldier.getName())).thenReturn(12);
        army1.enlist(soldier);

        assertEquals(12, soldier.getID());
    }


}
