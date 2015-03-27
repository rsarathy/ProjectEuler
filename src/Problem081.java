public class Problem081
{
	public static int minSum(int[][] matrix)
	{
		int row = matrix.length;
		int col = matrix[0].length;
		
		for ( int i = 1; i < col; i++ )
			matrix[0][i] += matrix[0][i-1];
		
		for ( int j = 1; j < row; j++ )
			matrix[j][0] += matrix[j-1][0];
			
		for ( int m = 1; m < row; m++ )
			for ( int n = 1; n < col; n++ )
				matrix[m][n] += ((matrix[m-1][n] < matrix[m][n-1])
						? matrix[m-1][n] : matrix[m][n-1]);
		
		return matrix[row-1][col-1];
	}

	/**
	 * Calculate the minimum path sum. 
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		TextIO.readFile("p081_matrix.txt");
		
		final int eighty = 80;
		
		String[][] square = new String[eighty][eighty];
		int[][] matrix = new int[eighty][eighty];
		
		for ( int i = 0; i < square.length; i++ )
		{
			String line = TextIO.getln();
			square[i] = line.split(",");
		}
		
		for ( int i = 0; i < square.length; i++ )
			for ( int j = 0; j < square[i].length; j++ )
				matrix[i][j] = Integer.parseInt(square[i][j]);
		
		System.out.println(minSum(matrix));
//		
//		TextIO.readFile("matrix.txt");
//		
//		String[][] sq = new String[5][5];
//		int[][] mat = new int[5][5];
//		
//		for ( int i = 0; i < sq.length; i++ )
//		{
//			String line = TextIO.getln();
//			sq[i] = line.split(" ");
//		}
//		
//		for ( int i = 0; i < sq.length; i++ )
//			for ( int j = 0; j < sq[i].length; j++ )
//				mat[i][j] = Integer.parseInt(sq[i][j]);
//		
//		System.out.println(minSum(mat));

		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
