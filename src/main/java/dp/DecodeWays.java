package dp;

public class DecodeWays {

    /*
    https://leetcode.com/problems/decode-ways/discuss/30358/Java-clean-DP-solution-with-explanation
    O(N), O(N)
     */
        public int numDecodings(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            int n = s.length();
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = s.charAt(0) != '0' ? 1 : 0;
            for (int i = 2; i <= n; i++) {
                int first = Integer.parseInt(s.substring(i - 1, i));
                int second = Integer.parseInt(s.substring(i - 2, i));
                if (first != 0) {
                    dp[i] += dp[i-1];
                }
                if (second >= 10 && second <= 26) {
                    dp[i] += dp[i-2];
                }
            }
            return dp[n];
        }


    /*
    n=123

    f(0) = -                         count = 1 (boiler)
    f(1) = 1                         count = 1
    f(2) = (1,2), (12)               count = 2
    f(3) = (1,2,3), (1,23), (12,3)   count = 3*
    f(3) = f(2) + f(1)
    f(n) = f(n-1) + f(n-2)

    Instead of keeping an array of all previous states, we only store the two last ones.

    Time : O(N) for the loop which is length of input String. (Not sure! we have also substring inside the loop which costs another O(N)
    Space : O(1) As we use only constant variables, no arrays
    https://leetcode.com/problems/decode-ways/solution/
    approach 3
 */
    public int numberOfDecodeWaysApproach3(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        if (s.charAt(0) == '0') {
            return 0;
        }
        /*

           |-twoBackState-|-OneBackState-|-Current-|
           => After each loop they shift to right by one |-twoBackState (Released)-|-twoBackState (last OneBackState) -|-oneBackState (last Current)-| new currentState

         */
        // to simplify the situation, imagine we are in approach 2 and this is dp[0]
        int twoBackState = 1;
        // dp[1]
        int oneBackState = 1;

        for (int i = 1; i < s.length(); i++) {
            // dp[n]
            int currentState = 0;
            if (s.charAt(i) != '0') {
                // We can say currentState= oneBackState, but += is more meaningful.
                currentState += oneBackState;
            }
            int twoDigits = Integer.parseInt(s.substring(i - 1, i + 1));
            if (twoDigits >= 10 && twoDigits <= 26) {
                currentState += twoBackState;
            }
            twoBackState = oneBackState;
            oneBackState = currentState;
        }
        // It's equal to last currentState (remember dp[n]) after loop is done.
        return oneBackState;
    }

    /*
        n=123

        f(0) = -                         count = 1 (boiler)
        f(1) = 1                         count = 1
        f(2) = (1,2), (12)               count = 2
        f(3) = (1,2,3), (1,23), (12,3)   count = 3*
        f(3) = f(2) + f(1)
        f(n) = f(n-1) + f(n-2)

        Time : O(N)
        Space : O(N)
        https://leetcode.com/problems/decode-ways/solution/
        approach 2
     */
    public int numberOfDecodeWaysApproach2(String s) {

        if (s.isEmpty()) {
            return 0;
        }
        //DP + tabulation (bottom-up approach)
        int[] numberOfDecodeWays = new int[s.length() + 1];

        //set to 1 as a boiler for next states of the problem
        numberOfDecodeWays[0] = 1;
        numberOfDecodeWays[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i < numberOfDecodeWays.length; i++) {
            // If we can decode next digit,
            if (s.charAt(i - 1) != '0') {
                numberOfDecodeWays[i] = numberOfDecodeWays[i - 1];
            }
            int twoDigits = Integer.parseInt(s.substring(i - 2, i));
            // if we can decode next two digits
            if (twoDigits >= 10 && twoDigits <= 26) {
                numberOfDecodeWays[i] += numberOfDecodeWays[i - 2];
            }
        }
        return numberOfDecodeWays[s.length()];
    }

}
