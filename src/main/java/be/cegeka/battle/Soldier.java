package be.cegeka.battle;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

import org.apache.commons.lang3.Validate;

public class Soldier {

    private final String name;

    private boolean isFrontman;

    public Soldier(String name) {
        Validate.isTrue(isNotBlank(name));

        this.name = name;
        this.isFrontman = false;
    }

    String getName() {
        return this.name;
    }

    public boolean getIsFrontman() {
        return isFrontman;
    }

    public void setIsFrontman(boolean isFrontman) {
        this.isFrontman = isFrontman;
    }

}
