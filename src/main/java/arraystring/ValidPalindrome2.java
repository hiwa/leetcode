package arraystring;

import org.apache.commons.lang3.StringUtils;

//https://leetcode.com/problems/valid-palindrome-ii/
// Given a string s, return true if the s can be palindrome after deleting at most one character from it.
public class ValidPalindrome2 {

    // daamad
    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return isPalindrome(s, l, r - 1) || isPalindrome(s, l + 1, r);
            }
            l++;
            r--;
        }
        return true;
    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    // Simply check if s is palindrome
    public boolean validatePalindrome(String s) {
        if (StringUtils.isBlank(s)) {
            return true;
        }
        int left = s.length() / 2;
        int right = left;
        if (s.length() % 2 == 0) {
            left--;
        }
        while (left >= 0 || right <= s.length() - 1) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left--;
            right++;
        }
        return true;
    }
}
