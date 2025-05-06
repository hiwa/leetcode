package dp;

/*

https://leetcode.com/problems/best-time-to-buy-and-sell-stock/discuss/1735493/JavaC++-best-ever-EXPLANATION-could-possible/1246047

T: O(N)
Space  : O(1)
 */
public class BestTimeToBuyAndSell {
    public int maxProfit(int[] prices) {

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }
}
