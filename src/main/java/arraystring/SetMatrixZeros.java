package arraystring;

/*
https://leetcode.com/problems/set-matrix-zeroes/discuss/26014/Any-shorter-O(1)-space-solution/193619

Given an m x n integer matrix, if an element is 0, set its entire row and column to 0's. (In place)

Solution: In first M*N loop If m[i,j] == 0 -> set m[i,0]=m[0,j]=0
In 2nd M*N loop ; if m[i,0]=0 || m[0,j]=0 => m[i,j]=0
Corner case first row, first column


O(N*M)
O(1)
 */
public class SetMatrixZeros {
    private int rowLen;
    private int colLen;

    public void setZeroes(int[][] matrix) {
        rowLen = matrix.length;
        colLen = matrix[0].length;
        boolean rowAffect = false;
        boolean colAffect = false;

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (matrix[i][j] == 0) {

                    if (i == 0) rowAffect = true;
                    if (j == 0) colAffect = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }


        for (int i = 1; i < rowLen; i++) {
            for (int j = 1; j < colLen; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }


        if (rowAffect) {
            cleanRow(0, matrix);
        }


        if (colAffect) {
            cleanCol(0, matrix);
        }

    }

    private void cleanRow(int row, int[][] matrix) {
        for (int j = 0; j < colLen; j++) {
            matrix[row][j] = 0;
        }
    }

    private void cleanCol(int col, int[][] matrix) {
        for (int i = 0; i < rowLen; i++) {
            matrix[i][col] = 0;
        }
    }
}
