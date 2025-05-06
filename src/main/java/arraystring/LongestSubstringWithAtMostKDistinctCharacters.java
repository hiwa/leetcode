package arraystring;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*
    https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/solution/
    Problem : for input "abcdeeeeabced", 3 > find the longest substring with at most 3 distinct chars, which is "deeeea".

    Solution (SLIDING WINDOW) :  Typically needs 2 L and R pointers and a map containing state of current window:
        1. define two L and R pointers set to beginning of the input.
        2. Move R step by step and add to the map the current char and its index. map size is number of distinct chars in the window.
        3. Continue adding chars to the map until dict.size == k+1. At this point we have passed the requirement, so we need to move the L pointer forward.
        4. At this point we need to know where we should move the L pointer. In the above example first accepted window is "abbbcd". Check comments below.


    Time : O(N*K) in worst case and O(N) in best case:
    In best case where s is only contains not more than K distinct characters, we just go through the main loop with it is O(N) where N = length of s
    and we dont need to tune the left pointer.
    In worst case input string contains n distinct characters at each step one uses O(k) time to find a minimum value in the hashmap with k elements
    and so the overall time complexity is O(Nk).

    Space: O(K) for the hashmap.

    Improvement? Yes! Its possible to use LinkedHashMap which returns the first or last added key/value by O(1). Look second implementation,
    In this case T: O(N)
 */
public class LongestSubstringWithAtMostKDistinctCharacters {

    //hashmap
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() * k == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int result = 1;

        Map<Character, Integer> dict = new HashMap<>();

        while (right < s.length()) {
            Character currentChar = s.charAt(right);
            dict.put(currentChar, right);
            //Expand window to right until we visit the k+1 distinct char. This way we are sure we expand the window as much as possible.
            // Then we tune the window by removing a char and sure all of its duplicates to have a valid window with size K.
            // IF window is "abbbcd" and input is "L^abbacdR^da" and K = 3, then in map we have : (a,0),(b,3),(c,4),(d,5) with size 4.
            // Its trivial that we should remove the char with smaller index to keep the window as long as possible. This is why we look for
            // dict values minimum.
            if (dict.size() == k + 1) {
                int indexToRemove = Collections.min(dict.values());
                dict.remove(s.charAt(indexToRemove));
                // Left should point to next chat after index. So in the above example indexToRemove=0 so left points to b at index 2.
                left = indexToRemove + 1;
            }
            // After window tuned we are sure we have a valid window to check against result.
            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }

    //linkedHashMap
    public int lengthOfLongestSubstringKDistinctLinkedMap(String s, int k) {
        if (s == null || s.length() * k == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int result = 1;

        Map<Character, Integer> dict = new LinkedHashMap<>();

        while (right < s.length()) {
            Character currentChar = s.charAt(right);
            // We remove and again put the key/value to follow FIFO order. This way, the first item in the map has the minimum index. So we just return
            // by O(1) no need to get minimum.
            dict.remove(currentChar);
            dict.put(currentChar, right);

            if (dict.size() == k + 1) {
                //https://www.geeksforgeeks.org/how-to-iterate-linkedhashmap-in-java/
                Map.Entry<Character, Integer> mostLeft = dict.entrySet().iterator().next();

                dict.remove(mostLeft.getKey());
                // Left should point to next chat after index. So in the above example indexToRemove=0 so left points to b at index 2.
                left = mostLeft.getValue() + 1;
            }
            // After window tuned we are sure we have a valid window to check against result.
            right++;
            result = Math.max(result, right - left);
        }
        return result;
    }
}
