public class Problem072
{
	public static int totient(int n) //this is the number you want to find the totient of
	{
		int orig = n;
		int totient = n; //this will be the totient at the end of the sample
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
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		long sum = 0L;
		
		for ( int n = 2; n <= (int)(Math.pow(10, 6)); n++ )
			sum += totient(n);
		
		System.out.println(sum);

		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
