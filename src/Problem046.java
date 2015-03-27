public class Problem046
{
	public static int[] squares (int n)
	{
		int[] sq = new int[n];
		
		for ( int i = 0; i < n; i++ )
			sq[i] = i * i;
		
		return sq;
	}
	
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
	 * Find the smallest odd composite that disproves Goldbach's conjecture.
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		int[] primes = ESieve.generatePrimes(1000000);
		int[] sq = squares(10000);
		boolean[] conjecture = new boolean[20000000];
		
		for ( int i = 0; i < primes.length; i++ )
			for ( int j = 1; j < sq.length; j++ )
				if ( primes[i] + 2 * sq[j] < conjecture.length )
					conjecture[ primes[i] + 2 * sq[j] ] = true;
	
		for ( int k = 1; k < conjecture.length; k += 2 )
			if ( !conjecture[k] && !isPrime(k) && k > 9 )
			{
				System.out.println(k);
				break;
			}
		
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 
	}

}
