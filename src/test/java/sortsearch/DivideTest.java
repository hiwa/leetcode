package sortsearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivideTest {

    @Test
    void testIt() {

        Divide divide = new Divide();
        assertEquals(-3, divide.divide(-10, 3));
        assertEquals(-5, divide.divide(-30, 6));

    }
}