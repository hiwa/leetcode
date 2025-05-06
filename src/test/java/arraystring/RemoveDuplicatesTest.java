package arraystring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveDuplicatesTest {

    @Test
    void testIt() {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        assertEquals(2, removeDuplicates.removeDuplicates((new int[] {1,1,2})));

    }

}