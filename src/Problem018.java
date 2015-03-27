public class Problem018
{
	public static int maxSum(int[][] tr, int i, int j)
	{
//		System.out.println("i = " + i + ", j = " + j);
		//[i][j] = (j, i)
		
		if ( i < 0 || j < 0 ) return 0;
		if ( i >= tr.length || j >= tr.length ) return 0;
		if ( j == tr.length - 1 ) return tr[i][j];
		
		return tr[i][j] + ( maxSum(tr,i+1,j) > maxSum (tr,i+1,j+1) ? 
			maxSum(tr,i+1,j) : maxSum(tr,i+1,j+1)  );
	}
	/**
	 * Compute the largest path sum.
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		TextIO.readFile("p018_triangle.txt");
		
		String[][] tri = new String[15][15];
		int[][] triangle = new int[15][15];
		
		for ( int i = 0; i < tri.length; i++ )
		{
			String line = TextIO.getln();
			tri[i] = line.split(" ");
		}
		
		for ( int i = 0; i < tri.length; i++ )
			for ( int j = 0; j <= i; j++ )
				triangle[i][j] = Integer.parseInt(tri[i][j]);
		
//		for ( int i = 0; i < tri.length; i++ )
//		{
//			for ( int j = 0; j < tri[i].length; j++ )
//			{
//				System.out.print(tri[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		System.out.println(triangle[1][0]);
		System.out.println(triangle[1][1]);
		System.out.println("maxSum = " + maxSum(triangle,0,0));

		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
