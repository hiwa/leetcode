package arraystring;

/*
https://leetcode.com/problems/word-search/discuss/27658/Accepted-very-short-Java-solution.-No-additional-space./26701

T: M*N*3^L where matrix is N*M and L is word.length
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++) {
                if (exist(board, i, j, word, 0))
                    return true;
            }
        return false;
    }

    private boolean exist(char[][] board, int i, int j, String word, int ind) {
        if (ind == word.length()) return true;
        if (i > board.length - 1 || i < 0 || j < 0 || j > board[0].length - 1 || board[i][j] != word.charAt(ind))
            return false;
        board[i][j] = '*';
        boolean result = exist(board, i - 1, j, word, ind + 1) ||
                exist(board, i, j - 1, word, ind + 1) ||
                exist(board, i, j + 1, word, ind + 1) ||
                exist(board, i + 1, j, word, ind + 1);
        board[i][j] = word.charAt(ind);
        return result;
    }
}
