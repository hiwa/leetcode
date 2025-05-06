package dp;

/*
https://leetcode.com/problems/longest-palindromic-substring/
https://www.youtube.com/watch?v=DK5OKKbF6GI&ab_channel=JavaBrains

Explain your solution before writing down the code. Why this solution?
Intro : There is a Brute force solution : to find all the substring of the input (2 for loops) and find the palindrome ones and the one with max size.
This is not efficient It has O(N^3)

* In this approach, for each char in the input we consider it as a center of a possible palindrome. All chars are 1 length size palindrome.
Then we expand to left and right to see if we are still in the palindrome case:
ABA : If we check 'B' as the center of palindrome, we can expand it to left and right by one and still it's a Palindrome.
We compare the length of each subString palindrome against palindromeMaxLength, if it is longer we update palindromeMaxLength and palindromeStartIndex
which at the end returns the longestPalindrome by subString method.

Time : O(N^2) for the for loop and the while inside it.
Space : O(1) for constants

 */
public class LongestPalindrome {

    // global var to keep track of the longest palindrome length.
    private int longestPalindromeLength;
    // keep track of start index of the longest palindrome.
    private int palindromeStartIndex;

    public String longestPalindrome(String s) {

        // boundary case. (Always check with examples. for 'a' we return 'a'.)
        if (s.isBlank() || s.length() == 1) {
            return s;
        }

        /*
        For all chars in the input, we consider it as a center of a palindrome and we expand it as much as possible
        Two cases exists:
            a. input with odd length : aba
            b. input with even length : abba
            In case a; if we are in index 1 which is char 'b', it is indeed the center of the palindrome, so we just pass i=1 as the index of center.
            But in case b; there is no center index. Instead, it is trivial that in an even length palindrome at least the two chars the middle should be equal.
            So we path index of i and i+1.
            Each palindrome substring will be exclusively treated as case a or case b.
         */

        for (int i = 0; i <= s.length() - 1; i++) {
            //odd case : aba
            expandOutPalindrome(s, i, i);
            //even case abba
            expandOutPalindrome(s, i, i + 1);
        }
        // Play with a simple palindrome such as 'aba in the interview to set correctly the start and end values of substring.
        return s.substring(palindromeStartIndex, palindromeStartIndex + longestPalindromeLength);
    }

    /*
         start = end = 2
         ab'c'ba OK => a'bcb'a OK => 'abcba' OK => '_abcba_' KO
         S:2, E:2   => S=1, E:3   => S=0, E:4   => S=-1, E:4  KO
     */
    //aba s,e = 1 > 0, 2> -1, 3 length = 6
    private void expandOutPalindrome(String s, int startIndex, int endIndex) {
        while (startIndex >= 0 && endIndex <= s.length() - 1 && s.charAt(startIndex) == s.charAt(endIndex)) {
            startIndex--;
            endIndex++;
        }
        // In the above example when we get out of the while, S and E are affected one extra step.
        // so endIndex should be endIndex-1 and startIndex should be startIndex+1. length would be :
        // (endIndex-1) - (startIndex+1) + 1 = endIndex - startIndex - 1. Instead of Math way, try to find it by an easy example.
        // aba S=-1 and E=3 ; length is 3 so by reversing;  3 = 3 - (-1) -1 = end - start -1
        int currentPalindromeLength = endIndex - startIndex - 1;
        if (currentPalindromeLength > longestPalindromeLength) {
            longestPalindromeLength = currentPalindromeLength;
            palindromeStartIndex = startIndex + 1;
        }
    }
}
