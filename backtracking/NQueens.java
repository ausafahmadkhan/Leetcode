package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens
{

//    X X X X
//    X X X X
//    X X X X
//    X X X X

    public static void placeNQueens(boolean[][] board, int queens)
    {
        int count = placeNQueensRecursively(board, queens, 0, 0);
        System.out.println(count);
        int count2 = placeNQueensRecursively(board, queens, 0);
        System.out.println(count2);

    }

    public static int placeNQueensRecursively(boolean[][] board, int queens, int row, int col)
    {
        int count = 0;

        if (queens == 0)
        {
            display(getPositions(board, 'Q'));
            return count + 1;
        }

        if (row == board.length)
        {
            return count;
        }


        if (col == board.length) {
            return count + placeNQueensRecursively(board, queens, row + 1, 0);
        }

        if (isSafe(board, row, col))
        {
            board[row][col] = true;
            count += placeNQueensRecursively(board, queens - 1, row + 1, 0);
            board[row][col] = false;
        }

        count += placeNQueensRecursively(board, queens, row, col + 1);

        return count;
    }

    private static boolean isSafe(boolean[][] board, int row, int col)
    {
        //up
        for (int i = 0; i < row ; i++) {
            if (board[i][col])
                return false;
        }

        //left diag
        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++)
        {
            if (board[row - i][col - i])
                return false;
        }

        //right diag
        int maxRight = Math.min(row, board.length - 1 - col);
        for (int i = 1; i <= maxRight; i++)
        {
            if (board[row - i][col + i])
                return false;
        }

        return true;
    }

    public static char[][] getPositions(boolean[][] board, char ch)
    {
        char[][] pos = new char[board.length][board.length];
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board.length ; j++)
            {
                if(board[i][j])
                    pos[i][j] = ch;
                else
                    pos[i][j] = 'X';
            }
        }
        return pos;
    }

    public static void display(char[][] board)
    {
        System.out.println("\n");
        for (char[] chars : board) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(chars[j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int placeNQueensRecursively(boolean[][] board, int queens, int row)
    {
        int count = 0;
        if (queens == 0)
        {
            display(getPositions(board, 'Q'));
            return count + 1;
        }

        if (row == board.length)
            return count;

        for (int i = 0; i < board.length; i++)
        {
            if (isSafe(board, row, i))
            {
                board[row][i] = true;
                count += placeNQueensRecursively(board, queens - 1, row + 1);
                board[row][i] = false;
            }
        }
        count += placeNQueensRecursively(board, queens, row + 1);

        return count;
    }


    public static void main(String[] args)
    {
        boolean[][] board = {
                {false, false, false, false},
                {false, false, false, false},
                {false, false, false, false},
                {false, false, false, false}
        };

        placeNQueens(board, 4);
    }

}
