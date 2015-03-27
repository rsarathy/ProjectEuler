import java.math.BigDecimal;
import java.math.BigInteger;

public class Problem057
{
	static BigDecimal rt2 = new BigDecimal(Math.sqrt(2) + "");
	
	public static BigInteger pell(int n)
	{
		BigDecimal p = BigDecimal.ONE.add(rt2);
		BigDecimal q = BigDecimal.ONE.subtract(rt2);
		BigDecimal div = new BigDecimal("2").multiply(rt2);
		p = p.pow(n);
		q = q.pow(n);
		
		p = p.subtract(q);
		p = p.divide(div);
		return p.toBigInteger();
//		return (long)((Math.pow(1 + rt2, n) - Math.pow(1 - rt2, n)) / (2 * rt2)) + 1;
	}
	
	public static BigInteger lucas(int n)
	{
		BigDecimal p = BigDecimal.ONE.add(rt2);
		BigDecimal q = BigDecimal.ONE.subtract(rt2);
		
		p = p.pow(n);
		q = q.pow(n);
		
		p = p.add(q).divide(new BigDecimal("2"));
		return p.toBigInteger();
//		return (long)(Math.pow(1+rt2,n)+Math.pow(1-rt2, n)) + 1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		int ct = 0;
		for ( int i = 1; i <= 1000; i++ )
		{
			String a = pell(i).toString();
			String b = lucas(i).toString();
			if ( b.length() > a.length() )
				ct++;
		}
		
		System.out.println(ct);

		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
