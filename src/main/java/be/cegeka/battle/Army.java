package be.cegeka.battle;

import java.util.ArrayList;

public class Army {

    private ArrayList<Soldier> soldiers = new ArrayList<Soldier>();

    public void enlist(Soldier soldier) {
        if (soldiers.isEmpty()) {
            soldier.setIsFrontman(true);
        }
        soldiers.add(soldier);
    }

    public ArrayList<Soldier> getSoldiers() {
        return soldiers;
    }

    public void setSoldiers(ArrayList<Soldier> soldiers) {
        this.soldiers = soldiers;
    }

    public boolean engage(Army defender) {
        ArrayList<Soldier> defendingSoldiers = defender.getSoldiers();
        while (soldiers.size() != 0 && defendingSoldiers.size() != 0) {
            Soldier attackingSoldier = soldiers.get(0);
            Soldier defendingSoldier = defendingSoldiers.get(0);
            if (attackingSoldier.fight(defendingSoldier) == attackingSoldier) {
                defendingSoldiers.remove(0);
            } else {
                soldiers.remove(0);
            }
        }

        if (soldiers.size() == 0) {
            return false;
        }
        defender.setSoldiers(defendingSoldiers);
        return true;
    }

}
