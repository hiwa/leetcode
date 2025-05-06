package arraystring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MinimumWindowPalindromeTest {

    @Test
    void testIt() {
        MinimumWindowSubString minimumWindowSubString = new MinimumWindowSubString();
        Assertions.assertEquals("abwc", minimumWindowSubString.minWindow("abwcadb", "abc"));
        Assertions.assertEquals("a", minimumWindowSubString.minWindow("a", "a"));
        Assertions.assertEquals("cadb", minimumWindowSubString.minWindow("abwscadbw", "abc" ));
    }

    @Test
    void testIt2() {
        MinimumWindowSubString minimumWindowSubString = new MinimumWindowSubString();
        Assertions.assertEquals("abfc", minimumWindowSubString.minWindow("abdd3cdeabfcfg", "abc"));
    }

}