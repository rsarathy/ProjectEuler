
public class Problem187
{
	public static boolean isSemiprime(int n)
	{
		for ( int i = 2; i * i <= n; i++ )
		{
			if ( n % i == 0 )
			{
				int p = i;
				int q = n / i;
				if ( Numbers.isPrime(p) && Numbers.isPrime(q) )
					return true;
				return false;
			}
		}
		return false;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		int upperBound = (int)(Math.pow(10, 8));
		int[] primes = ESieve.generatePrimes(upperBound/2); //3001134 primes
		
		int ct = 0;
		
		/**
		 * brute force solution
//		for ( int i = 1; i < 100000000; i++ )
//		{
//			if ( isSemiprime(i) )
//				ct++;
//			if ( i%10000000==0 )
//				System.out.println(i/10000000 + "0% complete.");
//		}
//		System.out.println(ct);
*
 */
		
		int i = 0, j = primes.length - 1;
		while (true)
		{
			while (primes[i] * primes[j] >= upperBound)
				j--;
			if (j < i) break;
			ct += (j - i + 1);
			i++;
		}
		
		System.out.println("Number of semprimes not exceding " + upperBound + ": " + ct);
		
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
