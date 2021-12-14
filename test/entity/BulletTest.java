package entity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BulletTest {

    Bullet bullet;

    @BeforeEach // 생명주기 anotation
    void setUp() {
        bullet = new Bullet(0, 0, 3);
    }

    @Test
    void creat(){
        assertNotNull(bullet);
    }

    @Test
    void update() {
        bullet.update();
        assertEquals(3, bullet.getPositionY());
    }

    @Test
    void setSpeed() {
        assertEquals(3, bullet.getSpeed());
    }

    @Test
    void getSpeed() {
        assertEquals(3, bullet.getSpeed());
    }
}