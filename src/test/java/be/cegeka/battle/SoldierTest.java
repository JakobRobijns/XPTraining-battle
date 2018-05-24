package be.cegeka.battle;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SoldierTest {

    @Test
    public void construction_ASoldierMustHaveAName() {
        Sword sword = new Sword();
        Soldier soldier = new Soldier("name", sword);

        assertThat(soldier.getName()).isEqualTo("name");
    }

    @Test(expected = IllegalArgumentException.class)
    public void construction_ASoldierMustHaveAName_CannotBeNull() {
        Sword sword = new Sword();
        new Soldier(null, sword);
    }

    @Test(expected = IllegalArgumentException.class)
    public void construction_ASoldierMustHaveAName_CannotBeEmpty() {
        Sword sword = new Sword();
        new Soldier("", sword);
    }

    @Test(expected = IllegalArgumentException.class)
    public void construction_ASoldierMustHaveAName_CannotBeBlank() {
        Sword sword = new Sword();
        new Soldier("   ", sword);
    }

    @Test
    public void equipSoldierWithWeapon() {
        Sword sword = new Sword();
        Axe axe = new Axe();
        Soldier jan = new Soldier("Jan", sword);
        jan.equipWeapon(axe);

        assertEquals(axe, jan.getWeapon());
    }

    @Test
    public void createSoldierWithoutWeapon() {
        Soldier jan = new Soldier("Jan");

        assertEquals(Barefist.class, jan.getWeapon().getClass());
    }

    @Test
    public void fightSoldierEqualWeapon_ReturnsCorrectWinner() {
        Soldier jan = new Soldier("Jan");
        Soldier tom = new Soldier("Tom");
        Soldier winner = jan.fight(tom);

        assertEquals(jan, winner);
    }

    @Test
    public void fightSoldierOneHasBetterWeapon_ReturnsCorrectWinner() {
        Axe axe = new Axe();
        Sword sword = new Sword();
        Soldier jan = new Soldier("Jan", axe);
        Soldier tom = new Soldier("Tom", sword);
        Soldier winner = jan.fight(tom);

        assertEquals(jan, winner);
    }

    @Test
    public void fightSoldierWithAdvancedWeapons_ReturnsCorrectWinner() {
        BroadAxe broadAxe = new BroadAxe();
        Trident trident = new Trident();
        Soldier jan = new Soldier("Jan", broadAxe);
        Soldier tom = new Soldier("Tom", trident);
        Soldier winner = jan.fight(tom);

        assertEquals(jan, winner);
    }

    @Test
    public void fightSoldierWhereOneHasPotion_ReturnsCorrectWinner() {
        MagicPotion magicPotion = new MagicPotion();
        Trident trident = new Trident();
        Soldier jan = new Soldier("Jan", magicPotion);
        Soldier tom = new Soldier("Tom", trident);
        Soldier winner = jan.fight(tom);

        assertEquals(jan, winner);
    }

    @Test
    public void fightSoldierEqualWeapon_BothGetWounded() {
        Trident trident = new Trident();
        Soldier jan = new Soldier("Jan", trident);
        Soldier tom = new Soldier("Tom", trident);
        jan.fight(tom);

        assertThat(jan.getStatusWounded()).isTrue();
        assertThat(tom.getStatusWounded()).isTrue();
    }

    @Test
    public void fightsoldierEqualWeapon_OneGetsWounded_OneDies() {
        Trident trident = new Trident();
        Soldier jan = new Soldier("Jan", trident, true);
        Soldier tom = new Soldier("Tom", trident);
        jan.fight(tom);
    }

}