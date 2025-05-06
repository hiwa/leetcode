package arraystring;
/*
https://leetcode.com/problems/next-permutation/solution/


[1,2,3,4,5] => [1,2,3,5,4]
[3,2,1] => No next permutation as its descending. So reset! reverse it : [1,2,3]
Brute force :
[1,2,5,4,3] => [1,2*,5(peak),4,3] (i=1) => [1,2*,5(peak),4, 3*(just bigger than 2*)] =swap> [1,3,5,4,2] =reverse from i=1 > [1,3,2,4,5]

T: O(N) couple of loops
M : O(1)

 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        //Compare x[i], x[i+1]
        // [1,2,5,4,3]
        int i = nums.length - 2;
        // Move backward, until we find the index of first item just before the most right peak (call it X)
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        // i = 1
        // if we cannot find X, no swap needed! Otherwise, find the just bigger item from end of the array bigger than X. And swap those two values.
        if (i >= 0) {
            int j = nums.length - 1;
            // move backward to find the just bigger item after the peak
            //[1,2*,5,4,3*]
            while (nums[j] <= nums[i]) {
                j--;
            }// j = 5
            swap(nums, i, j); // => [1,3,5,4,2]
        }
        // Reverse from i+1 which is the peak till end.
        // in case [3,2,1], i = -1, so we reverse the whole array.
        reverse(nums, i + 1); //=> [1,3,2,4,5]
    }

    private void reverse(int[] nums, int start) {
        int i = start;
        int j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
