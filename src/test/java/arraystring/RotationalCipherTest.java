package arraystring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RotationalCipherTest {

    @Test
    void testIt() {
        RotationalCipher rotationalCipher = new RotationalCipher();
        assertEquals("cdeb*129", rotationalCipher.rotationalCipher("abcz*907", 2));
        assertEquals("_+=", rotationalCipher.rotationalCipher("_+=", 5));
    }

}