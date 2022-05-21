package binarySearch;

class KMissing {
    public static int findKthPositive(int[] arr, int k) {
        
        int l = 0, r = arr.length - 1, mid, exp, count = 0;
        
        while  (l < r)
        {
            mid = l + (r - l) / 2;
            exp = mid + 1;
            count = arr[mid] - exp;
            
            if (count >= k)
            {
                r = mid;
            }
            else
            {
                l = mid + 1;
            }
        }
        
        exp = l + 1;
        count = arr[l] - exp;

        if (count == 0)
        {
            return arr[l] + k;
        }
        else if (count >= k)
        {
            return arr[l] - (count - k + 1);
        }
        else
        {
            return arr[l] - (count - k);
        }
    }

    public static void main(String[] args) {
        int []ar = {5, 6, 7, 8, 9};
        System.out.println(findKthPositive(ar, 4));
    }
}