package cycleSort;

//https://leetcode.com/problems/missing-number/
class MissingNumber {
    public static int missingNumber(int[] nums)
    {
        for (int i = 0; i < nums.length ; i++)
        {
            if (nums[i] == i || nums[i] == nums.length)
                continue;
            else
            {
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
                i--;
            }
        }

        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] != i)
                return i;
        }

        return nums.length;
    }

    public static void main(String[] args)
    {
        int []ar = {8,6,4,2,3,5,7,0,1};
        System.out.println(MissingNumber.missingNumber(ar));
    }
}