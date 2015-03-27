public class Problem032
{
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

		for ( int i = 3; i < 10000; i++ )
			for ( int j = 2; j < i; j++ )
			{
				int product = i * j;
				String str = i + "" + j + "" + product;
				if (isPandigital(str))
					System.out.println(i + " * " + j + " = " + product);
			}
		
		// 138 * 42 = 5796
		// 157 * 28 = 4396
		// 159 * 48 = 7632
		// 186 * 39 = 7254
		// 198 * 27 = 5346
		// 1738 * 4 = 6952
		// 1963 * 4 = 7852

		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
