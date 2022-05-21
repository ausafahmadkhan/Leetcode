package random;

public class Reach
{
    public static String isPossible(int a, int b, int c, int d) {
        // Write your code here

        return checkIfPossibleRecursively(a, b, c, d) ? "Yes" : "No";
    }

    private static boolean checkIfPossibleRecursively(int a, int b, int c, int d)
    {
        if (a == c && b == d)
            return true;

        if (a > c || b > d)
            return false;

        return checkIfPossibleRecursively(a + b, b, c, d) || checkIfPossibleRecursively(a, b + a, c, d);
    }
}
