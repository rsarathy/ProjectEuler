public class Problem012
{
	public static int numberOfDivisors(int n)
	{
		int sqrt = (int)Math.sqrt(n);
		
		int div = 0;
		for ( int i = 1; i <= sqrt + 1; i++ )
			if ( n % i == 0 )
				div++;
		div *= 2;
		
		if ( sqrt * sqrt == n ) div--;
		return div;
	}
	
	/**
	 * Find the first triangular number to have over 500 divisors.
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		for ( int i = 1; i < 20000; i++ )
		{
			int tri = ( i * i + i ) / 2;
			int divs = numberOfDivisors(tri);
			if ( divs > 500 )
				System.out.println(tri);
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 
	}

}
