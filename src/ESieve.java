public class ESieve
{
	public static int[] generatePrimes(int max)
	{
		boolean[] isComposite = new boolean[max + 1];
		
		for (int i = 2; i * i <= max; i++)
			if (!isComposite[i])
				for (int j = i; i * j <= max; j++)
					isComposite[i * j] = true;

		int numPrimes = 0;
		
		for (int i = 2; i <= max; i++)
			if (!isComposite[i])
				numPrimes++;
		
		int[] primes = new int[numPrimes];
		int index = 0;
		
		for (int i = 2; i <= max; i++)
			if (!isComposite[i])
				primes[index++] = i;
		
		return primes;
	}
}
