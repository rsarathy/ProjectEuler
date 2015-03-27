public class Problem243
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
	
	public static double frac(long n)
	{
		return (double)totient(n) / (n-1);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		
		final double BOUND = 15499.0/94744.0;
		final long HI = 6469693230L; //upper bound
		
//		for ( long i = HI - 1; i > HI - 1000; i-- )
//		{
//			double fr = frac(i);
//			if ( fr < BOUND )
//			{
//				System.out.println(i + ": " + totient(i) + "/" + (i-1) + " = " + fr);
//				break;
//			}
//		}

		long n = HI/29;
		System.out.println(BOUND);
		
		for ( int i = 2; i < 29; i++ )
		{
			long N = n * i;
			double fract = frac(N);
			boolean resilient = (fract < BOUND);
			if ( resilient )
			{
				System.out.println(totient(N) + "/" + (N-1) + " = " + frac(N));
				System.out.println("d = " + N);
				break;
			}
		}
		
		
		System.out.println(totient(n) + "/" + (n-1) + " = " + frac(n));
		double fr = frac(n);
		boolean resilient = (fr < BOUND);
		System.out.println(resilient);
		
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
