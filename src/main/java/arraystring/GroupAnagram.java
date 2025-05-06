package arraystring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
https://leetcode.com/problems/group-anagrams/solution/

Problem : ["eat,"bat","tea","nat","tan"] => [[eat, tea], [bat], [tan, nat]]

Solution : we should find a common attribute between eat and tea. If we sort them they are both "aet". So we can use "aet" as a grouping key for all
combinations of (a,e,t) including eat and tea. Steps:
1. sort each item in the list => convert string to charArray, sort this array. and return String valueOf it.
2. add it if this key is not available in the map create it with value new ArrayList<>(). each time we
visit an item which has same sorted key we added to the list in the map.
3.At the end just return map values.

T: O (NKlogK) where N is size of strs in the loop and KLogK is the order of each element sort.
Space: O(NK). because every word inside the input array, are arrays of characters. At the end of the algorithm,
we return Lists of size N, where each element of those lists are arrays of characters. (https://leetcode.com/problems/group-anagrams/solution/815451)
 */
public class GroupAnagram {

    public List<List<String>> groupAnagramsBestPerformance(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return result;
        }
        Map<String, List<String>> sortMap = new HashMap<>();
        for (String item : strs) {
            String key = convert(item);
            if (!sortMap.containsKey(key)) {
                sortMap.put(key, new ArrayList<>());
            }
            sortMap.get(key).add(item);
        }
        return new ArrayList<>(sortMap.values());
    }

    private static String convert(String item) {
        // lowercase alphabet 26 letters
        char[] counter = new char[26];
        //Use offset
        for (char ch : item.toCharArray()) counter[ch - 'a']++;
        return String.valueOf(counter);
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result = new ArrayList<>();

        if (strs == null || strs.length == 0) {
            return result;
        }

        Map<String, List<String>> sortMap = new HashMap<>();

        for (String item : strs) {
            String itemSorted = sortString(item);
            if (!sortMap.containsKey(itemSorted)) {
                // Why new ArrayList? because we need to modify the list later, so it should be mutable.
                sortMap.put(itemSorted, new ArrayList<>());
            }
            /*
                just update the list, dont need to put it in the map.
                Java is always pass-by-value. However, when we deal with objects (like the list below) we are really dealing with object-handles
                called references which are passed-by-value as well.
                https://stackoverflow.com/a/40523
             */
            sortMap.get(itemSorted).add(item);
        }
        System.out.println(sortMap.values());
        //return
        return new ArrayList<>(sortMap.values());
    }

    private String sortString(String item) {
        char[] charArray = item.toCharArray();
        Arrays.sort(charArray);
        return String.valueOf(charArray);
    }
}
