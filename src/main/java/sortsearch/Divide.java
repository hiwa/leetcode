package sortsearch;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/divide-two-integers/

 */
public class Divide {

    static final int HALF_MIN_VALUE = -1073741824;

    // T : O(logn) for first loop and O(logn) for second loop : O(logn) + O(logn) = O(logn)
    // M: O(Logn) length of lists. O(logn) + O(logn) = O(logn)
    // If we go for approach 2, which is same logic without storing doubles, T: logn*logn = logn^2 = 2logn
    public int divideApproach3(int dividend, int divisor) {
        //step1 Check the very corner case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        //step2 : Negatify dividend & divisor (Since on negative range we can cover all cases i.e Integer.MIN_VALUE / X )
        int negatives = 2; // counter of negative inputs. Needed at the end to convert the result.
        if (dividend > 0) {
            dividend = -dividend;
            negatives--;
        }
        if (divisor > 0) {
            divisor = -divisor;
            negatives--;
        }
        //step3 : build list of doublesOfDivisor and powersOfTwo
        int powerOfTwo = 1; // initiated as 2^0
        List<Integer> doublesOfDivisor = new ArrayList<>();
        List<Integer> powersOfTwo = new ArrayList<>();

        // since we are in negative range, divisor is greater than dividend
        while (divisor >= dividend) {
            doublesOfDivisor.add(divisor);
            powersOfTwo.add(powerOfTwo);
            // to not trap in integer overflow (If divisor is already greater than HALF_MIN_VALUE, by doubling it we face overflow, so avoid it
            if (divisor < HALF_MIN_VALUE) {
                break;
            }
            // double divisor and dividend
            divisor += divisor;
            powerOfTwo += powerOfTwo;
        }

        int quotient = 0;
        // Go backward to always get the greatest possible double
        for (int i = doublesOfDivisor.size() - 1; i >= 0; i--) {
            // Again since we are in Negative range
            if (doublesOfDivisor.get(i) >= dividend) {
                dividend -= doublesOfDivisor.get(i);
                quotient += powersOfTwo.get(i);
            }
        }
        if (negatives == 1) {
            quotient = -quotient;
        }
        return quotient;
    }

    public int divide(int dividend, int divisor) {

        int multiple = 1;
        int result = 0;
        if (dividend > 0 && divisor < 0) {
            divisor = divisor - (divisor + divisor);
            multiple = -1;
        }
        if (dividend < 0 && divisor > 0) {
            dividend = dividend - (dividend + dividend);
            multiple = -1;
        }
        if (dividend < 0 && divisor < 0) {
            dividend = dividend - (dividend + dividend);
            divisor = divisor - (divisor + divisor);
        }

        int remaining = dividend;

        while (remaining >= divisor) {
            remaining = remaining - divisor;
            result++;
        }
        if (multiple == -1) {
            result = result - (result + result);
        }
        return result;
    }
}
