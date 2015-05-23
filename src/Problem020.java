import java.math.BigInteger;

public class Problem020
{

	/**
	 * Calculate the sum of digits of 100!
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		int sum = 0;

		BigInteger fac = new BigInteger("1");
		for (int i = 2; i <= 100; i++)
			fac = fac.multiply(new BigInteger(i + ""));
		String s = fac.toString();
		for (int j = 0; j < s.length(); j++)
			sum += Character.getNumericValue(s.charAt(j));

		System.out.println("Sum of digits of 100! = " + sum);

		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile.");
	}
}
