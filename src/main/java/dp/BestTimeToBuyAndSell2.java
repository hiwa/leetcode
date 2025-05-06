package dp;

/*

https://leetcode.com/problems/best-time-to-buy-and-sell-stock/discuss/1735493/JavaC++-best-ever-EXPLANATION-could-possible/1246047

T: O(N)
Space  : O(1)

*/
public class BestTimeToBuyAndSell2 {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            //If today price is higher than yesterday sell it!
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }

    /*
    My solution not very nice compared to the above one
    How to test : [7,1,5,3,6,4]

    i>>>    0   1   2   3   4   5
    prcI    7   1   5   3   6   4
    minP    7   1   +   3   +   4
    curr    0   0   4   0   3   0
    maxP    0   0   4   4   7   0
            */
    public int maxProfitHiwa(int[] prices) {

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0, pricesLength = prices.length; i < pricesLength; i++) {
            int price = prices[i];
            int currentMaxProfit = 0;
            minPrice = Math.min(minPrice, price);
            currentMaxProfit = Math.max(currentMaxProfit, price - minPrice);
            // If we gain some profit
            if (currentMaxProfit > 0) {
                // To stay on the same day to give possibility to buy again!
                // in this case needed [1,2,3] At day 2 we should sell and buy again to gain max which is 2. Otherwise, we buy at day 1 and sell at day
                // 2 and, we miss the profit from day 2 to day 3
                i--;
                maxProfit += currentMaxProfit;
                minPrice = Integer.MAX_VALUE;
            }
        }
        return maxProfit;
    }
}
