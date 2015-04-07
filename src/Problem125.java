public class Problem125
{
	public static boolean isPalindrome(String str)
	{    
	    int n = str.length();
	    for (int i = 0; i < n/2; i++)
	        if (str.charAt(i) != str.charAt(n-i-1)) 
	        	return false;
	    return true;    
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		int ub = (int)Math.sqrt(Math.pow(10,8)/2); //7071
		int[] squares = new int[ub + 1];
		boolean[] consSqs = new boolean[(int)(Math.pow(10, 8)) + 1];
		squares[0] = 0;
		
		for ( int i = 1; i < squares.length; i++ )
			squares[i] = i*i;
		
		for ( int k = 2; k < 671; k++ )
		{
			for ( int j = 1; j < squares.length - k + 1; j++ )
			{
				long sum = 0;
				for (int n = 0; n < k; n++)
					sum += squares[j + n];
				if ( sum < consSqs.length )
				{
					int index = (int)sum;
					consSqs[index] = true;
				}
			}
		}
		
		long sum = 0;
		for ( int i = 1; i < consSqs.length; i++ )
			if ( consSqs[i] )
			{
				String s = i + "";
				if ( isPalindrome(s) )
					sum += i;
			}
		
		System.out.println(sum);
		
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
