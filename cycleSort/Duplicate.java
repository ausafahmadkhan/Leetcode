package cycleSort;


//https://leetcode.com/problems/find-the-duplicate-number/
class Duplicate {
    public static int findDuplicate(int[] nums)
    {
        int temp;
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] == i + 1)
                continue;

            else if (nums[nums[i] - 1] != nums[i])
            {
                temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
                i--;
            }
        }

        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] != i + 1)
                return nums[i];
        }
        return -1;
    }

    public static void main(String[] args)
    {
        int []ar = {3,1,3,4,2};
        System.out.println(Duplicate.findDuplicate(ar));
    }
}