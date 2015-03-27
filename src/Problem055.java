import java.math.BigInteger;

public class Problem055
{
	public static boolean isLychrel(BigInteger num, int steps)
	{
		if ( steps >= 50 ) return true;
		if ( Numbers.isPalindrome(num.toString()) && steps != 0 ) return false;
		
		StringBuilder flip = new StringBuilder(num.toString()).reverse();
		
		num = num.add(new BigInteger(flip.toString()));
		
		return isLychrel(num, steps + 1);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		int ct = 0;
		
		for ( int i = 1; i < 10000; i++ )
		{
			BigInteger natural = new BigInteger(String.valueOf(i));
			if ( isLychrel(natural,0) )
				ct++;
		}
		
		System.out.println("Number of Lychrel numbers under 10,000: " + ct);

		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}
}
