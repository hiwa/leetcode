package arraystring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocalMinimumTest {


    @Test
    void testIt() {
        LocalMinimum localMinimum = new LocalMinimum();
        assertEquals(1, localMinimum.findLocalMinimum(new int[]{8,9,12,1,7}));
    }


}