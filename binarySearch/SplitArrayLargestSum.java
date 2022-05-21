package binarySearch;


//https://leetcode.com/problems/split-array-largest-sum/

public class SplitArrayLargestSum {

    public static int splitArray(int[] nums, int m)
    {
        int l = nums[0], r = 0;
        for (int num : nums)
        {
            l = Math.max(l, num);
            r += num;
        }

        int mid;
        while (l < r)
        {
            mid = (l + r) / 2;
            boolean possible = checkIfPartitionPossible(mid, nums, m);
            if (possible)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

    private static boolean checkIfPartitionPossible(int maxSum, int[] nums, int m)
    {
        int partitions = 1, sum = 0;
        for (int i = 0; i < nums.length; i++)
        {
            sum += nums[i];
            if (sum <= maxSum)
            {
                continue;
            }
            else
            {
                partitions++;
                sum = 0;
                i--;
            }
        }
        return partitions <= m;
    }


    public static void main(String[] args)
    {
        int []ar = {7,2,5,10,8};
        System.out.println(SplitArrayLargestSum.splitArray(ar, 2));
    }
}
