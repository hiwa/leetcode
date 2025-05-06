package dp;

import java.util.Arrays;

/*
https://leetcode.com/problems/coin-change/
Brute force : O(S^n) Exponential (Time limit exceeded)

Solution: Use DP.
T: O(S*coins.size) (For the loop)
M : O(S) for the cache
 */
class CoinChange {
    public int coinChange(int[] coins, int sum) {
        // store states. IN DP we should find the proper state and its initial value.
        // In this case, state(s) is minimum number of coins to create s sum.
        int[] cache = new int[sum + 1];

        // initiate each solution with maximum number of coins regarding input sum.
        Arrays.fill(cache, sum + 1);
        //this is trivial. 0 coins need to have sum 0.
        cache[0] = 0;
        for (int i = 1; i <= sum; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    cache[i] = Math.min(cache[i], 1 + cache[i - coin]);
                }
            }
        }
        return cache[sum] > sum ? -1 : cache[sum];
    }
}
