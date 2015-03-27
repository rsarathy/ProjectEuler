import java.math.BigInteger;

public class Problem053
{
	public static BigInteger factorial(int n)
	{
		BigInteger fac = new BigInteger("1");
		if(n == 0 || n == 1) return fac;
		
		for ( int i = n; i > 1; i-- )
			fac = fac.multiply(new BigInteger(String.valueOf(i)));
		return fac;
	}
	
	public static BigInteger combinatoric(int n, int r)
	{
		BigInteger fN = factorial(n);
		BigInteger fR = factorial(r);
		BigInteger fNR = factorial(n - r);
		
		return fN.divide(fR.multiply(fNR)); // n! / r!(n-r)!
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		int combCt = 0;
		
		for ( int m = 9; m <= 100; m++ )
			for ( int n = 1; n < m - 1; n++ )
				if ( combinatoric(m, n).compareTo(new BigInteger("1000000")) == 1 )
					combCt++;
		
		System.out.println(combCt);
//		System.out.println(combinatoric(23, 10));
					

		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 
	}

}
