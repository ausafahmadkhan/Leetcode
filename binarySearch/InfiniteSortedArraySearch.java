package binarySearch;

public class InfiniteSortedArraySearch
{
    public static int[] getChunk(int[] ar, int target)
    {
        int l = 0, r = 1, temp;
        while (true)
        {

            if (target <= ar[r]) {
                return new int[] {l, r};
            }

            temp = l;
            l = r + 1;
            r = r + (2 * (r - temp + 1));
        }
    }

    public static int search(int []ar, int l, int r, int target)
    {
        int mid;

        while (l <= r)
        {
            mid = l + (r - l) / 2;

            if (target == ar[mid])
                return mid;
            else if (target > ar[mid])
                l = mid + 1;
            else
                r = mid - 1;
        }
        return -1;
    }

    public static int doSearch(int []ar, int target)
    {
        int []chunk = getChunk(ar, target);
        return search(ar, chunk[0], chunk[1], target);
    }


    public static void main(String[] args)
    {
        int []ar = {1, 3, 6, 8, 9, 12, 14, 16, 18, 19, 21, 27, 33, 56};
        System.out.println(doSearch(ar, 27));
    }
}
