package arraystring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubstringWithAtMostKDistinctCharactersTest {

    @Test
    void testIt() {
        LongestSubstringWithAtMostKDistinctCharacters longest = new LongestSubstringWithAtMostKDistinctCharacters();
        assertEquals("deeeea".length(), longest.lengthOfLongestSubstringKDistinct("abcdeeeeabced", 3));
    }

    @Test
    void testIt2() {
        LongestSubstringWithAtMostKDistinctCharacters longest = new LongestSubstringWithAtMostKDistinctCharacters();
        assertEquals("deeeea".length(), longest.lengthOfLongestSubstringKDistinctLinkedMap("abcdeeeeabced", 3));
    }

}