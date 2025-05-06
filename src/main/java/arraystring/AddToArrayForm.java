package arraystring;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
https://leetcode.com/problems/add-to-array-form-of-integer
T: O(max(N,log K)) : where n is the length of the array and log10(k) is the number of digits present in variable k.
M: O(max(N,log K)) : not an in-place as we need space equal to the given k or length of array, whichever is maximum between the two, to store the elements.

[1,9,3], 12 > [1,1+9,5]
 */
public class AddToArrayForm {

    public List<Integer> addToArrayForm(int[] num, int k) {
        int carry = k;
        List<Integer> result = new ArrayList<>();
        for (int i = num.length - 1; i >= 0; i--) {
            int sum = carry + num[i];
            result.add(sum % 10);
            carry = sum / 10;
        }

        while (carry > 0) {
            result.add(carry % 10);
            carry = carry / 10;
        }
        Collections.reverse(result);
        return result;
    }

    public List<Integer> addToArrayForm1(int[] array, int k) {
        int toBeAdded = k;
        List<Integer> ans = new ArrayList<>();

        int i = array.length - 1;
        while (i >= 0 || toBeAdded > 0) {
            if (i >= 0) {
                toBeAdded = toBeAdded + array[i];
            }
            ans.add(toBeAdded % 10);
            toBeAdded = toBeAdded / 10;
            i--;
        }

        Collections.reverse(ans);
        return ans;
    }
}
