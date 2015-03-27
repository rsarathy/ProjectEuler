public class Problem037
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
	
	public static boolean RLTruncatable(int p)
	{
		if ( p < 10 ) return false;
		
		while ( p > 0 )
		{
			if ( !isPrime(p) )
				return false;
			p /= 10;
		}
		return true;
	}
	
	public static boolean LRTruncatable(int p)
	{
		if ( p < 10 ) return false;
		
		while ( p > 10 )
		{
			String s = String.valueOf(p).substring(1);
			p = Integer.parseInt(s);
			if ( !isPrime(p) )
				return false;
		}
		
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		int[] primes = ESieve.generatePrimes(1000000);
		
		System.out.println(LRTruncatable(3797));
		System.out.println(RLTruncatable(3797));
		
		int ct = 0, sum = 0;
		
		for ( int i = 0; i < primes.length; i++ )
			if ( LRTruncatable(primes[i]) && RLTruncatable(primes[i]) )
			{
				System.out.println(primes[i]);
				ct++;
				sum += primes[i];
			}
		
		System.out.println("Number of doubly truncatable primes: " + ct);
		System.out.println("Sum of all doubly truncatable primes: " + sum);
		
		//23, 29, 37, 53, 59, 73, 313, 317, 373, 379, 719, 797, 3797

		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
