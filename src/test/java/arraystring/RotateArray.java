package arraystring;

/*
https://leetcode.com/problems/rotate-array/
ON
O1
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1) {
            return;
        }
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }
    }
}
