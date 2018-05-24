package be.cegeka.battle;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

import org.apache.commons.lang3.Validate;

public class Soldier {

    private final String name;

    private Weapon weapon;

    private boolean isFrontman = false;

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

    public boolean getIsFrontman() {
        return isFrontman;
    }

    public void setIsFrontman(boolean isFrontman) {
        this.isFrontman = isFrontman;
    }

    public Soldier fight(Soldier defender) {
        Soldier attacker = this;
        MagicPotion magicPotion = new MagicPotion();
        int defenderDamage = defender.getWeapon().getDamage();
        int attackerDamage = attacker.getWeapon().getDamage();

        if (defender.getWeapon().getClass() == magicPotion.getClass()) {
            if (attackerDamage % 2 == 0) {
                defenderDamage = 10;
            }
        }
        if (attacker.getWeapon().getClass() == magicPotion.getClass()) {
            if (defenderDamage % 2 == 0) {
                attackerDamage = 10;
            }
        }

        if (defenderDamage > attackerDamage) {
            return defender;
        } else {
            return attacker;
        }
    }

}
