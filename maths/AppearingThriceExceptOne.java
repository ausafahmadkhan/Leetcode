package maths;

public class AppearingThriceExceptOne
{
    public static int getDistinctNumber(int [] ar)
    {
        int[] bits = new int[32];
        int digit, i = 31;
        for (int num: ar)
        {
            while(num != 0)
            {
                digit = num & 1;
                num = num >> 1;
                if (digit == 1)
                {
                    bits[i]++;
                }
                i--;
            }
            i = 31;
        }

        for (i = 0; i < bits.length; i++)
        {
            bits[i] %= 3;
        }

        int sum = 0, j = 0;

        for (i = 31; i > 0 ; i--)
        {
            if (bits[i] == 1)
            {
                sum = sum + power(2, j);
                j++;
            }
        }
        return sum;
    }



    //O(log b)
    public static int power(int a, int b)
    {
        int digit, base = a, ans = 1;
        while(b != 0)
        {
            digit = b & 1;
            if (digit == 1)
            {
                ans *= base;
            }
            base = base * base;
            b = b >> 1;
        }
        return ans;
    }

    public static void main(String[] args)
    {
        int []ar = {2, 3, 4, 3, 4, 2, 3, 4, 2, 7};
//        int []ar = {2, 2, 2, 7};
        System.out.println(getDistinctNumber(ar));
//        System.out.println(power(2, 2));
    }
}


