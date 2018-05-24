package be.cegeka.battle;


public interface IHeadquarters {

    int reportEnlistment(String soldierName, int armyIdentifier);

    void reportCasualty(int soldierId);

    void reportVictory(int remainingNumberOfSoldiers, int armyIdentifier);

    int reportArmy(String armyName);
}
