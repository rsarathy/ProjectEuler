
public class Problem123
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		int[] primes = ESieve.generatePrimes(1000);
		
		long maxMod = 0;
		long maxN = 0;
		
		for ( int i = 0; i < primes.length; i++ )
		{
			long a = primes[i] - 1;
			long b = primes[i] + 1;
			long m = primes[i] * primes[i];
			
			long mod = (long)(Math.pow(a,i+1) + Math.pow(b, i+1)) % m;
			
			if ( mod > maxMod )
			{
				maxN = i + 1;
				maxMod = mod;
			}
		}
		
		System.out.println("p_n = " + primes[(int)maxN-1] + ", " 
		+ "n = " + maxN + ", remainder = " + maxMod);
		
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
