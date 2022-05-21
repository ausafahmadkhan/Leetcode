package recursion;

import java.util.ArrayList;
import java.util.List;

public class AllCombinations
{
    public static void displayAllSubsets(String str)
    {
        displayRecursively("", str);
    }

    private static void displayRecursively(String processed, String unprocessed)
    {
        if (unprocessed.isEmpty())
        {
            System.out.print(processed + "\t");
            return;
        }

        char ch = unprocessed.charAt(0);
        displayRecursively(processed, unprocessed.substring(1));
        displayRecursively(processed + ch, unprocessed.substring(1));
    }



    public static void collectAllSubsets(String str)
    {
        List<String> subsets = new ArrayList<>();
        collectAllSubsetsRecursively("", str, subsets);
        System.out.println(subsets);
    }

    public static List<String> returnAllSubsets(String str)
    {
        return returnAllSubsetsRecursively("", str);
    }

    //List in argument
    private static void collectAllSubsetsRecursively(String p, String up, List<String> subsets)
    {

        if (up.isEmpty())
        {
            subsets.add(p);
            return;
        }

        char ch = up.charAt(0);

        collectAllSubsetsRecursively(p, up.substring(1), subsets);
        collectAllSubsetsRecursively(p + ch, up.substring(1), subsets);
    }

    //local list
    private static List<String> returnAllSubsetsRecursively(String p, String up)
    {
        if (up.isEmpty())
        {
            List<String> subset = new ArrayList<>();
            subset.add(p);
            return subset;
        }

        char ch = up.charAt(0);

        List<String> left = returnAllSubsetsRecursively(p, up.substring(1));
        List<String> right = returnAllSubsetsRecursively(p + ch, up.substring(1));
        left.addAll(right);
        return left;
    }

    public static void combinationsPlusAscii(String str)
    {
        combinationsPlusAsciiRecursively("", str);
    }

    public static void combinationsPlusAsciiRecursively(String p, String up)
    {
        if (up.isEmpty()) {
            System.out.print(p + "\t");
            return;
        }

        char ch = up.charAt(0);
        combinationsPlusAsciiRecursively(p, up.substring(1));
        combinationsPlusAsciiRecursively(p + ch, up.substring(1));
        combinationsPlusAsciiRecursively(p + (ch - 0), up.substring(1));
    }

    public static void main(String[] args)
    {
        displayAllSubsets("abc");
        System.out.println();
        collectAllSubsets("abc");
        System.out.println(returnAllSubsets("abc"));
        combinationsPlusAscii("abc");
    }
}
