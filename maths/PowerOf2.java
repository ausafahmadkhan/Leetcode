package maths;

public class PowerOf2
{
    public static boolean isPowerOf2(int n)
    {
        return (n & (n - 1)) == 0;
    }

    public static void main(String[] args)
    {
        int n = 64;
        System.out.println(Integer.toBinaryString(n));
        System.out.println(isPowerOf2(n));
    }
}
