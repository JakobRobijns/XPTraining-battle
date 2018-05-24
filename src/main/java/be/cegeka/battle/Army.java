package be.cegeka.battle;

import java.util.ArrayList;

public class Army {

    private IHeadquarters headquarters;

    private ArrayList<Soldier> soldiers = new ArrayList<Soldier>();

    private String name;

    private int identifier;

    public Army(IHeadquarters headquarters, String name) {
        this.headquarters = headquarters;
        this.name = name;

        this.identifier = headquarters.reportArmy(name);
    }

    public void enlist(Soldier soldier) {
        if (soldiers.isEmpty()) {
            soldier.setIsFrontman(true);
        }
        soldiers.add(soldier);
        soldier.setID(headquarters.reportEnlistment(soldier.getName(), identifier));
    }

    public ArrayList<Soldier> getSoldiers() {
        return soldiers;
    }

    public void setSoldiers(ArrayList<Soldier> soldiers) {
        this.soldiers = soldiers;
    }

    public boolean engage(Army defender) {
        ArrayList<Soldier> defendingSoldiers = defender.getSoldiers();
        while (bothArmiesContainsSoldier(defendingSoldiers)) {
            Soldier attackingSoldier = soldiers.get(0);
            Soldier defendingSoldier = defendingSoldiers.get(0);
            if (attackerWins(attackingSoldier, defendingSoldier)) {
                soldierDies(defendingSoldiers, defendingSoldier);
            } else {
                soldierDies(soldiers, attackingSoldier);
            }
        }

        if (armyIsDead()) {
            headquarters.reportVictory(defendingSoldiers.size(), identifier);
            return false;
        }
        defender.setSoldiers(defendingSoldiers);
        headquarters.reportVictory(soldiers.size(), identifier);
        return true;
    }

    private boolean armyIsDead() {
        return soldiers.size() == 0;
    }

    private void soldierDies(ArrayList<Soldier> defendingSoldiers, Soldier defendingSoldier) {
        headquarters.reportCasualty(defendingSoldier.getID());
        defendingSoldiers.remove(0);
    }

    private boolean attackerWins(Soldier attackingSoldier, Soldier defendingSoldier) {
        return attackingSoldier.fight(defendingSoldier) == attackingSoldier;
    }

    private boolean bothArmiesContainsSoldier(ArrayList<Soldier> defendingSoldiers) {
        return soldiers.size() != 0 && defendingSoldiers.size() != 0;
    }

    public void setHQ(IHeadquarters headquarters) {
        this.headquarters = headquarters;
    }

    public String getName() {
        return this.name;
    }

}
