package backtrack.parentheses;

import java.util.ArrayList;
import java.util.List;

/*
Problem : https://leetcode.com/problems/remove-invalid-parentheses/
Solution : https://leetcode.com/problems/remove-invalid-parentheses/discuss/75027/Easy-Short-Concise-and-Fast-Java-DFS-3-ms-solution
I adapted the solution to make it more readable, so it's different a bit from original solution.

Not sure about Complexity!!! :

Space: The program only generates valid answers. Every path in the search generates one valid answer.
The whole search space is a tree with k (number of answers) leaves. The number of nodes in the tree is roughly O(k).

Time : To generate one node it requires O(n) time from the string concatenation among other things. So roughly O(nk).
Accurately O(nm) where m is the total "number of recursive calls" or "nodes in the search tree". Then you need to relate m to n in the worst case.

Time : O(nm)
Space : O(NK)
 */
public class MinRemoveToMakeAllValidResults {

    public List<String> removeInvalidParentheses(String s) {
        List<String> output = new ArrayList<>();
        //First we check for invalid ')'s. As soon as we find one, we decide which paren we should remove, then we call the removeHelper
        // and return. Why return? Because there is no point to continue a possibility which we already sure that it does not give us a valid output.
        // Only after removing all invalid ')'s we can continue the flow to remove invalid '('s.
        removeHelper(s, output, 0, 0, ')', '(');
        return output;
    }

    public void removeHelper(String input, List<String> output,
                             //This can be '0' but for better performance, in each iteration we dont start from the beginning of the input but from
                             int firstUnvisitedPosition,
                             //Index of last valid position in the input. When we visit an invalid case, we check the range of lastValidPosition and
                             // i (which is pointing to current invalid case when we are in the if condition) to decide which checkingParen we should remove.
                             int lastValidPosition,
                             char checkingParen,
                             char otherParen) {
        int numOtherParen = 0;
        int numCheckingParen = 0;

        for (int i = firstUnvisitedPosition; i < input.length(); i++) {
            if (input.charAt(i) == checkingParen) {
                numCheckingParen++;
            }
            if (input.charAt(i) == otherParen) {
                numOtherParen++;
            }
            if (numCheckingParen > numOtherParen) {    // We have an extra checkingParen we need to remove
                /*
                    In the range of lastValidPosition (from previous call) to the current position (including) which is not valid (i is the index of the
                     current char which is invalid) do:
                 */
                for (int j = lastValidPosition; j <= i; j++) {
                    // If in the range of lastValidPosition and current invalid position(i) we find an checkingParen && we don't have a checkingParen before it,
                    // we are going to remove it. Second condition means we always remove the first occurrence of checkingParen if we have a sequence of them
                    // Example : for input [(a)b))], if range is (3 to 5-including) we have two possibilities to remove invalid ')' : string[4] and string[5].
                    // Applying the 2nd condition, we remove string[4]. This is to avoid duplicated outputs. Because if we remove once string[4] and once string [5] we
                    // end up having duplicated items in the output.
                    if (input.charAt(j) == checkingParen && (j == lastValidPosition || input.charAt(j - 1) != checkingParen))
                    // Recursion: firstUnvisitedPosition = i since we now have valid # closed parenthesis through i. lastValidPosition = j prevents duplicates
                    {
                        // Why we pass i as firstUnvisitedPosition as we have already seen i in the loop?!
                        // Because we remove one char before position i, so 'i' is indeed pointing to first unvisited position.
                        removeHelper(new StringBuilder(input).deleteCharAt(j).toString(), output, i, j, checkingParen, otherParen);
                    }
                }
                // As soon as finding out the current path is invalid we don't go through the next steps, so we just return
                return; // Stop here. The recursive calls handle the rest of the string.
            }
        }
        // We are out of the if condition! It means there are no more invalid checkingParens!
        // No it's time to check and remove the invalid otherParens. This is why we reverse the input! But why?
        // 1. An invalid ')' does not have a unmatched '(' before it. So we should check forward (left to right)
        // 2.An invalid '(' does not have a unmatched ')' after it. So we should check backward( right to left)
        // Instead of checking backward we just reverse the input and use the same recursive method.
        String reversed = new StringBuilder(input).reverse().toString();
        // Remember in first call otherParen='('. So in this case we are going to swap the checking and otherParen values.
        // This check also guarantees that we only go through checking '(' once.
        // Question we reversed the input in line 63. should not we re-reverse it? No! this re-reversion is going to be done in line 68 where we call
        // the reverse again.
        if (otherParen == '(') {
            removeHelper(reversed, output, 0, 0, '(', ')');
        } else {
            output.add(reversed);
            System.out.println(reversed);
        }
    }
}
