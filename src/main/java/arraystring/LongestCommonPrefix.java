package arraystring;
/*
https://leetcode.com/problems/longest-common-prefix/

O(S): Where is the number of all chars in the array.
In worst case, all items are the same, and we need to compare all of them to find LCP
O(1)
 */
public class LongestCommonPrefix {
    //{"flour", "flower", "flood", "float"}
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String lcp = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (!lcp.isEmpty() && !strs[i].startsWith(lcp)) {
                lcp = lcp.substring(0, lcp.length() - 1);
            }
        return lcp;
    }
}
