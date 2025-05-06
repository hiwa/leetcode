package arraystring;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/longest-substring-without-repeating-characters

    Intro: 3 possible ways:
        1. Brute force O(N^3) : find all substrings O(N^2) and for each check if it has duplications (using a Set|Map) O(N) and update Max each time.
        2. Sliding window with StringBuilder O(N^2) : We have one loop but string builder.remove() make it complex to O(N^2)
        3. Sliding window with Map
 */
public class LongestSubString {

    // My solution, clear logic with sliding window
    public int lengthOfLongestSubstringMySolution(String s) {
        int result = 0;
        if (s.isEmpty()) return result;
        int l = 0;
        int r = 0;
        Map<Character, Integer> dict = new HashMap<>();
        while (r < s.length()) {
            char currentChar = s.charAt(r);
            if (dict.containsKey(currentChar) && dict.get(currentChar) >= l) {
                result = Math.max(result, r - l);
                l = dict.get(currentChar) + 1;
            }
            dict.put(currentChar,r);
            r++;
        }
        return Math.max(result, r - l);
    }

    public int lengthOfLongestSubstring(String s) {

        if (s == null || s.isEmpty()) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        int startPosition = 0;

        //bcacb
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            // We update startPosition only for duplications happened after this startPosition. Duplications before startPosition are ignored:
            // abba, for 2nd 'a', we don't care about the 'a' duplication available in the map before because it's not counted anyway as startPosition is 2 now.
            if (map.containsKey(currentChar) && map.get(currentChar) >= startPosition) {
                startPosition = map.get(currentChar) + 1;
            }
            // sliding window length calculation : End-start+1
            startPosition = Math.max(startPosition, i - startPosition + 1);
            map.put(currentChar, i);
        }
        return startPosition;
    }

    /*
     Time : O(N^2)
     Space: O(N) , where N is size of string builder.
     */
    public int lengthOfLongestSubstring11(String s) {

        if (s == null || s.isEmpty()) {
            return 0;
        }

        int maxLength = 0;

        /*
            input : abcbac
         */
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) { // O(n)
            // if there is duplication (2nd 'b')
            //indexOf(x) : O(n) where n = s.length & indexOf(x,y) : O(n*m) where m is length of pattern. So here is O(n)
            if (stringBuilder.indexOf(String.valueOf(s.charAt(i)),21) >= 0) {
                maxLength = Math.max(maxLength, stringBuilder.length()); // Max : O(N)
                //abc+b > c+b
                stringBuilder.delete(0 , stringBuilder.indexOf(String.valueOf(s.charAt(i)))+1).append(s.charAt(i)); // delete is O(N), append is O(1)
            } else {
                stringBuilder.append(s.charAt(i));
            }
        }

        maxLength = Math.max(maxLength, stringBuilder.length());
        return maxLength;
    }
}