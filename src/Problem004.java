public class Problem004
{
	public static int palindromify(int n)
	{
		int a = n / 100;
		int b = ( n % 100 ) / 10;
		int c = n - 100 * a - 10 * b;
		
		// System.out.println("a = "  + a + "\nb = " + b + "\nc = " + c);
		
		n = 100000 * a + 10000 * b + 1000 * c
				+ 100 * c + 10 * b + a;
		
		return n;
	}
	
	public static int divisor(int h)
	{
		for ( int div = 1; div < Math.sqrt(h) + 1; div++ )
		{
			int q = h / div;
			if ( h % div == 0 && ( div >= 100 && div <= 999 ) && ( q >= 100 && q <= 999 ) )
				return 1;			
		}
		
		return -1;
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
		
		int[] palindromes = new int[900];
		
		for ( int i = 0; i < palindromes.length; i++ )
		{
			palindromes[i] = i + 100;
			palindromes[i] = palindromify(palindromes[i]);
			if ( divisor(palindromes[i]) == 1 )
				System.out.println(palindromes[i]);
		}
		
		
		// System.out.println(palindromes[438]);
		
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
