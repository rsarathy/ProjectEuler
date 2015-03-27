
public class Problem078
{
	public static final int MILLION = (int)(Math.pow(10, 6));
//	public static long partitions(int N)
//    {
//    	long table[][] = new long[N+1][N+1];
//    	
//        for(int i = 1; i <= N; i++)
//            table[i][1] = 1;
//        
//        for( int i = 1; i <= N; i++ )
//            for( int j = 2; j <= N; j++ )
//            {
//                if(i < j)
//                    table[i][j] = (table[i][j-1] % MILLION);
//                else if(i == j)
//                    table[i][j] = ((table[i][j-1] + 1) % MILLION);
//                else
//                    table[i][j] = ((table[i-j][j] + table[i][j-1]) % MILLION);
//            }
//        
//        return table[N][N-1] + 1;
//    }
	
	public static int partitions(int N)
	{
		int tgt = N;
		int[] piles = new int[tgt+1];
		piles[0] = 1;
		
		for ( int i = 1; i <= tgt-1; i++ )
			for ( int j = i; j <= tgt; j++ )
			{
				piles[j] += (piles[j-i] % MILLION);
				piles[j] %= MILLION;
			}
		return (piles[N] + 1) % MILLION;
	}
	
	/**
	 * 5041 -398905
5042 -314241
5043 -609523
5044 -926362
5045 -112057
5046 -838813
5047 -912295
5048 -295597
5049 -591572
5050 -863127
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		for ( int i = 55370; i <= 55380; i++ ) //low bound 20,010	
			if ( partitions(i) == 0 )
			{
				System.out.println(i);
				break;
			}

		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}
}
