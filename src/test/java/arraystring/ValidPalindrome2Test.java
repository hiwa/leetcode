package arraystring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidPalindrome2Test {

    @Test
    void testIt() {
        ValidPalindrome2 validPalindrome2 = new ValidPalindrome2();
        assertTrue(validPalindrome2.validatePalindrome("damad"));
        assertFalse(validPalindrome2.validatePalindrome("damadd"));
        assertTrue(validPalindrome2.validatePalindrome("  "));


        assertTrue(validPalindrome2.validPalindrome("damadd"));
        assertTrue(validPalindrome2.validPalindrome("daaazmaaad"));
        assertTrue(validPalindrome2.validPalindrome("d"));

    }

}