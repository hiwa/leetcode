package treegraph;

import arraystring.NumberOfIslands;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberOfIslandsTest {

    @Test
    void testIt() {
        char[][] grid = { {'0','1','0'}, {'0', '1', '0'}, {'0','0','1'} , {'0','1','0'}};

        NumberOfIslands numberOfIslands = new NumberOfIslands();
        assertEquals(3,  numberOfIslands.numIslands(grid));
    }

    @Test
    void testIt_2n2() {
        char[][] grid = { {'0','1', '1', '1', '0', '1'}};

        NumberOfIslands numberOfIslands = new NumberOfIslands();
        assertEquals(2,  numberOfIslands.numIslands(grid));
    }

    @Test
    void testIt_play_with_multi_dimension_array() {
        char[][] grid = { {'0','0','0'}, {'0', '1', '0'}, {'0','0','1'} , {'0','1','0'}};
        assertEquals(4, grid.length);
        assertEquals(3, grid[0].length);
    }

}