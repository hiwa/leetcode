package arraystring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatePalindromeTest {

    @Test
    void testIt() {

        ValidatePalindrome validatePalindrome = new ValidatePalindrome();
        assertFalse(validatePalindrome.isPalindrome("ce a c"));
    }

    @Test
    void testIt2() {

        ValidatePalindrome validatePalindrome = new ValidatePalindrome();
        assertFalse(validatePalindrome.isPalindrome("0P"));
    }

    @Test
    void testIt3() {

        ValidatePalindrome validatePalindrome = new ValidatePalindrome();
        assertTrue(validatePalindrome.isPalindrome("A man, a plan, a canal: Panama"));
    }

}