import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class Problem029
{

	public static BigInteger[] getDistinct(BigInteger[] input)
	{
		Set<BigInteger> distinct = new HashSet<BigInteger>();
		for ( BigInteger element : input)
			distinct.add(element);
		return distinct.toArray(new BigInteger[0]);
	}

	/**
	 * Find the number of distinct powers a^b for a,b:[2,100].
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		BigInteger[] powers = new BigInteger[99*99];
		int index = 0;
		
		for ( int a = 2; a <= 100; a++ )
			for ( int b = 2; b <= 100; b++ )
			{
				BigInteger pwr = new BigInteger(String.valueOf(a));
				pwr = pwr.pow(b);
				powers[index++] = pwr;
			}
		
		BigInteger[] distinct = getDistinct(powers);
		System.out.println(distinct.length);
	
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
