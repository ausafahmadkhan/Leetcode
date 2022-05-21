package recursion;

import java.util.ArrayList;
import java.util.List;


//"23"
//
//"abcdef"


public class PhonePad
{
    static String[] chars = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void getCombinations(String str)
    {
        List<String> comb = getCombinationsRecursively("", str);
        System.out.println(comb);
    }

    private static List<String> getCombinationsRecursively(String p, String up)
    {
        if (up.isEmpty())
        {
            List<String> comb = new ArrayList<>();
            comb.add(p);
            return comb;
        }

        int index = up.charAt(0) - '0';
        List<String> combs = new ArrayList<>();

        for (int i = 0; i < chars[index].length(); i++)
        {
            combs.addAll(getCombinationsRecursively(p + chars[index].charAt(i) , up.substring(1)));
        }
        return combs;
    }

    public static void main(String[] args)
    {
        getCombinations("236");
    }
}
