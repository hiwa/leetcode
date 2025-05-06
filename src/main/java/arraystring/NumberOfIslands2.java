package arraystring;

/*

https://leetcode.com/problems/number-of-islands/discuss/56359/Very-concise-Java-AC-solution
This is the dfs solution, it does not give  better results considering memory but easier

Time : O(M*N)
Memory : O(M*N) When grid is filled by lands.

       11111      0N111    00N11    00N11    00N11    000N1
       11111 =>   N1111 => NN111 => 0N111 => 00N11 => 00N11 ... O(min(5,3)) : O(3)
       11111      11111    11111    N1111    0N111    0N111
 */
public class NumberOfIslands2 {

    private int n;
    private int m;

    public int numIslands(char[][] grid) {
        int count = 0;
        n = grid.length;
        if (n == 0) return 0;
        m = grid[0].length;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++)
                if (grid[i][j] == '1') {
                    sinkDFS(grid, i, j);
                    ++count;
                }
        }
        return count;
    }

    private void sinkDFS(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') return;
        grid[i][j] = '0';
        sinkDFS(grid, i + 1, j);
        sinkDFS(grid, i - 1, j);
        sinkDFS(grid, i, j + 1);
        sinkDFS(grid, i, j - 1);
    }
}
