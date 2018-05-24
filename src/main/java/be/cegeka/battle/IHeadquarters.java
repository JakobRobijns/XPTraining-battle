package be.cegeka.battle;


public interface IHeadquarters {

    int ReportEnlistment(String soldierName);

    void ReportCasualty(int soldierId);

    void ReportVictory(int remainingNumberOfSoldiers);
}
