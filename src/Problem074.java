public class Problem074
{
	public static int factorialChain(long n, long ch, int steps)
	{
		if ( n == ch && steps != 0 ) return steps;
		if ( ch == 2 ) return steps + 1;
		if ( ch == 145 ) return steps + 1;
		if ( ch == 169 ) return steps + 3;
		if ( ch == 871 ) return steps + 2;
		if ( ch == 872 ) return steps + 2;
		if ( ch == 40585 ) return steps + 1;
		
		String num;
		
		if ( steps == 0 ) num = String.valueOf(n);
		else num = String.valueOf(ch);
		
		ch = 0;
		for ( int i = 0; i < num.length(); i++ )
		{
			char digit = num.charAt(i);
			ch += Numbers.factorial(Character.getNumericValue(digit));
		}

		return factorialChain(n, ch, steps+1);
	}

	public static int factorialChain(int n)
	{
		return factorialChain(n,n,0);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		
		int max = 0;

		for ( int i = 1; i < 1000000; i++ )
		{ 
			int chains = factorialChain(i);
			if ( chains == 60 )
				max++;
		}
		System.out.println(max);
		
		System.out.println(factorialChain(14558));

		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 
	}

}
