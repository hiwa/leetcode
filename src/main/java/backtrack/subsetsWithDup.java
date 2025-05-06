package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

T : (2*N^2) (copy of each case *number of all cases)
M : O(N) for recursion call which is for current. size of current can be at most N, size of nums.
 */
public class subsetsWithDup {
    // [1,1] -> [[],[1],[1,1]] (Avoid duplicating [1])
    List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;

    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, int start) {
        result.add(new ArrayList<>(current));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i - 1] == nums[i]) break;
            current.add(nums[i]);
            backtrack(result, current, nums, i + 1);
            current.remove(current.size() - 1);
        }
    }
}
