import java.math.BigDecimal;
import java.math.RoundingMode;

public class Problem080
{
	private static final BigDecimal SQRT_DIG = new BigDecimal(51);
	private static final BigDecimal SQRT_PRE = new BigDecimal(10).pow(SQRT_DIG
			.intValue());

	/**
	 * Private utility method used to compute the square root of a BigDecimal.
	 * 
	 * @author Luciano Culacciatti
	 * @url http://www.codeproject.com/Tips/257031/Implementing-SqrtRoot-in-
	 *      BigDecimal
	 */
	private static BigDecimal sqrtNewtonRaphson(BigDecimal c, BigDecimal xn,
			BigDecimal precision)
	{
		BigDecimal fx = xn.pow(2).add(c.negate());
		BigDecimal fpx = xn.multiply(new BigDecimal(2));
		BigDecimal xn1 = fx.divide(fpx, 2 * SQRT_DIG.intValue(),
				RoundingMode.HALF_DOWN);
		xn1 = xn.add(xn1.negate());
		BigDecimal currentSquare = xn1.pow(2);
		BigDecimal currentPrecision = currentSquare.subtract(c);
		currentPrecision = currentPrecision.abs();
		if (currentPrecision.compareTo(precision) <= -1)
		{
			return xn1;
		}
		return sqrtNewtonRaphson(c, xn1, precision);
	}

	/**
	 * Uses Newton Raphson to compute the square root of a BigDecimal.
	 * 
	 * @author Luciano Culacciatti
	 * @url http://www.codeproject.com/Tips/257031/Implementing-SqrtRoot-in-
	 *      BigDecimal
	 */
	public static BigDecimal bigSqrt(BigDecimal c)
	{
		return sqrtNewtonRaphson(c, new BigDecimal(1),
				new BigDecimal(1).divide(SQRT_PRE));
	}
	
	public static boolean isSquare(int n)
	{
		int sqrt = (int)Math.sqrt(n);
		return sqrt * sqrt == n ? true : false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		int sum = 0;
		
//		for ( int i = 2; i < 100; i++ )
//		{
//			if ( isSquare(i) )
//				i++;
//			
//			BigDecimal sqrt = bigSqrt(new BigDecimal(String.valueOf(i)));
//			String s = sqrt.toString();
//			s = s.substring(2);
//			System.out.println(i + " " + s.length() + " " + sum);
//			
//			for ( int j = 0; j < s.length(); j++ )
//				sum += Character.getNumericValue(s.charAt(j));
//		}
		
		BigDecimal rt = bigSqrt(new BigDecimal("2"));
		String s = rt.toString();
		
		for ( int i = 0; i < s.length(); i++ )
			sum += Character.getNumericValue(s.charAt(i));
		
		System.out.println(s.length());
		System.out.println(s);
		System.out.println("Sum of all digits = " + sum);
		
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime)
				+ " ms to compile.");

	}

}
