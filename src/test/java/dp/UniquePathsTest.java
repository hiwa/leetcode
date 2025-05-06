package dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UniquePathsTest {

    @Test
    /*
        O*    O1    O1
        ** => 1X => 12
        *D    1D    13
     */
    void testIt() {
        UniquePaths uniquePaths = new UniquePaths();
        assertEquals(3, uniquePaths.uniquePaths(3,2));
    }

    @Test
    void testIt_1() {
        UniquePaths uniquePaths = new UniquePaths();
        assertEquals(30421755, uniquePaths.uniquePaths(13,17));
    }
}