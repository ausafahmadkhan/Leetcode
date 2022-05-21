package backtracking;

public class ValidateSudoku
{
    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board.length ; j++) {
                if (board[i][j] == '.')
                    continue;

                char temp = board[i][j];
                board[i][j] = 'X';
                if (!isValid(board, i, j, temp))
                    return false;
                board[i][j] = temp;
            }
        }
        return true;
    }

    private static boolean isValid(char[][] board, int row, int col, char key)
    {
        for (int i = 0; i < board.length ; i++)
        {
            if (board[row][i] == key)
                return false;
        }

        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == key)
                return false;
        }

        int m = (row / 3) * 3, n = (col / 3) * 3;
        for (int i = m; i < m + 3 ; i++) {
            for (int j = n; j < n + 3 ; j++) {
                if (board[i][j] == key)
                    return false;
            }
        }

        return true;
    }

    public static void main(String[] args)
    {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'}
                        ,{'6','.','.','1','9','5','.','.','.'}
                        ,{'.','9','8','.','.','.','.','6','.'}
                        ,{'8','.','.','.','6','.','.','.','3'}
                        ,{'4','.','.','8','.','3','.','.','1'}
                        ,{'7','.','.','.','2','.','.','.','6'}
                        ,{'.','6','.','.','.','.','2','8','.'}
                        ,{'.','.','.','4','1','9','.','.','5'}
                        ,{'.','.','.','.','8','.','.','7','9'}};

        char[][] board2 = {{'5','3','.','.','7','.','.','.','.'}
                         ,{'6','.','.','1','9','5','.','.','.'}
                         ,{'.','9','8','.','.','.','.','6','.'}
                         ,{'8','.','.','.','6','.','.','.','3'}
                         ,{'4','.','.','8','.','3','.','.','1'}
                         ,{'7','.','.','.','X','.','.','.','6'}
                         ,{'.','6','.','.','.','.','2','8','.'}
                         ,{'.','.','.','4','1','9','.','.','5'}
                         ,{'.','.','.','.','8','.','.','7','9'}};

        System.out.println(isValidSudoku(board));
    }
}
