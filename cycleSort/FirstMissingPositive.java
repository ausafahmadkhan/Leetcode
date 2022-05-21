package cycleSort;

//https://leetcode.com/problems/first-missing-positive/
class FirstMissingPositive {
    public static int firstMissingPositive(int[] nums)
    {
        int i, r = nums.length -1;
        for (i = 0; i <= r && i < nums.length; i++)
        {
            if (nums[i] <= 0 || nums[i] > nums.length)
            {
                swap(nums, i, r);
                r--;
                i--;
            }
            else if (nums[nums[i] - 1] != nums[i])
            {
                swap(nums, i, nums[i] - 1);
                i--;
            }
        }

        for (i = 0; i < nums.length; i++)
        {
            if (nums[i] != i + 1)
                return i + 1;
        }
        return i + 1;
    }

    public static void swap(int []ar, int i, int j)
    {
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }

    public static void main(String[] args)
    {
        int []ar = {1,2,2,1,-3,1,0,4,0};
        System.out.println(FirstMissingPositive.firstMissingPositive(ar));
    }
}