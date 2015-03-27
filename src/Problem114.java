public class Problem114
{
	static int nthTri(int n)
	{
		return (n*n+n)/2;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		
		int[] blocks = new int[51];
		blocks[0] = 0;
		blocks[1] = 0;
		blocks[2] = 0;
		blocks[3] = 2;
		blocks[4] = 4;
		blocks[5] = 7;
		blocks[6] = 11;
		blocks[7] = 17;
		
		for ( int n = 7; n <= 50; n++ )
		{
			int sumR_i = 0;
			for ( int i = 3; i <= n-4; i++ )
				sumR_i += blocks[i];
			blocks[n] = nthTri(n-2) + sumR_i - n + 7;
			
			System.out.println("Number of ways to combine " + n + ": " + blocks[n]);
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
