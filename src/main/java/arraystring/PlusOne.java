package arraystring;

/*
https://leetcode.com/problems/plus-one/solution/

T: O(N)
M: O(N) Although we perform the operation in-place (i.e. on the input list itself), in the worst scenario, we would need to allocate an intermediate space
    to hold the result, which contains the N+1 elements. Hence, the overall space complexity of the algorithm is O(N).
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // move along the input array starting from the end as we increment from right.
        for (int i = n - 1; i >= 0; --i) {
            // set all the nines at the end of array to zeros
            if (digits[i] != 9) {
                // increase this rightmost not-nine by 1
                digits[i]++;
                // and the job is done
                return digits;
            }
            // here we have the rightmost not-nine
            digits[i] = 0;
        }
        // we're here because all the digits are nines (999 => 1000)
        digits = new int[n + 1];
        digits[0] = 1;
        return digits;
    }
}
