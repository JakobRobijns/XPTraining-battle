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

}
