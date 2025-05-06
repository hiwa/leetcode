package backtrack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PermuteTest {

    @Test
    void testIt() {

        Permute permute = new Permute();

        assertEquals(6, permute.permute(new int[]{1, 2, 3}).size());
    }

}