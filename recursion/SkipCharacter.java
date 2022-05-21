package recursion;

public class SkipCharacter
{
    static StringBuilder result = new StringBuilder();

    public static void skipCharacter(String str, char ch)
    {
        skipRecursively(str, ch);
        System.out.println(result);
    }

    private static void skipRecursively(String str, char ch)
    {
        if (str.isEmpty())
            return;

        if (str.charAt(0) != ch)
            result.append(str.charAt(0));
        skipRecursively(str.substring(1), ch);
    }

    public static void main(String[] args)
    {
        skipCharacter("qweraaaaaaaaatyasdfqwertyqwdrqta", 'a');
    }
}
