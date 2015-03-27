import java.math.BigInteger;

public class Problem148
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		
		BigInteger seven = new BigInteger("7");
		BigInteger zero = BigInteger.ZERO;
		
		int rows = 100;

		int n = 0;
		BigInteger[] pascal = new BigInteger[(rows * rows + rows)/2];
		int ct = 0;
		for ( int i = 0; i <= rows-1; i++ )
			for ( int j = 0; j <= i; j++ )
			{
				pascal[n] = Numbers.choose(i, j);
				if ( pascal[n].mod(seven).compareTo(zero) == 0 )
					ct++;
				n++;
			}
		
		

		System.out.println(pascal.length-ct + " / " + pascal.length + " not divisible by 7.");
				

		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 
	}

}
