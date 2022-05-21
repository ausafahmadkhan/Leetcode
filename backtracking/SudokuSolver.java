package backtracking;

public class SudokuSolver
{
    public static void solveSudoku(char[][] board)
    {
        System.out.println(isSolved(board, 0, 0));
        display(board);
        System.out.println(ValidateSudoku.isValidSudoku(board));
    }

    private static boolean isSolved(char[][] board, int row, int col)
    {
        if (row == board.length)
            return true;

        if (col == board.length)
            return isSolved(board, row + 1, 0);

        if (board[row][col] == '.')
        {
            for (int k = 49; k < 58; k++)
            {
                if (isValid(board, row, col, (char)k))
                {
                    board[row][col] = (char) k;
                    if (isSolved(board, row, col + 1))
                        return true;
                    else
                        board[row][col] = '.';
                }
            }
            return false;
        }
        else
            return isSolved(board, row, col + 1);
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

    public static void display(char[][] board)
    {
        for (char[] chars : board) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(chars[j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        char[][] board ={
                         {'5','3','.','.','7','.','.','.','.'},
                         {'6','.','.','1','9','5','.','.','.'},
                         {'.','9','8','.','.','.','.','6','.'},
                         {'8','.','.','.','6','.','.','.','3'},
                         {'4','.','.','8','.','3','.','.','1'},
                         {'7','.','.','.','2','.','.','.','6'},
                         {'.','6','.','.','.','.','2','8','.'},
                         {'.','.','.','4','1','9','.','.','5'},
                         {'.','.','.','.','8','.','.','7','9'}
                        };

        solveSudoku(board);
    }
}
