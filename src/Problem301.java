public class Problem301
{
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		int cap = (int)Math.pow(2, 30);
		int ct = 0;
		for ( int n = 1; n <= cap; n++ )
			if ( (n^(2*n)^(3*n)) == 0 )
				ct++;

		System.out.println("Number of losing positions: " + ct);

		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 
	}
}
