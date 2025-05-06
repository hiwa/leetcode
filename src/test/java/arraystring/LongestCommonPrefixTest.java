package arraystring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LongestCommonPrefixTest {

    @Test
    void testit() {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        Assertions.assertEquals("flo", longestCommonPrefix.longestCommonPrefix(new String[] {"florz", "flower", "flood", "float"}));
    }
}