package dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UniquePathsIITest {

    @Test
    /*   input              result
        O   0   0      1    1   1       1  1  1
        0   1   0      1    0   0 =>    1  0  1
        0   0   ?      1    0   ?       1  1  2*
     */
    void testIt() {
        UniquePathsII uniquePathsII = new UniquePathsII();
        int[][] input = {{0,0,0},{0,1,0}, {0,0,0}};
        assertEquals(2, uniquePathsII.uniquePathsWithObstacles1(input));
    }

    @Test
    /*   input              result
        O   0   0      1    1   1       1  1  1
        0   1   0      1    0   0 =>    1  0  1
        0   0   ?      1    0   ?       1  1  2*
     */
    void testIt2() {
        UniquePathsII uniquePathsII = new UniquePathsII();
        int[][] input = {{0,0,0},{0,1,0}, {0,0,0}};
        assertEquals(2, uniquePathsII.uniquePathsWithObstacles2(input));
    }
}