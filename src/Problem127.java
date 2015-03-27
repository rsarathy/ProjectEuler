public class Problem127
{
	final static int MAX = 120000;
	static int[] primes = ESieve.generatePrimes(MAX);
	
	static int rad(int n)
	{
		if ( n == 1 ) return 1;
		if ( Numbers.isPrime(n) ) return n;
		
		int product = 1;
		for ( int i = 0; i < primes.length && primes[i] < n; i++ )
			if ( n % primes[i] == 0 )
				product *= primes[i];
		return product;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		int hits = 0, csum = 0;
		
		for ( int c = 3; c < 1000; c++ )
		{
			int s = c/2 + 1;
			for ( int b = s; b < c; b++ )
			{
				int a = c - b;
				boolean allCoprime = Numbers.coprime(a, b) && Numbers.coprime(b, c)
						&& Numbers.coprime(a, c);
				int radABC = rad(a*b*c);
				if ( radABC < c && allCoprime )
				{
					hits++;
					csum += c;
				}
				
			}
		}
		
		System.out.println(hits + " " + csum);
		
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
