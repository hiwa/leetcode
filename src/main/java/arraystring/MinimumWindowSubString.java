package arraystring;

import java.util.HashMap;
import java.util.Map;
/*

https://leetcode.com/problems/minimum-window-substring/solution/

Time : rfgefre
 */
public class MinimumWindowSubString {
    //"abwscadb", "abc" > "cadb"
    public String minWindow(String s, String t) {

        if (s == null || s.isEmpty()) {
            return "";
        }
        Map<Character, Integer> dicT = new HashMap<>();
        buildCharFrequencyMap(t, dicT); // b>1 , d>2

        final int TOTAL_FORMS = dicT.size();

        int leftPointer = 0;
        int rightPointer = 0;
        int formCreatedCounter = 0;

        // length, startPosition, endPosition
        int[] resultElements = {-1, 0, 0};

        Map<Character, Integer> windowCharFrequency = new HashMap<>();

        while (rightPointer < s.length()) {
            char currentChar = s.charAt(rightPointer);
            int currentFrequency = windowCharFrequency.getOrDefault(currentChar, 0);
            windowCharFrequency.put(currentChar, currentFrequency + 1);

            if (dicT.containsKey(currentChar) && dicT.get(currentChar).intValue() == windowCharFrequency.get(currentChar).intValue()) {
                formCreatedCounter++;
            }

            // leftPointer <= rightPointer. = for the boundary case. s="a", t = "a"
            while (TOTAL_FORMS == formCreatedCounter && leftPointer <= rightPointer) {
                if (resultElements[0] == -1 || rightPointer - leftPointer + 1 < resultElements[0]) {
                    resultElements[0] = rightPointer - leftPointer + 1;
                    resultElements[1] = leftPointer;
                    resultElements[2] = rightPointer;
                }
                char charToRemove = s.charAt(leftPointer);
                windowCharFrequency.put(charToRemove, windowCharFrequency.get(charToRemove) - 1);

                if (windowCharFrequency.get(charToRemove) < dicT.getOrDefault(charToRemove, 0)) {
                    formCreatedCounter--;
                }
                leftPointer++;
            }
            rightPointer++;
        }

        return resultElements[0] == -1 ? "" : s.substring(resultElements[1], resultElements[2] + 1);

    }

    private void buildCharFrequencyMap(String t, Map<Character, Integer> dicT) {
        for (int i = 0; i < t.length(); i++) {
            char currentChar = t.charAt(i);
            int charFrequency = dicT.getOrDefault(currentChar, 0);
            dicT.put(currentChar, charFrequency + 1);
        }
    }
}
