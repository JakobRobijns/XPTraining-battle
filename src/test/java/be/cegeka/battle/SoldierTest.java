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

}