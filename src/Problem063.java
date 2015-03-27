import java.math.BigInteger;

public class Problem063
{

	/**
	 * Find the number of n-digit positive integers that are also an nth power.
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		int ct = 0;
		
		for ( int i = 1; i < 10; i++ )
			for ( int j = 1; j < 22; j++ )
			{
				BigInteger largePow = new BigInteger(i+"");
				largePow = largePow.pow(j);
				
				int digits = largePow.toString().length();
				
				if ( digits == j )
					ct++;
			}

		System.out.println(ct);

		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 	
		
	}
}
