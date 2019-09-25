package io.dhafer.mowitnow.enumerations;

public enum OrientationEnum {
    N("NORTH") {
        @Override
        public OrientationEnum changeDirection(ActionEnum actionEnum) {
            return this.nextMove(actionEnum, E, W);
        }
    },
    E("EST") {
        @Override
        public OrientationEnum changeDirection(ActionEnum actionEnum) {
            return this.nextMove(actionEnum, S, N);
        }
    },
    S("SOUTH"){
        @Override
        public OrientationEnum changeDirection(ActionEnum actionEnum) {
            return this.nextMove(actionEnum, W, E);

        }
    },
    W("WEST"){
        @Override
        public OrientationEnum changeDirection(ActionEnum actionEnum) {
            return this.nextMove(actionEnum, N, S);
        }
    };
    private String abrevation;

    OrientationEnum(String abrevation) {
        this.abrevation = abrevation;
    }

    public String getAbrevation() {
        return abrevation;
    }

    public abstract OrientationEnum changeDirection(ActionEnum actionEnum);

    public OrientationEnum nextMove(ActionEnum actionEnum,OrientationEnum rightOrientation, OrientationEnum leftOrientation ){
        switch (actionEnum) {
            case D:return rightOrientation;
            case G:return leftOrientation;
            default:return this;
        }
    }

}
