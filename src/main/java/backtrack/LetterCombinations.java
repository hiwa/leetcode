package backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
https://leetcode.com/problems/letter-combinations-of-a-phone-number/discuss/8064/My-java-solution-with-FIFO-queue Solution 1

T: O(4^N*N) : in worst case each digit is mapped to a 4 letter value. and N is digits size. Final output is also O(4^N*N)

          "                       4^0
       p    q      r    s         4^1
     pqrs  pqrs  pqrs  pqrs       4^2
 .... ....                        4^n
 */
public class LetterCombinations {

    private final Map<Character, String> map = Map.of(
            '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
            '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
    private List<String> combinations = new ArrayList<>();
    private String input;

    public List<String> letterCombinationGenerator(String digits) {
        if (digits.isEmpty()) return combinations;
        input = digits;
        backtrack(new StringBuilder(), 0);
        return combinations;
    }

    private void backtrack(StringBuilder candidate, int i) {
        if (candidate.length() == input.length()) {
            combinations.add(candidate.toString());
            return;
        }
        for (Character ch : map.get(input.charAt(i)).toCharArray()) {
            backtrack(candidate.append(ch), i + 1);
            candidate.deleteCharAt(candidate.length() - 1);
        }
    }

    //Solution 1
    public List<String> letterCombinations(String digits) {
        LinkedList<String> combinations = new LinkedList<>();
        if (digits.isEmpty()) {
            return combinations;
        }
        String[] dictionary = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        combinations.add("");

        // check the head. If the combination has same length as the digits we are done. example : 23 => ad DONE
        while (combinations.peek().length() != digits.length()) {
            // remove from head
            String removed = combinations.remove();
            for (char letter : dictionary[digits.charAt(removed.length()) - '0'].toCharArray()) {
                // add to tail
                combinations.add(removed + letter);
            }
        }
        return combinations;
    }
}
