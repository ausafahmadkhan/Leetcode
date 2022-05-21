package maths;

// prime numbers upto n O(nlog(log n))
public class SeiveOfEratosthenes
{
    public static void getPrimes(int n)
    {
        boolean [] primes = new boolean[n + 1];

        for (int i = 2; i <= Math.sqrt(primes.length); i++)
        {
            if (!primes[i])
            {
                for (int j = 2 * i ; j <= n ; j += i)
                {
                    primes[j] = true;
                }
            }
        }

        for (int i = 2; i < primes.length; i++)
        {
            if (!primes[i])
                System.out.print("\t" +  i);
        }
    }

    public static void main(String[] args)
    {
        getPrimes(23);
    }
}
