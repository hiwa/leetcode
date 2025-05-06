package arraystring;

/*

At each step, calculate sum. If sum < 0 , ignore sum and only consider num. So sum = max(sum+num, num). and update result.
O(N), O(1)
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            result = Math.max(result, sum);
        }
        return result;
    }
}
