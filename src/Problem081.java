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
				matrix[m][n] += Math.min(matrix[m-1][n], matrix[m][n-1]);
		
		return matrix[row-1][col-1];
	}

	/**
	 * Calculate the minimum path sum. 
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		TextIO.readFile("p081_matrix.txt");

		int[][] matrix = new int[80][80];
		
		for ( int i = 0; i < 80; i++ )
		{
			String[] row = TextIO.getln().split(",");
			for ( int j = 0; j < 80; j++ )
				matrix[i][j] = Integer.parseInt(row[j]);
		}
		
		System.out.println(minSum(matrix));

		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
