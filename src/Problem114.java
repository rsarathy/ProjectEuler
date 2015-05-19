public class Problem114
{
	static int corrFactor(int n)
	{
		int m = n % 6;
		if ( m == 1 || m == 2 ) return -1;
		if ( m == 0 || m == 3 ) return 0;
		if ( m == 4 || m == 5 ) return 1;
		
		return -2; //unreachable, error catching
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
				
		long[] blocks = new long[51];
		blocks[0] = 0;
		blocks[1] = 1;
		blocks[2] = 1;
		blocks[3] = 2;
		blocks[4] = 4;
		blocks[5] = 7;
		blocks[6] = 11;
		blocks[7] = 17;
		
		for ( int n = 8; n <= 50; n++ )
		{			
			blocks[n] = blocks[n-1] + blocks[n-2] + corrFactor(n);
			System.out.println("Number of solutions to a row of length " + n + ": " + blocks[n]);
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 
	}
}
