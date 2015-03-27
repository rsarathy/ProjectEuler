public class Problem010
{

	/**
	 * Compute the sum of all primes < 2,000,000.
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		
		long sum = 0;
		int[] primes = ESieve.generatePrimes(2000000);
		
		for ( int i = 0; i < primes.length; i++ )
			sum += primes[i];
				
		System.out.println(sum);
		
		long endTime = System.currentTimeMillis();
		 
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 
		
//		System.out.println(isPrime(17));
//		System.out.println(isPrime(16));
	}

}
