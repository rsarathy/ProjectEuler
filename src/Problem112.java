public class Problem112
{
	static boolean isIncreasing(int n)
	{
		if ( n < 10 ) return true;
		
		String s = n + "";
		for ( int i = 0; i < s.length()-1; i++ )
			if ( Character.getNumericValue(s.charAt(i)) > 
					Character.getNumericValue(s.charAt(i+1)) )
				return false;
		return true;
	}
	
	static boolean isDecreasing(int n)
	{
		if ( n < 10 ) return true;
		
		String s = n + "";
		for ( int i = 0; i < s.length()-1; i++ )
			if ( Character.getNumericValue(s.charAt(i)) < 
					Character.getNumericValue(s.charAt(i+1)) )
				return false;
		return true;
	}
	
	static boolean isBouncy(int n)
	{
		if ( n < 100 ) return false;
		return (!isIncreasing(n) && !isDecreasing(n));
	}
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		int bouncy = 0;
		
		for ( int i = 1; i <= 10000000; i++ )
		{
			if ( isBouncy(i) )
				bouncy++;
			if ( bouncy * 100 == i * 99 )
			{
				System.out.println(bouncy + " " + i);
				break;
			}
		}

		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
