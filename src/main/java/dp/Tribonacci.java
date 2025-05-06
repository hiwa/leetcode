package dp;

public class Tribonacci {

    public int tribonacci(int n) {

        int[] dp = new int[n+1];

        if (dp[n] > 0) {
            return dp[n];
        }
        if (n==0) {
            dp[n] = n;
            return n;
        }
        if (n==1 || n==2) {
            dp[n] = 1;
            return dp[n];
        }
        dp[n] = tribonacci(n-1) + tribonacci(n-2) + tribonacci(n-3);
        return dp[n];
    }
}
