package arraystring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RomanToIntTest {


    @Test
    void testIt() {
        RomanToInt romanToInt = new RomanToInt();
        //https://www.calculatorsoup.com/calculators/conversions/roman-numeral-converter.php
        Assertions.assertEquals(2714, romanToInt.romanToInt("MMDCCXIV"));
        Assertions.assertEquals(3, romanToInt.romanToInt("III"));
    }


}

