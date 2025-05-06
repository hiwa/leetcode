package arraystring;

/*
https://leetcode.com/problems/valid-palindrome/solution/
Q :  phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing
all non-alphanumeric characters,
it reads the same forward and backward. Alphanumeric characters include letters and numbers.

O(N)
O(1)
Solution : Set two pointers at start and end of string. until they have not meet each other,
scape nonAlphabetic chars( ! a-z , not 1-9").
return false if they are not the same. aba
 */
public class ValidatePalindrome {
    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty() || s.length() == 1) {
            return true;
        }
        int leftPointer = 0;
        int rightPointer = s.length() - 1;

        s = s.toLowerCase();

        while (leftPointer < rightPointer) {

            if (!Character.isLetterOrDigit(s.charAt(leftPointer))) {
                leftPointer++;
            } else if (!Character.isLetterOrDigit(s.charAt(rightPointer))) {
                rightPointer--;
            } else if (s.charAt(leftPointer) != s.charAt(rightPointer)) {
                return false;
            } else {
                rightPointer--;
                leftPointer++;
            }
        }
        return true;
    }
}
