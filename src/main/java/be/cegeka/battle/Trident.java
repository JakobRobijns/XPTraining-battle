package be.cegeka.battle;


public class Trident extends Spear {

    Spear spear = new Spear();

    private int damage = spear.getDamage() * 3;

    public Trident() {

    }

    @Override
    public int getDamage() {
        return damage;
    }
}
