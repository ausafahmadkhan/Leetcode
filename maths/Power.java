package maths;


//O(log(b))
public class Power
{
    public static long power(long a, long b)
    {
        long base = a, res = 1;
        while(b != 0)
        {
            if ((b & 1) == 1)
            {
                res *= base;
            }
            base = base * base;
            b = b >> 1;
        }
        return res;
    }

    public static void main(String[] args)
    {
        System.out.println(power(2, 8));
    }
}
