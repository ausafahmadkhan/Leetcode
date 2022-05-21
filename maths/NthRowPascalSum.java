package maths;

public class NthRowPascalSum
{
//    formula is sum = 2 ^ n
    public static int sum(int n)
    {
        //0 indexed
//        for n = n -1
//      2 ^ n -1 = 1 << n -1
        return 1 << (n - 1);
    }

    public static void main(String[] args)
    {
        System.out.println(sum(4));
    }
}
