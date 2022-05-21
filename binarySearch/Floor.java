package binarySearch;

public class Floor
{
    public static int getFloor(int []ar, int key)
    {

        int l = 0, r = ar.length - 1, mid;

        while (l <= r)
        {
            mid = l + (r - l) / 2;

            if (key == ar[mid])
                return mid;
            else if (key < ar[mid])
                r = mid - 1;
            else
                l = mid + 1;
        }
        return r;
    }

    public static void main(String[] args) {
        int []ar = {1, 4, 7, 7, 7, 7, 7, 7, 7, 9, 13, 22, 67};

        System.out.println(getFloor(ar, 100));
    }
}
