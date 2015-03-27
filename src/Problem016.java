import java.math.BigInteger;

public class Problem016
{

	/**
	 * Compute the sum of digits of 2^1000.
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		BigInteger num = new BigInteger("1");
		
		for ( int i = 0; i < 1000; i++ )
			num = num.multiply(new BigInteger(2+""));
		
		System.out.println(num);
		String stringOfNum = num.toString();
		int sum = 0;
		
		for(int i = 0; i < stringOfNum.length(); i++)
			sum += Character.getNumericValue(stringOfNum.charAt(i));
		
		System.out.println(sum);
	}
}

    
