package recursion;

import java.util.ArrayList;
import java.util.List;

//6 face dice
public class DiceThrow
{
    public static void getCombinations(int num, int face)
    {
        List<String> combs = getCombinationsRecursively("", num, face);
        System.out.println(combs);
    }

    private static List<String> getCombinationsRecursively(String p, int up, int face)
    {
        List<String> combs = new ArrayList<String>();
        if (up == 0)
        {
            combs.add(p);
            return combs;
        }


        for (int i = 1; i <= face && i <= up; i++)
        {
            combs.addAll(getCombinationsRecursively(p + i, up - i, face));
        }

        return combs;
    }

    public static void main(String[] args)
    {
        getCombinations(3, 6);
    }
}
