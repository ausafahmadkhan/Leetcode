package cycleSort;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
class DisappearedNumber {
    public static List<Integer> findDisappearedNumbers(int[] nums)
    {
        int temp, i;
        List<Integer> missingNums = new ArrayList<>();
        for (i = 0; i < nums.length ; i++)
        {
            if (nums[i] == i + 1)
                continue;

            else if (nums[nums[i] -1] != nums[i])
            {
                temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
                i--;
            }
        }

        for (i = 0; i < nums.length; i++)
        {
            if (nums[i] != i + 1)
                missingNums.add(i + 1);
        }

        if (missingNums.isEmpty())
            missingNums.add(-1);

        return missingNums;
    }

    public static void main(String[] args)
    {
        int []nums = {4,3,2,7,8,2,3,1};
        System.out.println(DisappearedNumber.findDisappearedNumbers(nums));
    }
}