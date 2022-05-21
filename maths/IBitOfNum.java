package maths;

//find ith bit of a number
//100101000
//i = 5

public class IBitOfNum
{
    public static int getIthBit(int n, int i)
    {
        return n & 1 << (i - 1);
    }

    public static void main(String[] args)
    {
        System.out.println(Integer.toBinaryString(10));
        System.out.println(getIthBit(10, 3));
    }
}
