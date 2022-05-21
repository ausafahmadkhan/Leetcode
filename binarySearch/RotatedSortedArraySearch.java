package binarySearch;

public class RotatedSortedArraySearch
{
    public static int search(int[] nums, int target)
    {
        int pivot = getPivot(nums);
        if (pivot != -1)
        {
            if (target >= nums[0])
                return binarySearch(nums, target, 0, pivot);
            else
                return binarySearch(nums, target, pivot + 1, nums.length - 1);
        }

        return binarySearch(nums, target, 0, nums.length - 1);
    }

    public static int binarySearch(int []nums, int target, int l, int r)
    {
        int mid;

        while (l <= r)
        {
            mid = l + (r - l) / 2;

            if (target == nums[mid])
                return mid;
            else if (target > nums[mid])
                l = mid + 1;
            else
                r = mid - 1;
        }
        return -1;
    }



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
        int []ar = {15, 20, 1, 3, 5, 7, 9, 13};
        System.out.println(search(ar, 5));
    }

}
