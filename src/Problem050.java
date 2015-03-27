public class Problem050
{
	public static boolean isPrime(int n) 
	{
        if (n <= 1) return false;
        if (n == 2) return true;
        for (int i = 2; i <= Math.sqrt(n) + 1; i++)
            if (n % i == 0)
                return false;
        return true;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		
		int million = (int)Math.pow(10, 6);
//		int terms = 137; 
		//132: 44683
		int maxTerms = 137;
		int p = 0;
		
		int[] primes = ESieve.generatePrimes(million);
		int[][] consSum = new int[primes.length][2];
		
		for (int i = 0; i < primes.length; i++ )
			consSum[i][0] = primes[i];
		
		for ( int terms = 0; terms < 600; terms++ )
		{
			for ( int i = 0; primes[i] < 10000; i++ )
			{
				int sum = 0;
				for ( int j = 0; j < terms; j++ )
					sum += primes[i+j];
				
				if ( terms > maxTerms && isPrime(sum) && sum < million)
				{	
					maxTerms = terms;
					p = sum;
				}
			}
		}
		
		System.out.println(p + " " + maxTerms); //997651 543
		
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime)
				+ " ms to compile.");

	}

}
