package backtracking;

public class NKnights
{

//    X X X X
//    X X X X
//    X X X X
//    X X X X

    public static void placeNKnights(boolean[][] board, int knights)
    {
        int count = placeNKnightsRecursively(board, 0, 0, knights);
        System.out.println(count);
        int count2 = placeNKnightsRecursively2(board, 0, 0, knights);
        System.out.println(count2);
    }

    private static int placeNKnightsRecursively(boolean[][] board, int row, int col, int knights)
    {
        int count = 0;

        if (knights == 0)
        {
            NQueens.display(NQueens.getPositions(board, 'K'));
            return count + 1;
        }

        if (row == board.length)
        {
            return count;
        }


        if (col == board.length)
            return count + placeNKnightsRecursively(board, row + 1, 0, knights);

        if (isSafe(board, row, col))
        {
            board[row][col] = true;
            count += placeNKnightsRecursively(board, row, col + 1, knights - 1);
            board[row][col] = false;
        }

        count += placeNKnightsRecursively(board, row, col + 1, knights);
        return count;
    }

    private static int placeNKnightsRecursively2(boolean[][] board, int row, int col, int knights)
    {
        int count = 0;

        if (knights == 0)
        {
            NQueens.display(NQueens.getPositions(board, 'K'));
            return count + 1;
        }

        if (row == board.length)
        {
            return count;
        }

        for (int i = col; i < board.length ; i++)
        {
            if (isSafe(board, row, i))
            {
                board[row][i] = true;
                count += placeNKnightsRecursively2(board, row, i + 1, knights - 1);
                board[row][i] = false;
            }
        }

        count += placeNKnightsRecursively2(board, row + 1, 0, knights);
        return count;
    }


    private static boolean isSafe(boolean[][] board, int row, int col)
    {
        if (isValid(row - 2, col - 1, board))
            if (board[row - 2][col - 1])
                return false;

        if (isValid(row - 2, col + 1, board))
            if (board[row - 2][col + 1])
                return false;

        if (isValid(row - 1, col - 2, board))
            if (board[row - 1][col - 2])
                return false;

        if (isValid(row - 1, col + 2, board))
            if (board[row - 1][col + 2])
                return false;

        return true;
    }

    private static boolean isValid(int row, int col, boolean[][] board)
    {
        return (row >= 0 && row < board.length && col >= 0 && col < board.length);
    }

    public static void main(String[] args)
    {
        boolean[][] board = {
                {false, false, false, false},
                {false, false, false, false},
                {false, false, false, false},
                {false, false, false, false}
        };

        placeNKnights(board, 4);
    }
}
