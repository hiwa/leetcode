package backtrack.parentheses;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/generate-parentheses/
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
Time & space complexity are toooo complex!

 */
public class GenerateParenthesis {

    private final List<String> result = new ArrayList<>();
    private int target;

    public List<String> generateParenthesis(int n) {
        target = n;
        backtrack(new StringBuilder(), 0, 0);
        return result;
    }

    private void backtrack(StringBuilder current, int open, int close) {
        if (current.length() == 2 * target) {
            result.add(current.toString());
            return;
        }
        if (open < target) {
            backtrack(current.append("("), open + 1, close);
            current.deleteCharAt(current.length() - 1);
        }
        if (close < open) {
            backtrack(current.append(")"), open, close + 1);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
