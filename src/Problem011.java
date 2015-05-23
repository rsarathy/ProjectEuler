
public class Problem011
{
	public static final int GRID_LENGTH = 20;
	public static final int PROD_LENGTH = 4;
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		
		TextIO.readFile("p011_grid.txt");
		int[][] grid = new int[GRID_LENGTH][GRID_LENGTH];
		for ( int i = 0; i < GRID_LENGTH; i++ )
		{
			String[] temp = TextIO.getln().split(" ");
			for ( int j = 0; j < temp.length; j++ )
				grid[i][j] = Integer.parseInt(temp[j]);
		}

		int maxProd = 0;
		
		for ( int i = 0; i < GRID_LENGTH - PROD_LENGTH + 1; i++ )
			for (int j = 0; j < GRID_LENGTH; j++ )
			{
				int vert = ( grid[i][j] * grid[i + 1][j] * grid[i + 2][j] * grid[i + 3][j] );
				if ( vert > maxProd ) maxProd = vert;
			}
		
		for ( int i = 0; i < GRID_LENGTH; i++ )
			for ( int j = 0; j < GRID_LENGTH - PROD_LENGTH + 1; j++ )
			{
				int hori = ( grid[i][j] * grid[i][j + 1] * grid[i][j + 2] * grid[i][j + 3] );
				if ( hori > maxProd ) maxProd = hori;
			}
		
		for ( int i = 0; i < GRID_LENGTH - PROD_LENGTH + 1; i++ )
			for ( int j = 0; j < GRID_LENGTH - PROD_LENGTH + 1; j++ )
			{
				int fdiag = ( grid[i][j] * grid[i + 1][j + 1] * grid[i + 2][j + 2] * grid[i + 3][j + 3] );
				if ( fdiag > maxProd ) maxProd = fdiag;
			}
		
		for ( int i = GRID_LENGTH - 1; i > PROD_LENGTH - 1; i-- )
			for ( int j = 0; j < GRID_LENGTH - PROD_LENGTH + 1; j++ )
			{
				int bdiag = ( grid[i][j] *  grid[i - 1][j + 1] * grid[i - 2][j + 2] * grid[i - 3][j + 3]);
				if ( bdiag > maxProd ) maxProd = bdiag;
			}
		
		System.out.println(maxProd);

		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 
	}

}
