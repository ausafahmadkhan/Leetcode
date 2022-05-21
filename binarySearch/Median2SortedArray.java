package binarySearch;

class Median2SortedArray
{

    public static double findMedianSortedArrays(int[] nums1, int[] nums2)
    {
        if (nums2.length < nums1.length)
            return findMedianSortedArrays(nums2, nums1);

        int totalCut = (nums1.length + nums2.length) / 2;

        int cut1, cut2, low = 0, high = nums1.length, l1 = 0, r1 = 0, l2 = 0, r2 = 0;

        while(low <= high)
        {
            cut1 = low + (high - low) /2;
            cut2 = totalCut - cut1;

            l1 = (cut1 != 0) ? nums1[cut1 - 1] : Integer.MIN_VALUE;
            r1 = (cut1 != nums1.length ) ? nums1[cut1] : Integer.MAX_VALUE;
            l2 = (cut2 != 0) ? nums2[cut2 - 1] : Integer.MIN_VALUE;
            r2 = (cut2 != nums2.length) ? nums2[cut2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1)
            {
                break;
            }
            else if (l1 > r2)
            {
                high = cut1 - 1;
            }
            else
            {
                low = cut1 + 1;
            }
        }


        if ((nums1.length + nums2.length) % 2 == 0)
        {
            return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
        }
        else
        {
            return Math.min(r1, r2);
        }
    }

    public static void main(String[] args)
    {
//        int []ar1 = {1, 5, 8, 10, 18, 20};
//        int []ar2 = {2, 3, 6, 7};
        int[] ar1 = { -5, 3, 6, 12, 15 };
        int[] ar2 = { -12, -10, -6, -3, 4, 10 };
        System.out.println(Median2SortedArray.findMedianSortedArrays(ar1, ar2));
    }
}