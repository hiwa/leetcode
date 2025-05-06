package arraystring;

/*
https://leetcode.com/problems/one-edit-distance/solution/

Valid cases in one edit distance:
       T         S
1     acb      ab   deletion
2     abc      adc  replacement
3     ab       acb  insertion (if we swap T and S)

T: O(min(n,m))
M: O(1)

 */
public class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        if (Math.abs(s.length() - t.length()) > 1) {
            return false;
        }
        // first input should be the longer one
        if (t.length() > s.length()) {
            return isOneEditDistance(t, s);
        }

        // loop over the smaller list to avoid outOfIndex
        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (s.length() == t.length()) {
                    // check replace abc, adc
                    return s.substring(i + 1).equalsIgnoreCase(t.substring(i + 1));
                } else { // s > t
                    //deletion acb, ab
                    return s.substring(i + 1).equalsIgnoreCase(t.substring(i));
                }
            }
        }
        // abc & ab handled here.
        // cd & cd handled here.
        // At the end there might be still unvisited chars in s. which mean we are in deletion case. OR if both string are same it should be handled here.
        return s.length() - t.length() == 1;
    }

    // My solution. A bit verbose but it works!
    public boolean isOneEditDistance1(String a, String b) {

        if ((a.length() - b.length() > 1) || (a.isEmpty() && b.isEmpty()) || a.equals(b)) {
            return false;
        }

        if (b.length() > a.length()) {
            return isOneEditDistance1(b, a);
        }

        // a = abc, b = ac
        int replacement = 0;
        int insertionCounter = 0;

        int aPointer = 0;
        int bPointer = 0;

        //insertion check
        if (a.length() - 1 == b.length()) {
            while (bPointer < b.length()) {
                if (b.charAt(bPointer) != a.charAt(aPointer)) {
                    insertionCounter++;
                    aPointer++;
                } else {
                    aPointer++;
                    bPointer++;
                }
                if (insertionCounter > 1) {
                    return false;
                }
            }
        }

        //replacement case
        if (a.length() == b.length()) {
            int pointer = 0;
            while (pointer < a.length()) {
                if (b.charAt(pointer) != a.charAt(pointer)) {
                    replacement++;
                }
                if (replacement > 1) {
                    return false;
                }
                pointer++;
            }
        }
        return true;
    }
}
