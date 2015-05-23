

public class Problem115
{
	// n = 8
	// m = 3
	static long F(int m, int n, long[] sols)
	{
		long solutions = 1;
		if ( m > n ) return solutions;
		if ( sols[n] != 0 ) return sols[n];
		
		for ( int s = 0; s <= n-m; s++ )
			for ( int b = m; b <= n-s; b++ )
				solutions += F(m, n-s-b-1, sols);
		
		sols[n] = solutions;
		return solutions;
	}
	
	/**
	 * F(m,n) = F(m,n-(m+1)) + 2F(m,n-1) - F(m,n-2)
	 * m = 50 --> F(n) = F(n-51) + 2F(n-1) - F(n-2)
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		
		long[] S_3 = new long[60];
		long[] S_10 = new long[80];
		long[] S_50 = new long[200];
		
		System.out.println("F(3,30) = " + F(3,30,S_3));	
		System.out.println("F(10,57) = " + F(10,57,S_10));
		System.out.println("F(50,168) = " + F(50,168,S_50));
		
		long[] F_50 = new long[200];
		for ( int i = 0; i < 49; i++ )
			F_50[i] = 1;
		F_50[50] = 2;
		F_50[51] = 4;
		for ( int n = 52; n < 200; n++ )
		{
			F_50[n] = F_50[n-51] + 2*F_50[n-1] - F_50[n-2];
			if ( F_50[n] > 1000000 )
			{
				System.out.println("F(50," + n + ") = " + F_50[n]);
				break;
			}
		}

		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 
	}
}
