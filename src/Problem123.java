
public class Problem123
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		int[] primes = ESieve.generatePrimes(250000);
		
		long r_max = 0;
		int maxN = 0;
		for ( int i = 7036; i < primes.length; i += 2 )
		{
			long p = primes[i];
			long r = 2*(i+1)*p;
			if ( r > 10000000000L )
			{
				r_max = r;
				maxN = i + 1;
				break;
			}
		}
		
		System.out.println("p_n = " + primes[maxN-1] + ", " 
		+ "n = " + maxN + ", remainder = " + r_max);
		
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
