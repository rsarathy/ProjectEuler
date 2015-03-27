public class Problem036
{
	public static boolean isPalindrome(String str)
	{    
	    int n = str.length();
	    for (int i = 0; i < n/2; i++)
	        if (str.charAt(i) != str.charAt(n-i-1)) return false;
	    return true;    
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		int[] palindromes = new int[1998]; //2(9+90+999)
		int index = 0;
		for ( int i = 1; i < 1000000; i++ )
		{
			if ( isPalindrome(i + "") )
			{
				palindromes[index] = i;
				index++;
			}
		}
		
		int palSum = 0;
		for ( int k = 0; k < palindromes.length; k++ )
			if ( isPalindrome(Integer.toBinaryString(palindromes[k])))
				palSum += palindromes[k];
		
		System.out.println("Sum of double base palindromes less than one million: " + palSum);
		
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
