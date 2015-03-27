
public class Problem040
{

	/**
	 * Find the product of the 1st, 10th, 100th, 1,000th, 10,000th, 100,000th, 
	 * and millionth digit in the sequence 1234567891011121314...
	 * 
	 * Ans: 1 * 1 * 5 * 3 * 7 * 2 * 1 = 210
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		
		StringBuffer s = new StringBuffer();
		
		for ( int i = 0; i < 200000; i++ )
			s.append(i);
		
		System.out.println(s.charAt(1) +
				" " + s.charAt(10) +
				" " + s.charAt(100) + 
				" " + s.charAt(1000) +
				" " + s.charAt(10000) + 
				" " + s.charAt(100000) + 
				" " + s.charAt(1000000) );
		
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
