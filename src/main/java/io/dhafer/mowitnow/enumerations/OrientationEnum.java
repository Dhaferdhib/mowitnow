package io.dhafer.mowitnow.enumerations;

public enum OrientationEnum {
    N("NORTH"),
    E("EST"),
    S("SOUTH"),
    W("WEST");
    private String abrevation;

    OrientationEnum(String abrevation) {
        this.abrevation = abrevation;
    }

    public String getAbrevation() {
        return abrevation;
    }

    public OrientationEnum changeDirection(ActionEnum actionEnum) {
        if (actionEnum.equals(ActionEnum.D)) {
            return values()[(this.ordinal() + 1) % values().length];
        } else if (actionEnum.equals(ActionEnum.G)) {
            int size;
            if (this.ordinal() == 0)
                size = values().length;
            else
                size = this.ordinal();
            return values()[(size - 1) % values().length];
        }
        return this;
    }


}
