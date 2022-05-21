package random;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class MinSum
{
    //2 2 5 4
    public static int getMinimumUniqueSum(List<Integer> arr) {

        Collections.sort(arr);

        int sum = 0;

        for (int i = 0; i < arr.size(); i++) {
            sum += arr.get(i);
        }

        int cur = -1, dup = 0;
        for (int i = 1; i < arr.size() ; i++)
        {
            if (Objects.equals(arr.get(i), arr.get(i - 1)))
            {
                dup = arr.get(i);
                cur = arr.get(i);

                while(i < arr.size() && cur == arr.get(i))
                {
                    cur++;
                    i++;
                }
            }
        }

        if (cur != -1)
            sum += (cur - dup);

        return sum;
    }

    public static void main(String[] args)
    {
        List<Integer> ar = Arrays.asList(2, 2, 4, 5);
        System.out.println(getMinimumUniqueSum(ar));
    }

}
