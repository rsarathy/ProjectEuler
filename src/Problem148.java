public class Problem148
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		
		long[] S = new long[8];
		long[] T = new long[11];
		T[0] = 0;
		T[1] = 0;
		for ( int i = 2; i < 11; i++ )
		{
			T[i] = (long)Math.pow(28,i);
			System.out.println("T_" + i + " = " + T[i]);
		}
		
		S[7] = 21 * T[2] + 7 * 70;
		S[6] = 21 * T[5] + 7 * S[7];
		S[5] = T[6] + 2 * S[6];
		S[4] = 6 * T[7] + 4 * S[5];
		S[3] = 15 * T[8] + 6*S[4];
		S[2] = 6 * T[9] + 4 * S[3];
		S[1] = 6 * T[10] + 4 * S[2];
		
		System.out.println("Number of integers not divisble by 7 in the first" +
				" 10^9 rows of Pascal's Triangle: " + S[1]);
		
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 
	}
}
