public class Problem038
{
	public static String nineDigit(int n)
	{
		String str = String.valueOf(n);
		str += (n * 2);
		return str;
	}
	
	public static boolean isPandigital(String s)
	{
		if ( s.length() != 9 ) return false;
		for ( int i = 0; i < s.length(); i++ )
			if ( s.indexOf(Integer.toString(i+1)) == -1 )
				return false;
		return true;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		
		for ( int i = 9000; i < 9999; i++ )
			if (isPandigital(nineDigit(i)))
			{
				System.out.println(i + " = " + nineDigit(i));
			}

		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 
		
		

	}

}
