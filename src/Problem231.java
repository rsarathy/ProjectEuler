import java.util.Arrays;

public class Problem231
{
	static int pDivSum(int n, int[] primes)
	{
		if ( n == 1 || n == 0 ) return 0;
		return pDivSum(n, primes, 0);
	}
	
	static int pDivSum(int n, int[] primes, int p)
	{
		if ( Arrays.binarySearch(primes, n) >= 0 )
			return n;
		if ( n % primes[p] == 0 )
		{
			n /= primes[p];
			return primes[p] + pDivSum(n, primes, p);
		}
		return pDivSum(n, primes, p + 1);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
	
		int twMillion = 2 * (int)(Math.pow(10, 7));
		int lb = (int)(1.5 * Math.pow(10, 7)) + 1;
		int[] pr = ESieve.generatePrimes(twMillion);		
		System.out.println("Done sieving primes under 20,000,000.");
		
		
		/**
		 * Sum of prime factorization of nCr = f(n!) - f((n-r)!) - f(r!)
		 */
		
		long bCoefpSum = 0, corrFactor = 0;	
		for ( int i = lb; i <= twMillion; i++ )
		{
			int chk = twMillion - i + 1;
			bCoefpSum += pDivSum(i, pr);
			corrFactor += pDivSum(chk, pr);		
		}
		
		bCoefpSum -= corrFactor;
		
		System.out.println("Sum of terms in the binomial coefficient's prime " +
				"factorization: " + bCoefpSum);

		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
