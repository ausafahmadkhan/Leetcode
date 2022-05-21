package maths;

public class RightMostSetBit
{

//    1000100000
//    6

//            n =  a 1 00000
//      &    -n = ~a 1 00000
//                ans

    public static int rightMostSetBit(int n)
    {
        return n & -n;
    }

    public static void main(String[] args)
    {
        System.out.println(rightMostSetBit(8));
        System.out.println(Integer.toBinaryString(8));
    }
}
