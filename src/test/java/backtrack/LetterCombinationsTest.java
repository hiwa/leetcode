package backtrack;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LetterCombinationsTest {

    @Test
    void testIt_() {
        LetterCombinations letterCombinations = new LetterCombinations();
        assertEquals(Collections.emptyList() ,letterCombinations.letterCombinations(""));
    }

    @Test
    void testIt_2() {
        LetterCombinations letterCombinations = new LetterCombinations();
        assertEquals(Arrays.asList("a", "b","c") ,letterCombinations.letterCombinations("2"));
    }
    @Test
    void testIt_23() {
        LetterCombinations letterCombinations = new LetterCombinations();
        assertEquals(Arrays.asList("ad", "ae", "af", "bd","be", "bf", "cd", "ce", "cf") ,letterCombinations.letterCombinations("23"));
    }
    @Test
    void testIt_232() {
        LetterCombinations letterCombinations = new LetterCombinations();
        List<String> actualResult = letterCombinations.letterCombinations("232");
        // 3 digits, and each digit represents 3 letter
        assertEquals(3*3*3, actualResult.size());
        assertEquals(Arrays.asList("ada", "adb", "adc", "aea", "aeb", "aec", "afa", "afb", "afc", "bda", "bdb", "bdc", "bea", "beb", "bec",
                "bfa", "bfb", "bfc", "cda", "cdb", "cdc", "cea", "ceb", "cec", "cfa", "cfb", "cfc") , actualResult);
    }


}