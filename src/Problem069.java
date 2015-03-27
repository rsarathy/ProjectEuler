public class Problem069
{
//	public static void swap ( int i, int j )
//	{
//		int temp = i;
//		j = temp;
//		i = j;
//	}
//	
//	public static int GCF ( int a, int b )
//	{
//		if ( b > a )
//			swap(a, b);
//		
//		while ( b != 0 )
//		{
//			int m = a % b;
//			a = b;
//			b = m;
//		}
//		
//		return a;
//	}
//	
//	public static boolean coprime(int a, int b)
//	{
//		return GCF(a,b) == 1;
//	}
	
//	public static double totient(int n)
//	{
//		double totCt = 0D;
//		for ( int p = 1; p < n; p++ )
//			if ( coprime(n,p) )
//				totCt++;
//		return n / totCt;
//	}
	
	public static double totient(int n) //this is the number you want to find the totient of
	{
		int orig = n;
		double totient = n; //this will be the totient at the end of the sample
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
		return orig / totient;
	}


	/**
	 * Find the maximum totient ratio for n ≤ 1,000,000.
	 */
	public static void main(String[] args)
	{
		
		long startTime = System.currentTimeMillis();
		
		double maxTotient = 0D;
		int maxn = 0;
		
		for ( int m = 2; m <= 1000000; m++ )
			if ( totient(m) > maxTotient )
			{
				maxTotient = totient(m);
				maxn = m;
			}
		
		System.out.println("n = " + maxn + " produces the largest ratio of " + maxTotient);
		
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 
		
		

	}

}
