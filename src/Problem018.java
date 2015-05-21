public class Problem018
{
	// slow recursive solution
	public static int maxSum(int[][] tr, int i, int j)
	{	
		if ( i < 0 || j < 0 ) return 0;
		if ( i >= tr.length || j >= tr.length ) return 0;
		if ( j == tr.length - 1 ) return tr[i][j];
		
		return tr[i][j] + Math.max(maxSum(tr,i+1,j), maxSum (tr,i+1,j+1));
	}
	
	/**
	 * O(n^2) dynamic programming solution.
	 * 
	 * @param tr - given triangle of values.
	 * @return maximum possible path sum
	 */
	static int max(int[][] tr)
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
	 * Compute the largest path sum.
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		TextIO.readFile("p018_triangle.txt");
		
		int[][] triangle = new int[15][15];
		
		for ( int i = 0; i < 15; i++ )
		{
			String[] row = TextIO.getln().split(" ");
			for ( int j = 0; j < row.length; j++ )
				triangle[i][j] = Integer.parseInt(row[j]);
		}
		
		System.out.println("maxSum = " + maxSum(triangle,0,0));	
		System.out.println("maxSum = " + max(triangle));

		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
