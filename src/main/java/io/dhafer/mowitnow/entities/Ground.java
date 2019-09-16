package io.dhafer.mowitnow.entities;

import io.dhafer.mowitnow.enumerations.ActionEnum;
import io.dhafer.mowitnow.enumerations.OrientationEnum;

import java.util.Objects;

public class Ground {

    private Position maxPosition;
    private Position mowerPosition;
    private OrientationEnum orientation;

    public Ground(Position maxPosition, Position mowerPosition, OrientationEnum orientation) {
        this.maxPosition = maxPosition;
        this.mowerPosition = mowerPosition;
        this.orientation = orientation;
    }

    public Position getMaxPosition() {
        return maxPosition;
    }

    public void setMaxPosition(Position maxPosition) {
        this.maxPosition = maxPosition;
    }

    public Position getMowerPosition() {
        return mowerPosition;
    }

    public void setMowerPosition(Position mowerPosition) {
        this.mowerPosition = mowerPosition;
    }

    public OrientationEnum getOrientation() {
        return orientation;
    }

    public void setOrientation(OrientationEnum orientation) {
        this.orientation = orientation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ground ground = (Ground) o;
        return Objects.equals(maxPosition, ground.maxPosition) &&
                Objects.equals(mowerPosition, ground.mowerPosition) &&
                orientation == ground.orientation;
    }


    @Override
    public int hashCode() {
        return Objects.hash(maxPosition, mowerPosition, orientation);
    }

    private boolean isUnauthorizedMove() {
        return ((getMaxPosition().getX().equals(getMowerPosition().getX()) && this.getOrientation().equals(OrientationEnum.E)) ||
                (getMaxPosition().getX() == 0 && this.getOrientation().equals(OrientationEnum.W)) ||
                (getMaxPosition().getY().equals(getMowerPosition().getY()) && this.getOrientation().equals(OrientationEnum.N)) || (getMaxPosition().getY() == 0 && this.getOrientation().equals(OrientationEnum.S)));

    }

    public void moveMower(ActionEnum actionEnum) {
        if (actionEnum.equals(ActionEnum.A)) {
            if (!isUnauthorizedMove()) {
                this.changeMowerPosition();
            }
        } else {
            this.setOrientation(this.orientation.changeDirection(actionEnum));
        }
    }

    private void changeMowerPosition() {
        if (this.orientation.equals(OrientationEnum.N))
            this.mowerPosition.incrementY();

        if (this.orientation.equals(OrientationEnum.E))
            this.mowerPosition.incrementX();

        if (this.orientation.equals(OrientationEnum.W))
            this.mowerPosition.decrementX();

        if (this.orientation.equals(OrientationEnum.S))
            this.mowerPosition.decrementY();
    }

    @Override
    public String toString() {
        return "Ground{" +
                "mowerPosition=" + mowerPosition +
                ", orientation=" + orientation +
                '}';
    }
}
