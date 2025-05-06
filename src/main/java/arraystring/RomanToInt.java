package arraystring;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/roman-to-integer/solution/

T : O(1) As there is a finite set of roman numerals, (maximum number possible number :3999)
space: O(1) : A constant size map is used.
 */
public class RomanToInt {

    static Map<String, Integer> dictionary;
    static {
        dictionary = new HashMap<>();

        dictionary.put("I", 1);
        dictionary.put("V", 5);
        dictionary.put("X", 10);

        dictionary.put("L", 50);
        dictionary.put("C", 100);
        dictionary.put("D", 500);
        dictionary.put("M", 1000);

        dictionary.put("IV", 4);
        dictionary.put("IX", 9);
        dictionary.put("XL", 40);
        dictionary.put("XC", 90);
        dictionary.put("CD", 400);
        dictionary.put("CM", 900);
    }

    public int romanToInt(String roman) {
        int result = 0;
        if (roman == null || roman.isBlank()) {
            return result;
        }
        ///II, IV
        for (int i = 0; i < roman.length() ; i++) {
            //IV
            if (i < roman.length()-1 && dictionary.containsKey(roman.substring(i, i + 2))) {
                result += dictionary.get(roman.substring(i, i + 2));
                i++;
            } else { //iii
                result += dictionary.get(roman.substring(i, i + 1));
            }

        }
        return result;
    }
}
