package maths;

//Newton Raphson method
//root = (x + N/x)/2

public class Root
{
    public static double sqrt(int n)
    {
        double guess = n;
        while(true)
        {
            double root = 0.5 * (guess + n / guess);

            if (Math.abs(root - guess) < 0.00005)
                return root;

            guess = root;
        }
    }

    public static void main(String[] args)
    {
        System.out.println(sqrt(32));
    }
}
