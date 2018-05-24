package be.cegeka.battle;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class WeaponTest {

    @Test
    public void createWeapon() {
        BroadAxe broadAxe = new BroadAxe();
    }

    @Test
    public void broadAxeReturnsCorrectDamage() {
        BroadAxe broadAxe = new BroadAxe();

        assertEquals(5, broadAxe.getDamage());
    }

    @Test
    public void twoHandedSwordReturnsCorrectDamage() {
        TwoHandedSword twoHandedSword = new TwoHandedSword();

        assertEquals(5, twoHandedSword.getDamage());
    }

    @Test
    public void tridentReturnsCorrectDamage() {
        Trident trident = new Trident();

        assertEquals(6, trident.getDamage());
    }

    @Test
    public void magicPotionReturnsCorrectDamage() {
        MagicPotion magicPotion = new MagicPotion();

        assertEquals(0, magicPotion.getDamage());
    }
}
