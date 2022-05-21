package binarySearch;

public class FindInMountainArray
{
    public int findInMountainArray(int target, int[] mountainArr)
    {
        int peakIndex = getPeak(mountainArr);
        int targetIndex = agnosticSearch(mountainArr, target, 0, peakIndex);
        if (targetIndex == -1)
            return agnosticSearch(mountainArr, target,peakIndex + 1, mountainArr.length - 1);
        else
            return targetIndex;
    }


    public int getPeak(int[] ar)
    {
        int l = 0, r = ar.length - 1, mid;


        while (l < r)
        {
            mid = l + (r - l) / 2;
            if (mid < ar.length - 1 && ar[mid] >= ar[mid + 1])
            {
                r = mid;
            }
            else
            {
                l = mid + 1;
            }
        }
        return l;
    }

    public int agnosticSearch(int[] ar, int target, int l , int r)
    {
        int mid;

        boolean asc = ar[l] <= ar[r];

        while (l <= r)
        {
            mid = l + (r - l ) / 2;
            if (ar[mid] == target)
                return mid;

            if(asc)
            {
                if(ar[mid] > target)
                {
                    r = mid - 1;
                }
                else
                {
                    l = mid + 1;
                }
            }
            else
            {
                if(ar[mid] > target)
                {
                    l = mid + 1;
                }
                else
                {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindInMountainArray obj = new FindInMountainArray();
        int ar[] = {0,5,3,1};
        System.out.println(obj.findInMountainArray(1, ar));
    }
}
