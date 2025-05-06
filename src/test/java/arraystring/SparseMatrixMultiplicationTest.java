package arraystring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SparseMatrixMultiplicationTest {


    @Test
    void testIt() {
        /* [24, 29, 14, 9]
           [6, 25, 26, 15]
         */
        SparseMatrixMultiplication sparseMatrixMultiplication = new SparseMatrixMultiplication();
        int[][] mat1 = {{3, -2, 5}, {3, 0, 4}};
        int[][] mat2 = {{2, 3, 6, 5}, {-9, 0, 7, 3}, {0, 4, 2, 0}};
        // enhanced brute force
        int[][] result = sparseMatrixMultiplication.multiplyImprovedBruteForce(mat1, mat2);
        assertEquals(2, result.length);
        // compressed matrices
        int[][] result2 = sparseMatrixMultiplication.multiply(mat1, mat2);
        assertEquals(2, result2.length);

    }

}