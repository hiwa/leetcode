package backtrack.parentheses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestValidParenthesesTest {

    @Test
    void testIt() {
        LongestValidParentheses longestValidParentheses = new LongestValidParentheses();
        assertEquals(0, longestValidParentheses.longestValidParentheses(null));
        assertEquals(0, longestValidParentheses.longestValidParentheses(""));
        assertEquals(0, longestValidParentheses.longestValidParentheses(")("));
        assertEquals(2, longestValidParentheses.longestValidParentheses("(()"));
        assertEquals(2, longestValidParentheses.longestValidParentheses("())"));
        assertEquals(8, longestValidParentheses.longestValidParentheses("))()()(())("));

    }



}