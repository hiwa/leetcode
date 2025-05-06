package dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecodeWaysTest {

    @Test
    void testIt() {
        DecodeWays decodeWays = new DecodeWays();
        assertEquals(3, decodeWays.numberOfDecodeWaysApproach2("123"));
        assertEquals(1, decodeWays.numberOfDecodeWaysApproach2("120"));
        assertEquals(1, decodeWays.numberOfDecodeWaysApproach3("1201"));
        assertEquals(3, decodeWays.numberOfDecodeWaysApproach3("1234"));

        assertEquals(3, decodeWays.numDecodings("1234"));
    }
}