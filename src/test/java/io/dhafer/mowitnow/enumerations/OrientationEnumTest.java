package io.dhafer.mowitnow.enumerations;

import org.junit.Test;

import static org.junit.Assert.*;

public class OrientationEnumTest {

    @Test
    public void changeDirectionLeft() {
        OrientationEnum orientationEnum = OrientationEnum.N;
        assertEquals(orientationEnum.changeDirection(ActionEnum.G), OrientationEnum.W);
    }

    @Test
    public void changeDirectionRight() {
        OrientationEnum orientationEnum = OrientationEnum.N;
        assertEquals(orientationEnum.changeDirection(ActionEnum.D), OrientationEnum.E);
    }


    @Test
    public void changeDirectionForward() {
        OrientationEnum orientationEnum = OrientationEnum.N;
        assertEquals(orientationEnum.changeDirection(ActionEnum.A), OrientationEnum.N);
    }
}
