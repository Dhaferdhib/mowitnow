package io.dhafer.mowitnow.entities;

import java.util.Objects;

public class Position {
    private Long x;
    private Long y;

    public Position(Long x, Long y) {
        this.x = x;
        this.y = y;
    }

    public Long getX() {
        return x;
    }

    public void setX(Long x) {
        this.x = x;
    }

    public Long getY() {
        return y;
    }

    public void setY(Long y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return Objects.equals(x, position.x) &&
                Objects.equals(y, position.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public void incrementX() {
        this.x++;
    }

    public void incrementY() {
        this.y++;
    }

    public void decrementX(){
        this.x--;
    }

    public void decrementY(){
        this.y--;
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
