package arraystring;

/*
https://leetcode.com/problems/product-of-array-except-self/
  [2,3,4] > [12,8,6]

  solution 1 with division: multiple all elements => x=2*3*4=24. For each element result = x/element result[0] = 24/2=12
  edge cases:
      1. If one item is zero then [0,1,2] > [2,0,0]
      1. If more than one item is zero then [0,0,2] > [0,0,0]
  Time : O(N) + O(N) = O(N)
  space : O(1)
  But in this problem we are not allowed to use division

  Solution 2: By using Left and Right Arrays.
  Time : O(N)
  space : L[] : O(N) + R[] : O(N) = O(N)

*/
class ProductExceptSelf {

    // nums = [2,3,4]
    public int[] productExceptSelf(int[] nums) {

        int length = nums.length;

        int[] result = new int[length];
        int[] left = new int[length];
        int[] right = new int[length];

        left[0] = 1;
        //[2,3,4] > L= [1,2,6]
        for (int i = 1; i < length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        //[2,3,4] > R= [12,4,1]
        right[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        // [1,2,6] * [12,4,1] = [12,8,6]
        for (int i = 0; i < length; i++) {
            result[i] = left[i] * right[i];
        }
        return result;
    }

    public int[] productExceptSelfWithDivision(int[] nums) {

        int[] result = new int[nums.length];
        int totalMultiplication = nums[0];
        int zeroCounter = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != 0) {
                totalMultiplication = totalMultiplication * nums[i];
            } else {
                zeroCounter++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (zeroCounter == 0) {
                result[i] = totalMultiplication / nums[i];
            }
            // [0,0,1,2,3] => [0,0,0,0,0]
            else if (nums[i] != 0 || zeroCounter > 1) {
                result[i] = 0;
            } else {
                // [0,1,2] > [2,0,0]
                result[i] = totalMultiplication;
            }

        }
        return result;
    }
}

