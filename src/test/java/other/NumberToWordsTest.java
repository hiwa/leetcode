package other;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberToWordsTest {

    @Test
    void testIt() {
        NumberToWords numberToWords = new NumberToWords();
        assertEquals("one million nine hundred eighty seven thousand one hundred twenty three", numberToWords.numberToWords(1987123).toLowerCase());
    }

}