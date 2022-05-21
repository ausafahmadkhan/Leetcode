package array;

public class PivotIndex
{
    public static int pivotIndex(int[] nums)
    {
        if (nums.length == 0)
            return -1;

        int sum = 0;
        for (int num : nums)
            sum+= num;

        int current = 0, pivot = 0;

        for (int num: nums)
        {
            sum -= num;

            if (sum == current)
                return pivot;

            current += num;
            pivot++;
        }

        return -1;
    }

    public static void main(String[] args)
    {
//        int []ar = {1,7,3,6,5,6};
        int []ar = {-1,-1,-1,-1,0,1};
        System.out.println(pivotIndex(ar));

    }
}
