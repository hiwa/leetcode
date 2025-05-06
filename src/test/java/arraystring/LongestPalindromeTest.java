package arraystring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LongestPalindromeTest {

    @Test
    void testIt() {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        Assertions.assertEquals(9, longestPalindrome.longestPalindrome("aaaabebez"));
        Assertions.assertEquals(3, longestPalindrome.longestPalindrome("aab"));
        Assertions.assertEquals(5, longestPalindrome.longestPalindrome("aabccc"));
    }

}