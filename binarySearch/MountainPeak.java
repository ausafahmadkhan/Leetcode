package binarySearch;

public class MountainPeak
{
    //given a bitonic array
    public static int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1, mid;
        while (l < r)
        {
            mid = l + (r - l) / 2;
            if (mid < nums.length - 1 && nums[mid] < nums[mid + 1])
            {
                l = mid + 1;
            }
            else
            {
                r = mid;
            }
        }
        return l;
    }

    public static void main(String[] args)
    {
        int []ar = { 2, 5, 7, 9, 13, 13, 10, 8, 6, 6 , 2};
//        int []ar = {2, 1};
        System.out.println(findPeakElement(ar));
    }
}
