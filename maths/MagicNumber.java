package maths;

//Amazon
public class MagicNumber
{
    public static int magicNumber(int n)
    {
        int base = 5, ans = 0;
        while (n != 0)
        {
            if ((n & 1) == 1)
            {
                ans = ans + base;
            }
            base = base * 5;
            n = n >> 1;
        }
        return ans;
    }

    public static void main(String[] args)
    {
        System.out.println(magicNumber(6));
    }
}
