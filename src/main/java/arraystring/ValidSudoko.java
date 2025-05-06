package arraystring;

import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/problems/valid-sudoku/discuss/15472/Short%2BSimple-Java-using-Strings

Validate sudoko. Each row, column and box3*3 should be checked when there is a number inside.
Encode entries and add to Hashset for row, column and box. Why Hashset? as it will return False if item already exists.

O(1), O(1) Since board size is limited to 9*9 = 81

 */
public class ValidSudoko {

    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        for (int i=0; i<9; ++i) {
            for (int j=0; j<9; ++j) {
                char number = board[i][j];
                if (number != '.')
                    if (!seen.add(number + "r" + i) ||
                            !seen.add(number + "c" + j) ||
                            !seen.add(number + "b" + i/3 + "-" + j/3))
                        return false;
            }
        }
        return true;
    }
}
