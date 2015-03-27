import java.math.BigInteger;

public class Problem206
{

	/**
	 * Find the unique positive integer whose square has the form
	 * 1_2_3_4_5_6_7_8_9_0.
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		
		//number must be 1_2_3_4_5_6_7_8_900
		
		long lowerBound = (long)Math.sqrt(1020304050607080900L);
		long upperBound = (long)Math.sqrt(1929394959697989900L);
		
		for (long i = lowerBound; i < upperBound; i += 10 )
		{
			BigInteger sq = new BigInteger(i+"");
			sq = sq.pow(2);
			
			String check = sq.toString();
			
			int flag = 0;
			
			for ( int k = 0; k <= 9; k++ )
				if ( ( k + 1 ) % 10 != Character.getNumericValue(check.charAt(2 * k)) )
					flag++;
			
			if (flag == 0)
			{
				System.out.println(i);
				break;
			}
		}

		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 
	}

}
