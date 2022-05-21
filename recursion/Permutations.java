package recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutations
{

//    abc
//
//    a/bc
//
//    ba/c ab/c
//
//    cba bca bac cab acb abc

    public static void displayPermutations(String str)
    {
        List<String> permutations = displayPermutationsRecursively("", str);
        System.out.println(permutations);
    }

    private static List<String> displayPermutationsRecursively(String p, String up)
    {
        if (up.isEmpty()) {
            List<String> perm = new ArrayList<>();
            perm.add(p);
            System.out.print(p + "\t");
            return perm;
        }

        List<String> perms = new ArrayList<>();

        for (int i = 0; i < p.length() + 1 ; i++)
        {
            String f = p.substring(0, i);
            String l = p.substring(i);
            char ch = up.charAt(0);
            perms.addAll(displayPermutationsRecursively(f + ch + l, up.substring(1)));
        }

        return perms;
    }

    public static void main(String[] args)
    {
        displayPermutations("ade");
    }
}
