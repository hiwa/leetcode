package arraystring;

//https://leetcode.com/problems/move-zeroes/ O(n), O(1)
public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != pos) {
                    nums[pos] = nums[i];
                    nums[i] = 0;
                }
                pos++;
            }
        }
    }


    // MY solution O(n), O(1)
    // Count zeros on left side. When we see a non-zero item, move it to left by leftZeroCounter
    //[1,0,0,2,3] => [1,2,3,0,0]
    public void moveZeroes1(int[] nums) {
        int leftZeroCounter = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                leftZeroCounter++;
            } else if (leftZeroCounter > 0) {
                nums[i - leftZeroCounter] = nums[i];
                nums[i] = 0;
            }

        }
    }
}
