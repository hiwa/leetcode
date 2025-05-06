package arraystring;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/sparse-matrix-multiplication/solution/

Three solutions available:
1. Brute Force           loop through all elements              Time  O(N^3) , Space : O(1)
2. brute force enhanced  loop through all none zero elements    Time  O(N^3) , Space : O(1)
3. Compressed matrix                                            Time  O(N^3) , Space : O(m*k + k*n) :
in worst case , all elements of matrices are none zero values, so we should store all of them.
For Mat1[m][k], m*k elements and for mat2[k][n] elements, if matrices have same dimensions it would be O(2N^2) = O(N^2)

Still solution 3 is better, as we generally sacrifice space for speed and solution 3 is much faster in sparse matrices.


 */
public class SparseMatrixMultiplication {

    /*
        mat1 :  |1  0|   mat 2 : |2   1| => result : |2  1|
                |0  1|           |0   0|             |0  0|
     */
    public int[][] multiply(int[][] mat1, int[][] mat2) {

        int rowSize1 = mat1.length;

        int columnSize2 = mat2[0].length;

        int[][] result = new int[rowSize1][columnSize2];

        // M1 : [[(0,1)],[(1,1)]
        List<List<Pair<Integer, Integer>>> compressedMatrix1 = compressMatrix(mat1);
        // M2 : [[(0,2),(1,1)],[]]
        List<List<Pair<Integer, Integer>>> compressedMatrix2 = compressMatrix(mat2);

        for (int mat1Row = 0; mat1Row < compressedMatrix1.size(); ++mat1Row) {
            // Iterate on all current 'row' non-zero elements of mat1.
            for (Pair<Integer, Integer> mat1Element : compressedMatrix1.get(mat1Row)) {
                // (comments are only for the first item (0,1)
                int mat1Col = mat1Element.getKey();   //0
                int element1 = mat1Element.getValue();//1

                // Multiply and add all non-zero elements of mat2
                // where the row is equal to col of current element of mat1.
                for (Pair<Integer, Integer> mat2Element : compressedMatrix2.get(mat1Col)) {
                    //(0,2)
                    int mat2Col = mat2Element.getKey();   //0
                    int element2 = mat2Element.getValue(); //2
                    // result[0][0] : 1 * 2 = 2
                    result[mat1Row][mat2Col] += element1 * element2;
                }
            }
        }
        return result;
    }

    private List<List<Pair<Integer, Integer>>> compressMatrix(int[][] matrix) {

        //if compressedMatrix[i] = [[j,k],[x,y]] => row i,col m = n & row i, col x = y
        List<List<Pair<Integer, Integer>>> compressedMatrix = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            List<Pair<Integer, Integer>> rowPairs = new ArrayList<>();
            for (int column = 0; column < matrix[0].length; column++) {
                if (matrix[row][column] != 0) {
                    rowPairs.add(new ImmutablePair<>(column, matrix[row][column]));
                }
            }
            compressedMatrix.add(rowPairs);
        }
        return compressedMatrix;
    }

    public int[][] multiplyImprovedBruteForce(int[][] mat1, int[][] mat2) {

        int rowSize1 = mat1.length;

        int columnSize1 = mat1[0].length;

        int columnSize2 = mat2[0].length;

        int[][] result = new int[rowSize1][columnSize2];

        // M1 : M*N, M2: N*K
        // Order of loop is row1 (M), col1 (N), col2 (K)
        for (int row = 0; row < rowSize1; row++) {
            for (int elementIndex = 0; elementIndex < columnSize1; elementIndex++) {
                if (mat1[row][elementIndex] != 0) {
                    for (int column = 0; column < columnSize2; column++) {
                        result[row][column] += mat1[row][elementIndex] * mat2[elementIndex][column];

                    }

                }
            }
        }
        return result;
    }
}
