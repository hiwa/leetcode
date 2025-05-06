package arraystring;
/*
https://leetcode.com/problems/reverse-integer/

O(logn)
 */
public class ReverseNumber {
    public int reverse(int x) {
        int result = 0, previousResult = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            if ((result - x % 10) / 10 != previousResult) return 0;
            x /= 10;
            previousResult = result;
        }
        return result;
    }
}
