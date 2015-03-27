import java.math.BigInteger;

public class Problem048
{

	/**
	 * Find the last ten digits of ∑(n^n) n: [1, 1000].
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		BigInteger sum = new BigInteger("0");
		
		for ( int i = 1; i < 1000; i++ )
		{
			BigInteger addend = new BigInteger(i+"");
			addend = addend.pow(i);
			sum = sum.add(addend);
		}
		
		String fin = sum.toString();
		
		System.out.println(fin.substring(fin.length() - 10));
		
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 
	}		
}
