package screen;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreditScreenTest {
    int width = 200;
    int height = 200;
    int fps = 60;
    CreditScreen creditScreen;

    @BeforeEach
    void setUp() {
        creditScreen = new CreditScreen(width, height, fps);
    }

    @Test
    void creat() {
        assertNotNull(creditScreen);
    }

}