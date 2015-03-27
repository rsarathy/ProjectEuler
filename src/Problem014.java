public class Problem014
{
	public static int collatzSteps(int acc, int n)
	{
		if (n == 1)
			return acc + 1;
		if (n % 2 == 0)
			return collatzSteps(acc + 1, n / 2);
		return collatzSteps(acc + 1, 3 * n + 1);
	}

	public static int steps(int n)
	{
		return collatzSteps(0, n);
	}

	/**
	 * Find an integer < 1,000,000 that produces the longest possible Collatz
	 * sequence.
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

			int maxSteps = 0, count = 1, output = 0;
			long i = 0;

			for (int n = 1; n < 1000000; n++)
			{
				i = n;
				count = 1;

				while (i > 1)
				{
					if (i % 2 == 0)
						i /= 2;
					else
						i = 3 * i + 1;
					count++;
				}

				if (count > maxSteps)
				{
					maxSteps = count;
					output = n;
				}
			}

			System.out.println(output + ": " + maxSteps);
		

		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime)
				+ " ms to compile.");

	}

}
