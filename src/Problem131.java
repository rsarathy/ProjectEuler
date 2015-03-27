
public class Problem131
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		
		int[] primes = ESieve.generatePrimes(100);
		for ( int i = 0; i < primes.length; i++ )
			for ( int n = 2; n < 10000; n++ )
			{
				long special = n*n*n + n*n*primes[i];
				if ( Numbers.isCube(special) )
				{
					System.out.println(n+"^3 + " + n+"^2" + " * " + primes[i]);
					continue;
				}
			}
		
		System.out.println(Math.cbrt(549890031616L));

		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
