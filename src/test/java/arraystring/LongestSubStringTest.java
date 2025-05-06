package arraystring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
class LongestSubStringTest {

    @Test
    void testIt() {
        LongestSubString longestSubString = new LongestSubString();
        Assertions.assertEquals(3, longestSubString.lengthOfLongestSubstring11("abca"));
        Assertions.assertEquals(3, longestSubString.lengthOfLongestSubstring11("dvdf"));
        Assertions.assertEquals(8, longestSubString.lengthOfLongestSubstring11("dvdfadvabcefg"));
    }

}