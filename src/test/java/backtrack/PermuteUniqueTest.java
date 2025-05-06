package backtrack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PermuteUniqueTest {

    @Test
    void testIt_no_duplicate() {

        PermuteUnique permuteUnique = new PermuteUnique();

        assertEquals(6, permuteUnique.permuteUnique(new int[]{1, 2, 3}).size());
    }

    @Test
    void testIt_duplicate_11() {

        PermuteUnique permuteUnique = new PermuteUnique();

        assertEquals(1, permuteUnique.permuteUnique(new int[]{1, 1}).size());
    }

    @Test
    void testIt_duplicate() {

        PermuteUnique permuteUnique = new PermuteUnique();

        assertEquals(3, permuteUnique.permuteUnique(new int[]{1, 2, 1}).size());
    }

}