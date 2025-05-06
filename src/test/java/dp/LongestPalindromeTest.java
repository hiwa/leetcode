package dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestPalindromeTest {

    // we should test separately because of class level variables impact.
    @Test
    void testIt() {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        assertEquals("ooggoo", longestPalindrome.longestPalindrome("abcooggoofrewef"));
    }
    @Test
    void testIt_2() {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        assertEquals("oo", longestPalindrome.longestPalindrome("abcoogg"));
    }

    @Test
    void testIt_3() {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        assertEquals("a", longestPalindrome.longestPalindrome("ab"));
    }

}