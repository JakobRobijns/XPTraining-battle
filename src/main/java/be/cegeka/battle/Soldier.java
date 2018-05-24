package be.cegeka.battle;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

import org.apache.commons.lang3.Validate;

public class Soldier {

    private final String name;

    private Weapon weapon;

    private boolean isFrontman = false;

    private int ID;

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
        int defenderDamage = defender.getWeapon().getDamage();
        int attackerDamage = attacker.getWeapon().getDamage();

        if (ifSoldierHasMagicPotion(defender)) {
            if (ifSoldierDamageIsEven(attackerDamage)) {
                defenderDamage = 10;
            }
        }
        if (ifSoldierHasMagicPotion(attacker)) {
            if (ifSoldierDamageIsEven(defenderDamage)) {
                attackerDamage = 10;
            }
        }

        if (defenderDamage > attackerDamage) {
            return defender;
        }
        return attacker;
    }

    private boolean ifSoldierDamageIsEven(int attackerDamage) {
        return attackerDamage % 2 == 0;
    }

    private boolean ifSoldierHasMagicPotion(Soldier soldier) {
        MagicPotion magicPotion = new MagicPotion();
        return soldier.getWeapon().getClass() == magicPotion.getClass();
    }

    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

}
