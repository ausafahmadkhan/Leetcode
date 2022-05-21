package binarySearch;

public class Ceiling {
    public static int getCeiling(int []ar, int key)
    {
        int l = 0, r = ar.length - 1, mid;

        if (key > ar[ar.length - 1])
            return -1;

        while (l <= r)
        {
            mid = l + (r - l) / 2;

            if (key == ar[mid])
                return mid;
            else if (key > ar[mid])
                l = mid + 1;
            else
                r = mid - 1;
        }
        return l;
    }

    public static void main(String[] args) {
        int []ar = {1, 4, 7, 7, 7, 7, 9, 13, 22, 67};
        System.out.println(getCeiling(ar, 97));
    }
}
