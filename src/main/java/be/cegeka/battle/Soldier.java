package be.cegeka.battle;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

import org.apache.commons.lang3.Validate;

public class Soldier {

    private final String name;

    private Weapon weapon;

    public Soldier(String name) {
        Validate.isTrue(isNotBlank(name));

        this.name = name;
        this.weapon = new Barefist();
    }

    public Soldier(String name, Weapon weapon) {
        Validate.isTrue(isNotBlank(name));

        this.name = name;
        this.weapon = weapon;
    }

    String getName() {
        return this.name;
    }

    public void equipWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Weapon getWeapon() {
        return weapon;
    }


}
