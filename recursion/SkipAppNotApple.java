package recursion;

public class SkipAppNotApple
{
    public static void skipAppNotApple(String str)
    {
        String skippedString = skipRecursively(str, "");
        System.out.println(skippedString);
    }

    private static String skipRecursively(String str, String result)
    {
        if (str.isEmpty())
            return result;

        if (str.startsWith("app") && !str.startsWith("apple"))
            return skipRecursively(str.substring(3), result);
        else
            return skipRecursively(str.substring(1), result + str.charAt(0));
    }

    public static void main(String[] args)
    {
        skipAppNotApple("thisisappthisisappleasdfappqwerty");
    }
}
