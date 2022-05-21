package maths;

import java.util.Arrays;

public class FlipAndInvertImage
{
    public static int[][] flipNInvert(int[][] arr)
    {
        for (int[] ar : arr)
        {
            for (int i = 0; i < (ar.length + 1)/2; i++)
            {
                int temp = ar[ar.length - i - 1];
                ar[ar.length - i - 1] = ar[i] ^ 1;
                ar[i] = temp ^ 1;
            }
        }
        return arr;
    }

    public static void main(String[] args)
    {
        int [][]arr = {
                {1, 1, 0},
                {1, 0, 1},
                {0, 0, 0}
        };

//        int[] ar = {1, 2, 3};
//
//        System.out.println(Arrays.toString(ar));

        System.out.println(Arrays.deepToString(arr));
    }
}
