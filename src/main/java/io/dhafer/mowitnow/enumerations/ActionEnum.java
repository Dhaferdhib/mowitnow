package io.dhafer.mowitnow.enumerations;

public enum ActionEnum {
    D("DROITE"),
    G("GAUCHE"),
    A("AVANCER");

    private String abreviation;

    ActionEnum(String abreviation) {
        this.abreviation = abreviation;
    }

    public String getAbreviation() {
        return abreviation;
    }
}
