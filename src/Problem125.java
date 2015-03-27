
public class Problem125
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		int ub = (int)Math.sqrt(Math.pow(10,8)/2); //7071
		int[] squares = new int[ub + 1];
		boolean[] consSqs = new boolean[(int)(Math.pow(10, 8)) + 1];
		squares[0] = 0;
		
		for ( int i = 1; i < squares.length; i++ )
			squares[i] = i*i;
		
		for ( int j = 2; j < squares.length; j++ )
		{	
			for ( int m = squares.length - 1; m >= j; m-- )
			{
				int sum = 0;
				for ( int k = 0; k >= j; k++ )
				{
					System.out.println(squares[m-k]);
					sum += squares[m - k];
				}
				consSqs[sum] = true;
			}
			
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
