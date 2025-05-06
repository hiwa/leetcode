package arraystring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductExceptSelfTest {

    @Test
    void testIt() {
        ProductExceptSelf productExceptSelf = new ProductExceptSelf();

        assertEquals(1, productExceptSelf.productExceptSelfWithDivision(new int[]{1})[0]);

        assertEquals(12, productExceptSelf.productExceptSelfWithDivision(new int[]{2, 3, 4})[0]);

        assertEquals(0, productExceptSelf.productExceptSelfWithDivision(new int[]{2, 0, 0})[0]);

        assertEquals(0, productExceptSelf.productExceptSelfWithDivision(new int[]{2, 0, 4})[0]);
        assertEquals(8, productExceptSelf.productExceptSelfWithDivision(new int[]{2, 0, 4})[1]);
    }

    @Test
    void testIt1() {
        ProductExceptSelf productExceptSelf = new ProductExceptSelf();

        assertEquals(1, productExceptSelf.productExceptSelf(new int[]{1})[0]);

        assertEquals(12, productExceptSelf.productExceptSelf(new int[]{2, 3, 4})[0]);

        assertEquals(0, productExceptSelf.productExceptSelf(new int[]{2, 0, 0})[0]);

        assertEquals(0, productExceptSelf.productExceptSelf(new int[]{2, 0, 4})[0]);
        assertEquals(8, productExceptSelf.productExceptSelf(new int[]{2, 0, 4})[1]);
    }
}