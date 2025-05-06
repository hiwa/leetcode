package dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BestTimeToBuyAndSell2Test {

    @Test
    void testIt() {
        BestTimeToBuyAndSell2 bestTimeToBuyAndSell2 = new BestTimeToBuyAndSell2();
        assertEquals(7, bestTimeToBuyAndSell2.maxProfit(new int[]{7,1,5,3,6,4}));
        assertEquals(5, bestTimeToBuyAndSell2.maxProfit(new int[]{1,2,3,4,5,6}));
    }
    @Test
    //Not very interesting
    void testIt_solution_Hiwa() {
        BestTimeToBuyAndSell2 bestTimeToBuyAndSell2 = new BestTimeToBuyAndSell2();
        assertEquals(7, bestTimeToBuyAndSell2.maxProfitHiwa(new int[]{7,1,5,3,6,4}));
    }

}