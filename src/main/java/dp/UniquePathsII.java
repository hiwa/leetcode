package dp;

/*
https://leetcode.com/problems/unique-paths-ii/

Time: O(N*M)
Space: O(N*M)
 */
public class UniquePathsII {

    /* If we are allowed to modify the input

        Time: O(N*M)
        Space: O(1)
    */
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {

        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        int rowSize = obstacleGrid.length;
        int columnSize = obstacleGrid[0].length;

        obstacleGrid[0][0] = 1;

        for (int i = 1; i < rowSize; i++) {
            obstacleGrid[i][0] = obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1 ? 1 : 0;
        }

        for (int i = 1; i < columnSize; i++) {
            obstacleGrid[0][i] = obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 1 ? 1 : 0;
        }
        for (int i = 1; i < rowSize; i++) {
            for (int j = 1; j < columnSize; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                } else {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                }
            }
        }
        return obstacleGrid[rowSize - 1][columnSize - 1];
    }

    /* If we don't want to modify the input
        Time: O(N*M)
        Space: O(N*M)
     */
    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {

        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        int rowSize = obstacleGrid.length;
        int columnSize = obstacleGrid[0].length;

        int[][] numberOfUniquePaths = new int[rowSize][columnSize];

        numberOfUniquePaths[0][0] = 1;

        for (int i = 1; i < rowSize; i++) {
            numberOfUniquePaths[i][0] = obstacleGrid[i][0] == 0 && numberOfUniquePaths[i - 1][0] == 1 ? 1 : 0;
        }

        for (int i = 1; i < columnSize; i++) {
            numberOfUniquePaths[0][i] = obstacleGrid[0][i] == 0 && numberOfUniquePaths[0][i - 1] == 1 ? 1 : 0;
        }
        for (int i = 1; i < rowSize; i++) {
            for (int j = 1; j < columnSize; j++) {
                if (obstacleGrid[i][j] == 1) {
                    numberOfUniquePaths[i][j] = 0;
                } else {
                    numberOfUniquePaths[i][j] = numberOfUniquePaths[i - 1][j] + numberOfUniquePaths[i][j - 1];
                }
            }
        }
        return numberOfUniquePaths[rowSize - 1][columnSize - 1];
    }
}