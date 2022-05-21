package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Maze2Directions
{
//    2 directions with obstacles

//    0 1 2 3
//  0 s
//  1
//  2
//  3       e

    public static void getPath(boolean[][] ar)
    {
        int pathNumber[][] = {
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0},
        };

        List<String> path = getPathRecursively(ar, 0, 0, "", pathNumber, 1);
        System.out.println(path);
    }

    private static List<String> getPathRecursively(boolean[][] ar, int row, int col, String path, int[][] pathNum, int counter)
    {
        List<String> paths = new ArrayList<>();

        if (row == ar.length - 1 && col == ar[0].length - 1)
        {
            paths.add(path);
            pathNum[row][col] = counter;
            display(pathNum);
            return paths;
        }

        //an obstacle is present
        if (col == ar[0].length || row == ar.length || ar[row][col])
        {
            return paths;
        }

        pathNum[row][col] = counter;

        List<String> right = getPathRecursively(ar, row, col + 1, path + "R", pathNum, counter + 1);
        List<String> down = getPathRecursively(ar, row + 1, col, path + "D", pathNum, counter + 1);
        right.addAll(down);
        pathNum[row][col] = 0;
        return right;
    }

    public static void display(int[][] pathNum)
    {
        for (int i = 0; i < pathNum.length; i++)
        {
            for (int j = 0; j < pathNum[0].length; j++) {
                System.out.print(pathNum[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        boolean [][]ar = {
                {false, false, false, false},
                {true, false, false, false},
                {false, false, false, true},
                {false, false, false, false}
        };

        getPath(ar);
    }
}
