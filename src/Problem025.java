import java.math.BigInteger;


public class Problem025
{
	public static BigInteger fibonacci(int n)
	{
		BigInteger a = BigInteger.ONE;
		BigInteger b = BigInteger.ONE;
		BigInteger c;
		for (int i = 3; i <= n; i++)
		{
			c = a.add(b);
			a = b;
			b = c;
		}
		return b;
	}
	/**
	 * Find the first term in the fibonacci sequence exceeding over 1000 digits.
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		for ( int n = 3; n < 10000; n++ )
		{
			BigInteger f = fibonacci(n);
			String fibStr = f.toString();
//			System.out.println(fibStr);
			if ( fibStr.length() == 1000 )
			{
				System.out.println("n = " + n);
				break;
			}
		}

		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 
	}

}
