package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Maze4Directions
{
//    4 directions with obstacles

//    0 1 2 3
//  0 s
//  1
//  2
//  3       e


    public static  void getPath(boolean[][] ar)
    {
        int [][]pathNum = {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
        };
        List<String> paths = getPathRecursively(ar, 0, 0, "", pathNum, 1);
        System.out.println(paths);
    }

    public static List<String> getPathRecursively(boolean[][] ar, int row, int col, String path, int[][] pathNum, int counter)
    {
        List<String> paths = new ArrayList<>();

        if (row == ar.length - 1 && col == ar[0].length - 1)
        {
            pathNum[row][col] = counter;
            paths.add(path);
            Maze2Directions.display(pathNum);
            return paths;
        }

        if (row >= ar.length || row < 0 || col >= ar[0].length || col < 0 || ar[row][col])
        {
            return paths;
        }

        //visited
        ar[row][col] = true;
        pathNum[row][col] = counter;

        List<String> left = getPathRecursively(ar, row, col - 1, path +  "L", pathNum, counter  +1);
        List<String> right = getPathRecursively(ar, row, col + 1, path +  "R", pathNum, counter + 1);
        List<String> up = getPathRecursively(ar, row - 1, col, path +  "U", pathNum, counter + 1);
        List<String> down = getPathRecursively(ar, row + 1, col , path +  "D", pathNum, counter + 1);

        left.addAll(right);
        left.addAll(up);
        left.addAll(down);

        //backtracking
        ar[row][col] = false;
        pathNum[row][col] = 0;
        return left;
    }

    public static void main(String[] args)
    {
        boolean [][]ar = {
                {false, false, false, false},
                {false, false, false, false},
                {false, false, false, false},
                {false, false, false, false}
        };

        getPath(ar);
    }


}
