package arraystring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThreeSumTest {

    @Test
    void testIt() {
        ThreeSum threeSum = new ThreeSum();
        assertEquals(1, threeSum.threeSum(new int[] {-2,0,0,2,2}).size());

    }

    @Test
    void testIt2() {
        ThreeSum threeSum = new ThreeSum();
        assertEquals(2, threeSum.threeSum(new int[] {-4,-2, 0,2,2}).size());

    }

}