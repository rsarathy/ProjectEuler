
public class Problem044
{
	public static boolean isInt(double d)
	{
	    return d == (int) d;
	}
	
	public static boolean pentagTest(int n)
	{
		return isInt( ( Math.sqrt( 24 * n + 1 ) + 1 ) / 6 );
	}

	/**
	 * Find two pentagonal numbers whose sum and difference are both also pentagonal.
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		for ( int j = 1; j < 10000; j++ )
			for ( int k = 1; k < j; k++ )
			{
				int pentj = j * ( 3 * j - 1 ) / 2;
				int pentk = k * ( 3 * k - 1 ) / 2;
				
				if ( pentagTest(pentj + pentk) && pentagTest(pentj - pentk) )
				{
					System.out.println("j = " + j + "\nk = " + k);
					System.out.println("\nP_j = " + pentj + "\nP_k = " + pentk);
				}
			}
			
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
