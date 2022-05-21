package maths;

public class Xor0ToA
{

    public static int getXor(int a)
    {
        int rem = a % 4;
        switch(rem)
        {
            case 0 : return a;
            case 1 : return 1;
            case 2 : return a + 1;
            case 3 : return 0;
        }

        return -1;
    }

    public static void main(String[] args)
    {
        System.out.println(getXor(9));
    }
}
