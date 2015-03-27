import java.math.BigInteger;
import java.util.Arrays;

public class Problem104
{
	final static String pandigital = "123456789";
	
	static boolean isPermutation(String str1, String str2)
	{
		if (str1.length() != str2.length())
			return false;

		char[] a = str1.toCharArray();
		char[] b = str2.toCharArray();

		Arrays.sort(a);
		Arrays.sort(b);

		return Arrays.equals(a, b);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		for ( int i = 40; i < 14000; i++ )
		{
			String s = Numbers.fibonacci(i).toString();
			boolean panEnd = isPermutation(s.substring(s.length()-9), pandigital);
			boolean panFrt = isPermutation(s.substring(0,9), pandigital);
			
			if ( panEnd )
				System.out.println("F_" + i + " has a pandigital end.");
			if ( panFrt )
				System.out.println("F_" + i + " has a pandigital start.");
			
			if ( panEnd && panFrt )
			{
				System.out.println("BINGO! F_" + i + " is super pandigital.");
				break;
			}
		}
		
//		fibonacci(10000); //7599ms
		
//		String s = "31948295r7938u91493123456789";
//		System.out.println(isPermutation(s.substring(s.length()-9), pandigital));
		
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
