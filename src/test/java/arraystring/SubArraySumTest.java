package arraystring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubArraySumTest {

    @Test
    void testIt() {
        SubArraySum subArraySum = new SubArraySum();
        assertEquals(3, subArraySum.subarraySumBruteForce(new int[]{1, 2, 3, 0}, 3));
        assertEquals(3, subArraySum.subarraySumBruteForce(new int[]{1, 1, 1, 2, 3}, 3));
    }

}