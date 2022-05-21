package binarySearch;

public class AgnosticBS
{
    private static int searchAgnostic(int[] ar, int key) {

        boolean asc = ar[0] <= ar[ar.length - 1];

        int l = 0, r = ar.length - 1, mid;

        while (l <= r)
        {
            mid = l + (r - l) / 2;

            if (ar[mid] == key)
                return  mid;

            if (asc)
            {
                if (key > ar[mid])
                    l = mid + 1;
                else
                    r = mid - 1;
            }
            else
            {
                if (key > ar[mid])
                    r = mid - 1;
                else
                    l = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int []ar = {1, 4, 7, 9, 13, 22, 67};
        int []arr = {67, 22, 13, 9, 7, 4, 1};
        System.out.println(searchAgnostic(ar, 7));

    }
}
