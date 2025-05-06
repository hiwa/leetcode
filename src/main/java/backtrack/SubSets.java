package backtrack;

import java.util.ArrayList;
import java.util.List;

/*

T : (N* 2^N) (copy of each case *number of all cases)
M : O(N) for recursion call which is for current. size of current can be at most N, size of nums.
 */
public class SubSets {
    // [1,2] -> [[],[1],[1,2],[2]
    List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;

    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, int start) {
        result.add(new ArrayList<>(current));
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(result, current, nums, i + 1);
            current.remove(current.size() - 1);
        }
    }
}
