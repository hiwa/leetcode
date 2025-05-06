package arraystring;

import java.util.HashMap;
import java.util.Map;

/*
find length of the longest palindrome

https://leetcode.com/problems/longest-palindrome/
T: O(N)
M : O(1) Fix of counter array is fixed.
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int[] counter = new int[128];
        int result = 0;
        for (char ch : s.toCharArray()) {
            counter[ch]++;
        }

        for (int frequency : counter) {
            result = result + frequency / 2 * 2;
        }
        return result < s.length() ? ++result : result;
    }

    // My solution, which is not that optimized and complexer than solution above.
    public int longestPalindrome2(String s) {
        if (s.length() < 2) return s.length();

        Map<Character, Integer> table = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            table.put(s.charAt(i), table.getOrDefault(s.charAt(i), 0) + 1);
        }
        int result = 0;
        int maxOdd = 0;
        for (int frequency : table.values()) {
            if (frequency % 2 == 0) {
                result += frequency;
            } else {
                maxOdd = Math.max(maxOdd, frequency);
            }
        }
        return result + maxOdd;
    }
}
