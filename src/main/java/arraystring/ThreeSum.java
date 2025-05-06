package arraystring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/3sum/solution/

Intro : For array [-4,-2, 0,2,2] we should get [[-4, 2, 2],[-2, 0, 2]]
    1. SORT the array. Sort is O(nlogn) and our final algorithm has O(N^2) so no impact on complexity.
    Why sort? because by sorting we know how to tune the candidates. how to tune? by using sliding window:
    2. We use two pointers called leftReader & rightReader for the sliding window. For each item in the input we set Left to i+1 & right to input size-1.
    Then based on the result of the sum of this 3 points we tune the L & R pointers.

    Complexity : T : O(N^2) & Space O(logN):

 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] input) {
        List<List<Integer>> result = new ArrayList<>();
        if (input == null || input.length == 0) {
            return result;
        }
        Arrays.sort(input); // Time : O(nlong) & Space : O(LogN)
        for (int i = 0; i < input.length; i++) {
            if (i == 0 || input[i] <= 0) {
                findTriples(i, result, input);
            }
        }
        return result;
    }

    private void findTriples(int i, List<List<Integer>> result, int[] input) {
        int rightReader = input.length - 1;
        int leftReader = i + 1;
        while (leftReader < rightReader) {
            int sum = input[i] + input[leftReader] + input[rightReader];
            if (sum < 0) {
                leftReader++;
            } else if (sum > 0) {
                rightReader--;
            } else {
                System.out.println(Arrays.asList(input[i], input[leftReader], input[rightReader]));
                result.add(Arrays.asList(input[i], input[leftReader], input[rightReader]));
                //
                rightReader--;
                leftReader++;
                //[-2i,0l,0,2,2r]
                while (leftReader < rightReader && input[leftReader] == input[leftReader - 1]) {
                    leftReader++;
                }
                //instead of upper while; it can be
//                while (leftReader < rightReader && input[rightReader] == input[rightReader + 1]) {
//                    rightReader--;
//                }

            }
        }
    }
}
