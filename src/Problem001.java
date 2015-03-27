public class Problem001
{
	/**
	 * Prints sum of all positive integer multiples of 3 or 5 ≤ 1000. 
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		int sum = 0;
		for ( int i = 1; i < 1000; i++ )
			if ( i % 3 == 0 || i % 5 == 0 )
				sum += i;
		System.out.println(sum); 

		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 
		
		
	}

}
