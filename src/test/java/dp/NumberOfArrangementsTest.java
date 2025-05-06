package dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
Case n=17 is to compare space performance. For array, we need to always create the memo with fix of N+1
But with Map we only add new item  when there is a solution to
 */
class NumberOfArrangementsTest {

    @Test
    void testIt_withArray() {

        NumberOfArrangements numberOfArrangements = new NumberOfArrangements();
        assertEquals(8, numberOfArrangements.solveWithArray(6));
        assertEquals(12, numberOfArrangements.solveWithArray(7));
        assertEquals(1107, numberOfArrangements.solveWithArray(17));
    }

}