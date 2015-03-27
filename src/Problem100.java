
public class Problem100
{

	/**
	 * Find P(B|B) = 1/2, where N > 10^12.
	 */
	public static void main(String[] args)
	{
		
		
		long startTime = System.currentTimeMillis();
		
		final long trillion = 1000000000000L;
		
		long bDiscs = 15;
		long nDiscs = 21;
		
		
		//b_k+1 = 3b_k + 2n_k - 2;
		//n_k+1 = 4b_k + 3n_k - 3;
		
		//b_1 = 15
		//n_1 = 21
		
		while ( nDiscs < trillion )
		{
			long blue = bDiscs;
			long discs = nDiscs;
			bDiscs = 3 * blue + 2 * discs - 2;
			nDiscs = 4 * blue + 3 * discs - 3;
		}

		System.out.println("Number of blue discs: " + bDiscs);
		
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
