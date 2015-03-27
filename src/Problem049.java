import java.util.Arrays;

public class Problem049
{
	static boolean isPermutation(String str1, String str2)
	{
		  if (str1.length() != str2.length())
		      return false;

		    char[] a = str1.toCharArray();
		    char[] b = str2.toCharArray();

		    Arrays.sort(a);
		    Arrays.sort(b);

		    return Arrays.equals(a, b);
	}

	public static boolean isPrime(int n)
	{
		if (n <= 1) return false;
		if (n == 2) return true;
		for (int i = 2; i <= Math.sqrt(n) + 1; i++)
			if (n % i == 0)
				return false;
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		int[] primes = ESieve.generatePrimes(10000); // 1229 primes
		// 1061 greater than 1,000.

		for (int i = 168; i < primes.length; i++)
			for (int j = 2; j < 4500; j++)
			{
				int p = primes[i] + j;
				int q = primes[i] + 2 * j;
				if (isPrime(p) && isPrime(q) && p < 10000 && q < 10000
						&& isPermutation(primes[i]+"",p+"") && isPermutation(primes[i]+"",q+""))
					System.out.println(primes[i] + " " + p + " " + q);
			}

		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime)
				+ " ms to compile.");

	}

}
