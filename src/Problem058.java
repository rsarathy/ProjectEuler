public class Problem058
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		
		// 1. 4n^2 + 1
		// 2. 4n^2 - 6n + 3
		// 3. (2n + 1)^2
		// 4. 4n^2 - 10n + 7
		double pct = 8.0/13;
		double primeCt = 0;
		int side = 1;
		int diag = 2*side-1;
		int n = 1;
		while ( pct >= 0.1  )
		{
			side += 2;
			diag = 2*side-1;
			for ( int i = 0, j = side - 1; i < 4; i++ )
			{
				n += j;
				if ( Numbers.isPrime(n) )
					primeCt++;
			}	
			pct = primeCt/diag;
		}
		
		System.out.println(primeCt+"/"+(2*side-1));
		System.out.println(side);
		
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 
	}

}
