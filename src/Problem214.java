
public class Problem214
{
	public static long totient(long n) //this is the number you want to find the totient of
	{
		long totient = n; //this will be the totient at the end of the sample
		for (int div = 2; div*div <= n; div++)
		{
		    if (n % div == 0 )
		    {
		        totient /= div;
		        totient *= (div-1);
		        while ( n % div == 0 ) 
		            n /= div;
		    }
		}
		if ( n > 1 )
		{ // now n is the largest prime divisor
		    totient /= n;
		    totient *= (n-1);
		}
		return totient;
	}
	
	public static int totientChain(long n, int acc)
	{
		if (acc == 0) return totientChain(n-1,acc+1);
		if (n == 1) return 1 + acc;
		if (n == 2) return 2 + acc;
		if (n == 4 || n == 6) return 3 + acc;
		long euler = totient(n);
		return totientChain(euler,acc+1);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		
		int[] primes = ESieve.generatePrimes(40000000); //2433654

		long sum = 0;
		for ( int i = 1; i < primes.length; i++ )
		{
			int t = totientChain(primes[i],0);
			if ( t == 25 )
				sum += primes[i];
			if ( i % 243000 == 0 )
				System.out.println(i/243000 + "0% complete.");
		}
		System.out.println("totient chain 25: " + sum); //51147 numbers w/chain
		
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
