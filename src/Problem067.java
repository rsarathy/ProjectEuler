public class Problem067
{
	static int maxSum(int[][] tr)
	{
		for ( int i = 1; i < tr[0].length; i++ )
			tr[i][0] += tr[i-1][0];
		for ( int j = 1; j < tr.length; j++ )
			tr[j][j] += tr[j-1][j-1];
		for ( int m = 2; m < tr[0].length; m++ )
			for ( int n = 1; n < m; n++ )
				tr[m][n] += Math.max(tr[m-1][n], tr[m-1][n-1]);
		
		int maxPath = 0;
		for ( Integer elem : tr[tr.length-1] )
			if ( elem > maxPath )
				maxPath = elem;
		return maxPath;
	}
	
	/**
	 * Compute the maximum triangular sum.
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		
		TextIO.readFile("p067_triangle.txt");	
		//integers need to be parsed from the large triangle.	
		int[][] triangle = new int[100][100];
		for ( int i = 0; i < 100; i++ )
		{
			String[] row = TextIO.getln().split(" ");
			for ( int j = 0; j < row.length; j++ )
				triangle[i][j] = Integer.parseInt(row[j]);
		}
		
		System.out.println("Maximum path sum: " + maxSum(triangle));
		
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile.");

	}

}
