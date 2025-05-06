package dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TribonacciTest {

    @Test
    void testIt() {

        Tribonacci tribonacci = new Tribonacci();
        assertEquals(4, tribonacci.tribonacci(4));
        assertEquals(1389537, tribonacci.tribonacci(25));
    }

}