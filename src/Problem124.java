import java.util.Arrays;

public class Problem124
{	
	final static int MAX = 100000;
	static int[] primes = ESieve.generatePrimes(MAX);
	
	static int rad(int n)
	{
		if ( n == 1 ) return 1;
		if ( Numbers.isPrime(n) ) return n;
		
		int product = 1;
		for ( int i = 0; i < primes.length && primes[i] < n; i++ )
			if ( n % primes[i] == 0 )
				product *= primes[i];
		return product;
	}

	/**
	 * Implements an array of "radicals" which are as a class,
	 * defined as pairs of integers. See Radical.java for more information on
	 * the defined class.
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		Radical[] rads = new Radical[MAX+1];
		
		System.out.println(rad(504));
		
		rads[0] = new Radical(0,0);
		for ( int i = 1; i < rads.length; i++ )
			rads[i] = new Radical(i, rad(i));
		
//		System.out.println(rads[504].toString());
//		
//		System.out.println(rads[3].toString());
//		System.out.println(rads[9].toString());
//		
//		System.out.println(rads[3].compareTo(rads[9]));
//		System.out.println(rads[8].compareTo(rads[9]));
		
		Arrays.sort(rads);
		
		System.out.println("\nE(10000) = " + rads[10000]);
		
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}
}
