package binarySearch;

public class Pivot
{
    public static int getPivot(int []nums)
    {
        int l = 0, r = nums.length -1, mid;
        while (l < r)
        {
            mid = l + (r - l) / 2;
            if (mid > l && nums[mid] < nums[mid - 1])
            {
                return mid - 1;
            }

            if (mid < nums.length -1 && nums[mid] > nums[mid + 1])
            {
                return mid;
            }

            if (nums[mid] < nums[l])
            {
                r = mid - 1;
            }
            else
            {
                l = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args)
    {
        int []ar = {7, 8, 9, 12, 1, 4, 6};
//        int []ar = {7, 8, 9, 12, 13, 14, 16};
        System.out.println(getPivot(ar));
    }
}
