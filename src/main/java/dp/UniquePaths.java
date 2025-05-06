package dp;

/*
https://leetcode.com/problems/unique-paths/discuss/182143/Recursive-memoization-and-dynamic-programming-solutions
Second solution implemented here:
 */
public class UniquePaths {
    /*
        Memoization (Runtime 0 ms, Time complexity m x n, Space complexity: m x n)
     */
    public int uniquePaths(int m, int n) {
        // Grid initialized with 0 to store sub-problems solutions which is number of unique paths to reach node. Memory complexity is thus M*N
        int[][] memo = new int[m][n];
        // m and n are sizes. Recursive methods work with indices.
        return uniquePaths(m - 1, n - 1, memo);
    }

    /*
    1. Returns number of unique paths to reach grid[row][column] from grid[0][0]
    2. Memoization improves the performance as we don't need to recalculate some nodes.
    3. All nodes at row/column 0, have only one unique path.
     */
    private int uniquePaths(int row, int column, int[][] memo) {
        // To read the sub-problem solution we check memo if we already stored the solution
        // Alternatively it can be checked with != 0
        if (memo[row][column] > 0) {
            return memo[row][column];
        }
        /*
        All nodes at row/column 0, have only one unique path.
              1 1 1 1
              1 - - -
              1 - - -
              1 - - ?
         */
        if (row == 0 || column == 0) {
            memo[row][column] = 1;
            return 1;
        }
        /* As we can only go from top to down and from left to right,
           for each node i,j ; there are 2 unique paths : top (i-1,j) OR left(i, j-1)
         */
        memo[row][column] = uniquePaths(row - 1, column, memo) + uniquePaths(row, column - 1, memo);
        return memo[row][column];
    }

    //My solution Much easier
    public int uniquePathsHiwa(int m, int n) {
        int[][] cache = new int[m][n];

         //Either fill all items by default 1 or more precisely only fill (i,0) and (0,j) to 1.
//        for (int[] array: cache) {
//            Arrays.fill(array, 1);
//        }

        for (int i = 0; i < m; i++) {
            cache[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            cache[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                cache[i][j] = cache[i-1][j] + cache[i][j-1];
            }
        }
        return cache[m-1][n-1];
    }
}