public class Problem027
{
	int a;
	int b;

	public Problem027(int myA, int myB)
	{
		this.a = myA;
		this.b = myB;
	}

	public int efEx(int n)
	{
		return n * n + this.a * n + this.b;
	}

	public int numPrimes()
	{
		int x = 0;
		while (isPrime(efEx(x)))
			x++;
		return x;
	}

	public static boolean isPrime(int n)
	{
		if (n <= 1)
			return false;
		if (n == 2)
			return true;
		for (int i = 2; i <= Math.sqrt(n) + 1; i++)
			if (n % i == 0)
				return false;
		return true;
	}

	/**
	 * Find the best prime-generating function n^2 + an + b for the bounds
	 * |a|,|b| < 1000.
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		// Problem027 euler = new Problem027(1, 41);
		// Problem027 web = new Problem027(-79, 1601);
		// System.out.println(euler.numPrimes());
		// System.out.println(web.numPrimes());

		int maxPrimes = 0, maxA = 0, maxB = 0;

		for (int a = -999; a <= 999; a++)
			for (int b = -999; b <= 999; b++)
			{
				Problem027 primeGen = new Problem027(a, b);
				if (primeGen.numPrimes() > maxPrimes)
				{
					maxPrimes = primeGen.numPrimes();
					maxA = primeGen.a;
					maxB = primeGen.b;
				}

			}

		System.out.println("Maximum number of primes generated: " + maxPrimes);
		System.out.println("a = " + maxA + ", b = " + maxB);

		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime)
				+ " ms to compile.");

	}

}
