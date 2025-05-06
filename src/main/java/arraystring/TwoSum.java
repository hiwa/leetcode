package arraystring;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/two-sum/

T : O(N)
M : O(N)
 */
public class TwoSum {
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> numsIndices = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numsIndices.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int compliment = target - nums[i];
            if (numsIndices.containsKey(compliment)) {
                return new int[]{i, numsIndices.get(compliment)};
            }
        }
        return null;
    }
/*
T : O(N)
M : O(N)
 */
    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> numsIndices = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int compliment = target - nums[i];
            if (numsIndices.containsKey(compliment)) {
                return new int[]{i, numsIndices.get(compliment)};
            }
            numsIndices.put(nums[i], i);
        }
        return null;
    }
}
