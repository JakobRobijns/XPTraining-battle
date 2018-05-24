package be.cegeka.battle;


public class BroadAxe extends Axe {

    Axe axe = new Axe();

    private int damage = axe.getDamage() + 2;

    public BroadAxe() {

    }

    @Override
    public int getDamage() {
        return damage;
    }

}
