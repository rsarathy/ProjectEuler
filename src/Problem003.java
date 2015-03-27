
public class Problem003
{
	public static final long FACTOR = 600851475143L;

	/**
	 * Largest prime factor of 600,851,475,143 (ans: 6857)
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		int maxFactor = 2;
		int upperBound = (int)(Math.sqrt(FACTOR)) + 1; //775147
		int[] primes = ESieve.generatePrimes(upperBound);
		for ( int i = 0; i < primes.length; i++ )
			if ( FACTOR % primes[i] ==  0 )
				maxFactor = primes[i];
		
		System.out.println(maxFactor);
		
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 
		
	}

}
