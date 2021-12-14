package entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShipTest {
    int xpoint, ypoint;
    Ship ship;

    @BeforeEach
    void setUp() {
        ship = new Ship(xpoint, ypoint);
    }

    @Test
    void creat() {
        assertNotNull(ship);
    }

    @Test
    void speed() {
        assertEquals(2, ship.getSpeed());
    }

}