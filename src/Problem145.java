public class Problem145
{
	public static int reverse(int n)
	{
		String backwards = new StringBuilder(n+"").reverse().toString();
		if ( backwards.charAt(0) == '0' ) return Integer.MIN_VALUE;
		int r = Integer.parseInt(backwards);
		return r;
	}
	
	public static boolean isReversible(int n)
	{
		String isR = String.valueOf(n + reverse(n));
		for ( int i = 0; i < isR.length(); i++ )
			if ( Character.getNumericValue(isR.charAt(i)) % 2 != 1 )
				return false;
		return true;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		int ct = 0;
		for ( int i = 1; i <= 1000000000; i += 2 ) //count odds and double the total at the end
			if ( isReversible(i) )
				ct++;
		System.out.println(2*ct); //117,071 ms
				
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
