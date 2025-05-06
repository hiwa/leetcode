package backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
https://leetcode.com/problems/permutations

https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)

example nums=[1,2,3]

                         1,          2,     3
           for:         /1           |2     \3
                     F(r, 1, n)                      r =permutations , n = nums
           for:   /1    |2       \3
                 X    F(r,12,n)
                    /1   |2   \3
                    X    X     r<-123

for n : 1 > result.size: 1 (Result size is number of final leaves in the tree)
for n : 2 > result.size: 2*1
for n : 3 > result.size: 3*2*1 =6
for n : 4 > result.size: 4*3*2*1 = 24
Space complexity: Number of solutions is N! and each permutation needs N space: O(N*N!)
Time complexity: We need to calculate N! solutions and for each solution we need to copy them in the final result with cost of O(N), so O(N*N!)

 */
public class Permute {

    public List<List<Integer>> permute(int[] nums) {

        // Global Result
        List<List<Integer>> permutations = new ArrayList<>();

        // We cannot pass the interface as param but its implementation. Yet, in the method signature, it's better to pass the interface(List)
        findPermutation(permutations, new ArrayList<>(), nums);

        return permutations;
    }

    /**
     * @param permutations        the final result, always updated when we reach to the leaves (possiblePermutation.size() == nums.length)
     * @param possiblePermutation is a global variable gradually filled with a permutation.
     * @param nums                input example {1,2,3}
     */
    private void findPermutation(List<List<Integer>> permutations, ArrayList<Integer> possiblePermutation, int[] nums) {

        //base condition of recursion
        if (possiblePermutation.size() == nums.length) {
            //possiblePermutation is global and it changes. In the permutations we need to store the consistent possiblePermutation.
            //list.add(item) list contains reference to item. Any change to the item, impact the list value.
            //Remember how to pass a list as a new list. new ArrayList<>(10), change the capacity from default to 10 and
            //new ArrayList<>(possiblePermutation) Constructs a list containing the elements of possiblePermutation
            permutations.add(new ArrayList<>(possiblePermutation));
            // Just in case; you want to print the result
            System.out.println(possiblePermutation);
        }

        // backtrack case
        for (int num : nums) {
            if (!possiblePermutation.contains(num)) {
                possiblePermutation.add(num);
                findPermutation(permutations, possiblePermutation, nums);
                // Backtrack to previous state
                possiblePermutation.remove(possiblePermutation.size() - 1);
            }
        }
    }


    void permute2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        LinkedList<List<Integer>> result = new LinkedList<>();
        result.add(new ArrayList<>());
        while (result.peek().size() != nums.length) {
            List<Integer> combination = result.remove();
            for (int state : nums) {
                if (!combination.contains(state)) {
                    List<Integer> comb = new ArrayList<>(combination);
                    comb.add(state - '0');
                    result.add(comb);
                }
            }
        }
        result.forEach(comb -> System.out.println(comb.toString()));
    }
}
