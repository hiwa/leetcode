package dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BestTimeToBuyAndSellTest {

    @Test
    void testIt() {
        BestTimeToBuyAndSell bestTimeToBuyAndSell = new BestTimeToBuyAndSell();
        assertEquals(5, bestTimeToBuyAndSell.maxProfit(new int[]{7,1,5,3,6,4}));
        assertEquals(0, bestTimeToBuyAndSell.maxProfit(new int[]{7,6,4,3,1}));

    }

}