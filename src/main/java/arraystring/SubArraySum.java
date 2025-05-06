package arraystring;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/subarray-sum-equals-k/solution/
[1,2,3],3 => 2 which is [1+2],[3]
Intro:
    Si = cumulative sum at index i
    Si+n = cumulative sum at index i+n
    fact 1: if Si = Si+n => cumulative sum of numbers between 'i' and 'i+n' is zero.  Si = Si+n => Si---0----Si+n
    fact 2: based on fact 1, If Si+K=Si+n then Si = Si+n - K                          Si+n = Si+K => Si----K---Si+n
      Scenario :  [1, 2, 3, -3, 3, 3], 6
      sum          1, 3, 6,  3, 6, 9 => map[(0,1),(1,1),(3,2),(6,2),(9,1)]
      sum-k       -5,-3, 0*, -3, 0*, 3** (Each star is for one frequency in the map)
      Then for each case where we find sum-kin the map, we have map.get(sum-k.value) forms. in this case, 4 is the result:
      [1,2,3],[1,2,3,-3,3],[3,-3,3,3],[3,3]
T: O(N)
M: O(N) size of map

 */
public class SubArraySum {

    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int formed = 0;
        Map<Integer, Integer> dict = new HashMap<>();
        //[3],3
        dict.put(0, 1);

        for (int num : nums) {
            sum += num;
            if (dict.containsKey(sum - k)) {
                formed += dict.get(sum - k);
            }
            dict.put(sum, dict.getOrDefault(sum, 0) + 1);
        }
        return formed;
    }

    // Brute Force O(N^3)
    public int subarraySumBruteForce(int[] nums, int k) {
        int n = nums.length;
        int result = 0;
        for (int start = 0; start < n; start++) //This loop will select start element
        {
            for (int end = start; end < n; end++)   //This loop will select end element
            {
                int sum = 0;
                for (int itemId = start; itemId <= end; itemId++) //This loop will print element from start to end
                {
                    sum = sum + nums[itemId];
                }
                if (sum == k) {
                    result++;
                }
                System.out.println("sum :" + sum);
            }
        }
        return result;
    }
}
