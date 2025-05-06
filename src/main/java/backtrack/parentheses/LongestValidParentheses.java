package backtrack.parentheses;

public class LongestValidParentheses {
    /*

    https://leetcode.com/problems/longest-valid-parentheses/solution/

    Intro : There is brute force solution where for each substring of the input (O[N^2]), we check [O(N)] if it is a valid case and update the maxLength.
    So complexity is O(n^3).

    Most efficient solution: Approach 4:

    Example A = '(()))'
    Example B = '(()'

    We traverse twice (forward and backward) to find the result.
    At Forward traverse when counters are equal we are sure that for the current closing paren, we found a valid case. In example A, it is (())
    where closeParenCounter == 2, so we double it to get the length. Then we update the maxLength against founded case.

    Why we need to traverse backward?! Similar to other parentheses problems we have seen, to check '(' we should traverse backward to find valid cases.
    In forward traverse we don't have control over '('s. We just increase them. So in Example B, we miss the valid '()' as counters never get equal.
    A valid '(' should have a ')' after it.

    T : O(N)
    Space: O(1)

     */
    public int longestValidParentheses(String s) {

        if (s == null) {
            return 0;
        }
        int maxLength = 0;

        int closeParenCounter = 0;
        int openParenCounter = 0;
        // check left to right valid close parens
        // ())
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                openParenCounter++;
            }
            if (s.charAt(i) == ')') {
                closeParenCounter++;
            }
            if (closeParenCounter == openParenCounter) {
                maxLength = Math.max(maxLength, 2 * closeParenCounter);
            }
            if (closeParenCounter > openParenCounter) {
                closeParenCounter = openParenCounter = 0;
            }
        }
        // (()
        closeParenCounter = openParenCounter = 0;
        for (int i = s.length() - 1; i > 0; i--) {
            if (s.charAt(i) == '(') {
                openParenCounter++;
            }
            if (s.charAt(i) == ')') {
                closeParenCounter++;
            }
            if (closeParenCounter == openParenCounter) {
                maxLength = Math.max(maxLength, 2 * openParenCounter);
            }
            if (openParenCounter > closeParenCounter) {
                closeParenCounter = openParenCounter = 0;
            }
        }
        return maxLength;
    }
}
