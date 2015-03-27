public class Problem087
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		
		int cap = (int)(5*Math.pow(10, 7));

		int[] primes = ESieve.generatePrimes(7100); //909, 73, 23
		boolean[] numbers = new boolean[cap];
		
		for ( int i = 0; i < primes.length; i++ )
			for ( int j = 0; j < 75; j++ )
				for ( int k = 0; k < 25; k++ )
				{
					int nm = primes[i] * primes[i] + (int)Math.pow(primes[j], 3)
							+ (int)Math.pow(primes[k], 4);
					if ( nm < cap )
						numbers[nm] = true;
				}
		
		int ct = 0; 
		for ( int m = 0; m < numbers.length; m++ )
			if ( numbers[m] )
				ct++;
		System.out.println(ct);
		
		
		
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
