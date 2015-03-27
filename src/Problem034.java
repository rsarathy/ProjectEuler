import java.math.BigInteger;

public class Problem034
{
	public static final int[] dec = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000 };
	
	public static int factorial(int n)
	{
		if ( n == 0 || n == 1 ) return 1;
		return n * factorial(n - 1);
	}
	
	public static int dFact(BigInteger num)
	{
		String n = num.toString();
		int dFactSum = 0;
		for ( int i = 0; i < n.length(); i++ )
			dFactSum += factorial(Character.getNumericValue(n.charAt(i)));
		return dFactSum;
	}
	


	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		for ( int i = 1; i < 10000000; i++ )
		{
			BigInteger curious = new BigInteger(String.valueOf(i));
			if ( i == dFact(curious) )
				System.out.println(i);
		}
		
		
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 
		

	}

}
