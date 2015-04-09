public class Problem131
{
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		
		int pCt = 0, i = 1, checksum = 0;
		while ( checksum < 1000000 )
		{	
			checksum = 3*i*i + 3*i + 1;
			if ( checksum > 0 && Numbers.isPrime(checksum) )
			{
				long iCubed = i*i*i; 
				System.out.println( i + "^3 + " + i + "^2 * " + checksum + 
						" = " + i + "^2(" + iCubed + "+" + checksum + ") = "
						+ i*i + "^3 * " + (i+1) + "^3");
				pCt++;
			}
			i++;
		}
		
		System.out.println("Number of primes with special property ≤ 1,000,000: " + pCt);

		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
