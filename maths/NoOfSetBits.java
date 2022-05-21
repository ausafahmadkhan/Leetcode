package maths;

public class NoOfSetBits
{
    public static int noOfSetBits(int num)
    {
        int count = 0;
        while(num != 0)
        {
            num = num - (num & -num);
            count++;
        }
        return count;
    }

    public static void main(String[] args)
    {
        int n = 263;
        System.out.println(Integer.toBinaryString(n));
        System.out.println(noOfSetBits(n));
    }
}
