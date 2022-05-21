package maths;

public class AppearingTwiceExceptOne
{
    public static int appearingOnce(int[] ar)
    {
        int distinct = 0;
        for (int num : ar) {

            distinct = distinct ^ num;
        }
        return distinct;
    }


    public static void main(String[] args) {
        int ar[] = {2, 13, 6, 8, 2, 4, 6, 8, 13};
        System.out.println(appearingOnce(ar));
    }
}
