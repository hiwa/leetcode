package dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CoinChangeTest {

    @Test
    void testIt() {

        CoinChange solution = new CoinChange();//
        Assertions.assertEquals(3, solution.coinChange(new int[]{1, 2, 5}, 11));
        Assertions.assertEquals(4, solution.coinChange(new int[]{1, 2, 3}, 11));
        Assertions.assertEquals(3, solution.coinChange(new int[]{1, 2, 3, 5}, 15));
        Assertions.assertEquals(4, solution.coinChange(new int[]{1, 2, 3, 4}, 15));
        Assertions.assertEquals(-1, solution.coinChange(new int[]{3}, 11));
    }

}