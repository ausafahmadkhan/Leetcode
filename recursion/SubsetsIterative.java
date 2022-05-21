package recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubsetsIterative
{
    public static void subsets(String str)
    {
        ArrayList<ArrayList<Character>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (int i = 0; i < str.length(); i++)
        {
            ArrayList<ArrayList<Character>> internal;
            internal = deepCopy(result);
            for(List<Character> chars : internal)
            {
                chars.add(str.charAt(i));
            }
            result.addAll(internal);
        }

        Set<Set<Character>> subsets = new HashSet<>();
        for(ArrayList<Character> list : result)
        {
            subsets.add(new HashSet<>(list));
        }

        System.out.println(subsets);
    }

    static <T> ArrayList<ArrayList<T>> deepCopy(ArrayList<ArrayList<T>> src)
    {
        ArrayList<ArrayList<T>> dest = new ArrayList<>();
        for (int i = 0; i < src.size(); i++)
        {
            dest.add(new ArrayList<>());
            for(T elem : src.get(i))
            {
                dest.get(i).add(elem);
            }
        }
        return dest;
    }

    public static void main(String[] args)
    {
        subsets("abbc");
    }
}
