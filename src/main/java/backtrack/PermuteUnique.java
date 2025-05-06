package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/permutations-ii/discuss/18594/Really-easy-Java-solution-much-easier-than-the-solutions-with-very-high-vote
Same template used as Permute example. The only difference is in Backtrack case.
Same T O(N*N!) and M O(N*N!):
The worst-case time complexity is O(n! * n).

For any recursive function, the time complexity is O(branches^depth) * amount of work at each node in the recursive call tree. in this case, we have
n*(n-1)*(n*2)*(n-3)*...*1 branches at each level = n!, so the total recursive calls is O(n!)
We do n-amount of work in each node of the recursive call tree, (a) the for-loop and (b) at each leaf when we add n elements to an ArrayList.
So this is a total of O(n) additional work per node. Therefore, the upper-bound time complexity is O(n! * n).

Space: boolean array O(N), arraylist for possiblePermutation O(N), recursion stack O(N) = 3 O(N). IF we consider output as well O(N*N!)
example nums= [1,2,2] > sorted [1a,2a,2b]
explanation of diagram: https://ibb.co/Sw0fgk5
 */
public class PermuteUnique {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return permutations;
        }
        Arrays.sort(nums);
        // Remember how to pass new boolean as param
        findPermutations(permutations, new ArrayList<>(), new boolean[nums.length], nums);
        return permutations;
    }

    private void findPermutations(List<List<Integer>> permutations,
                                  List<Integer> possiblePermutation,
                                  boolean[] visited,
                                  int[] nums) {
        // base case
        if (possiblePermutation.size() == nums.length) {
            permutations.add(new ArrayList<>(possiblePermutation));
        }
        // Backtrack case
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                continue;
            }
            visited[i] = true;
            possiblePermutation.add(nums[i]);
            findPermutations(permutations, possiblePermutation, visited, nums);
            visited[i] = false;
            possiblePermutation.remove(possiblePermutation.size() - 1);
        }
    }
}
