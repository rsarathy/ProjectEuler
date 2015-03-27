import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Problem203
{
	final static int[] primes = ESieve.generatePrimes(50);
	//all the binomial coefficients are highly composite, since they are partially factorial
	//therefore we technically only need to check primes up until 50. e.g. --> 100C50 = 100!/(50!)^2
	
	public static BigInteger[] getDistinct(ArrayList<BigInteger> input)
	{
		Set<BigInteger> distinct = new HashSet<BigInteger>();
		for ( BigInteger element : input)
			distinct.add(element);
		return distinct.toArray(new BigInteger[0]);
	}
	
	static boolean isSqFree(long n)
	{
		for ( int i = 0; i < primes.length; i++ )
		{
			int sq = primes[i] * primes[i];
			if ( n % sq == 0 )
				return false;
		}		
		return true;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		
		ArrayList<BigInteger> binom = new ArrayList<BigInteger>();
		
		for ( int n = 2; n <= 50; n++ )
			for ( int r = 0; r < n / 2 + 1; r++ )
				binom.add(Numbers.choose(n, r));
		
		BigInteger[] distBinoms = getDistinct(binom);
		long[] finalBinoms = new long[distBinoms.length];

		long sum = 0;
		for ( int i = 0; i < distBinoms.length; i++ )
		{
			finalBinoms[i] = distBinoms[i].longValue();
			if ( isSqFree(finalBinoms[i]) )
				sum += finalBinoms[i];
		}
		
		System.out.println("Sum of Squarefree Binomial Coefficients: " + sum);
		// Ans: 34029210557338

		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}
}
