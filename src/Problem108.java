public class Problem108
{
	static int big = (int)Math.pow(10, 8);
	static int[] primes = ESieve.generatePrimes(10000);
	
	static int tau(long n)
	{
		int divs = 1;
		int p = 0;
		while ( n > 1 )
		{
			int factors = 0;
			while ( n % primes[p] == 0 )
			{
				n /= primes[p];
				++factors;
			}
			divs *= (factors + 1);
			p++;
		}
		return divs;
	}
	
	static int diophantine(int n)
	{
		int ct = 0;
		for ( long x = n + 1; x <= 2*n; x++ )
		{
			long nume = n*x;
			long denom = x - n;
			if ( nume % (denom) == 0 )
				ct++;
		}
		return ct;
	}
	
	static int fastDiop(long n)
	{
		long sq = n*n;
		return (tau(sq) + 1) / 2;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
//
		int max = 0, maxN = 0;
		
		for ( int i = 210; i < 277200; i += 210 )
		{
			int sols = fastDiop(i);
			if ( sols > 1000 )
			{
				maxN = i;
				max = sols;
				break;
			}
		}	
		
		System.out.println("n = " + maxN + " --> " + max + " solutions");

		/**
		 n = 9240 --> 284 solutions
		 n = 18480 --> 365 solutions
		 n = 27720 --> 473 solutions
		n = 32760 --> 473 solutions
		n = 83160 --> 662 solutions
		n = 110880 --> 743 solutions
		n = 120120 --> 851 solutions
		-------200,000---------- upper bound
		n = 221760 --> 878 solutions
		n = 235620 --> 1013 solutions
		n = 277200 --> 1013 solutions
		 */

		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
