public class Problem004
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
	 * Largest palindrome that is the product of two 3-digit numbers.
	 * 
	 * Ans: 906609 (993 * 913)
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		
		int maxPal = 0;
		for ( int a = 101; a <= 999; a++ )
			for ( int b = 100; b < a; b++ )
			{
				int ab = a*b;
				if ( isPalindrome(ab+"") && ab > maxPal )
					maxPal = ab;
			}
		
		System.out.println("Largest palindrome that is the product of two 3-digit numbers: " + maxPal);
		
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
