package backtrack.parentheses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinRemoveToReturnValidTest {

    @Test
    void testIt() {

        MinRemoveToReturnValid minRemoveToReturnValid = new MinRemoveToReturnValid();

        assertEquals("((vf()vf)E)", minRemoveToReturnValid.minRemoveToMakeValid("((vf(()vf)(E)(("));

        assertEquals("d(e)", minRemoveToReturnValid.minRemoveToMakeValid("d)(e)((("));
    }

}