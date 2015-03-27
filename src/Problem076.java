public class Problem076
{
	
//	public static int partitions(int n)
//	{
//		if (n == 0) return 1;
//		
//		int s = 0, j = n - 1, k = 2;
//		
//		while ( j >= 0 )
//		{
//			int t = partitions(j);
//			if ( (k/2) % 2 == 1 )
//				s += t;
//			else
//				s -= t;
//			
//			if ( k % 2 == 1 )
//				j -= k;
//			else
//				j -= k / 2;
//			k++;
//		}
//		
//		return s;
//	}	
    
    public static long partitions(int N)
    {
    	long table[][] = new long[N+1][N+1];
    	
        for(int i = 1; i <= N; i++)
            table[i][1] = 1;
        
        for( int i = 1; i <= N; i++ )
            for( int j = 2; j <= N; j++ )
            {
                if(i < j)
                    table[i][j] = table[i][j-1];
                else if(i == j)
                    table[i][j] = table[i][j-1] + 1;
                else
                    table[i][j] = table[i-j][j] + table[i][j-1];
            }
        
        return table[N][N-1] + 1;
    }
	
	// p(n) = ∑(-1)^(k-1) * p(n-k(3k±1)/2

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

//		for ( int n = 5; n < 1000; n++ )
//			if ( partitions(n) % 1000000 == 0 )
//			{
//				System.out.println(n);
//				break;
//			}
		System.out.println(partitions(100) - 1);
		
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime)
				+ " ms to compile.");

	}

}
