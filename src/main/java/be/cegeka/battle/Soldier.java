package be.cegeka.battle;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

import org.apache.commons.lang3.Validate;

public class Soldier {

    private final String name;

    private Weapon weapon;

    private boolean wounded = false;

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

    public Soldier(String name, Weapon weapon, Boolean wounded) {
        Validate.isTrue(isNotBlank(name));

        this.name = name;
        this.weapon = weapon;
        this.wounded = wounded;
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

    public boolean isWounded() {
        return true;
    }

    public boolean getStatusWounded() {
        return this.wounded;
    }

    public void setIsFrontman(boolean isFrontman) {
        this.isFrontman = isFrontman;
    }

    public Soldier fight(Soldier defender) {
        Soldier attacker = this;
        Weapon weaponAttacker = attacker.getWeapon();
        Weapon weaponDefender = defender.getWeapon();
        int defenderDamage = defender.getWeapon().getDamage();
        int attackerDamage = attacker.getWeapon().getDamage();

        // Kijken of attacker een bonus kan krijgen
        attackerDamage += checkAdvantage(weaponAttacker, weaponDefender);

        // Kijken of iemand magicpotion heeft
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

        // Winnaar bepalen
        if (defenderDamage > attackerDamage) {
            return defender;
        } else if (defenderDamage == attackerDamage) {
            if (defender.wounded) {
                // defender.die();
            } else {
                defender.wounded = isWounded();
            }
            if (attacker.wounded) {
                // attacker.die();
            } else {
                attacker.wounded = isWounded();
            }
        }
        return attacker;
    }

    public int checkAdvantage(Weapon weaponAttacker, Weapon weaponDefender) {
        int advantage = 0;

        if ((weaponAttacker instanceof Axe && weaponDefender instanceof Spear)
                || (weaponAttacker instanceof Spear && weaponDefender instanceof Sword)
                || (weaponAttacker instanceof Sword && weaponDefender instanceof Axe)) {
            advantage = 3;
        }

        return advantage;
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
