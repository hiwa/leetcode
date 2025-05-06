package arraystring;

import java.util.ArrayDeque;
import java.util.Deque;

/*

https://leetcode.com/problems/number-of-islands/submissions/
This is the BFS solution and, it gives better results considering memory than DFS ( T: O(N*M) M (where all nodes are 1 : O(N*M).

Time : O(M*N)
Memory : (Min(M,N)), why?
Because in worst case where the grid is filled with lands, the size of queue can grow up to min of M and N:

       11111      0N111    00N11    00N11    00N11    000N1
       11111 =>   N1111 => NN111 => 0N111 => 00N11 => 00N11 ... O(min(5,3)) : O(3)
       11111      11111    11111    N1111    0N111    0N111
 */
public class NumberOfIslands {

    /*
    1.The default size of ArrayDeque is 16. ArrayDeque doubles its size when it is full.
    Elements are copied to the new array after the size doubles. To avoid this, always initialize it with a proper value based on the problem.
    2.ArrayDeque is 3X faster than LinkedList. It does not have overhead of node allocations of linkedList.
    https://stackoverflow.com/a/6129967
     */
    public static final int INITIAL_CAPACITY = 25;

    public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }
        int numberOfIslands = 0;
        int rowSize = grid.length;
        int columnSize = grid[0].length;

        // navigate through all the nodes
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                // contains all the land neighbors of this land
                Deque<Integer> neighbors = new ArrayDeque<>(INITIAL_CAPACITY);
                if (grid[i][j] == '1') {
                    numberOfIslands++;
                    // i*columnsize+1 is the index (id) of the node in the grid.
                    neighbors.offer(i * columnSize + j);
                    // to mark it as already visited. Otherwise, it can be counted again later as a neighbor of another node.
                    grid[i][j] = '0';
                }
                // Why we check neighbors? To find the borders of the island. A land and its neighbor lands is a same island.
                while (!neighbors.isEmpty()) {

                    int neighborId = neighbors.poll();
                    int neighborRow = neighborId / columnSize;
                    int neighborColumn = neighborId % columnSize;

                    if (neighborRow >= 1 && grid[neighborRow - 1][neighborColumn] == '1') {
                        // to mark it as already visited. Otherwise, it can be counted again later as a neighbor of another node.
                        grid[neighborRow - 1][neighborColumn] = '0';
                        neighbors.offer((neighborRow - 1) * columnSize + neighborColumn);
                    }
                    if (neighborColumn >= 1 && grid[neighborRow][neighborColumn - 1] == '1') {
                        grid[neighborRow][neighborColumn - 1] = '0';
                        neighbors.offer((neighborRow) * columnSize + neighborColumn - 1);
                    }
                    if (neighborRow < rowSize -1 && grid[neighborRow + 1][neighborColumn] == '1') {
                        grid[neighborRow + 1][neighborColumn] = '0';
                        neighbors.offer((neighborRow + 1) * columnSize + neighborColumn);
                    }
                    if (neighborColumn < columnSize -1 && grid[neighborRow][neighborColumn + 1] == '1') {
                        grid[neighborRow][neighborColumn + 1] = '0';
                        neighbors.offer((neighborRow) * columnSize + neighborColumn + 1);
                    }
                }
            }
        }
        return numberOfIslands;
    }
}
