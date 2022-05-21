package maths;

public class SetIthBit
{
//    10010010
    public static int setBit(int i, int n)
    {
        return n | (1 << i - 1);
    }

    public static void main(String[] args)
    {
        System.out.println(Integer.toBinaryString(10));
        System.out.println(Integer.toBinaryString(setBit(1, 10)));
    }
}
