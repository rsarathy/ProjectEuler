
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
		
		System.out.println(rads[504].toString());
		
		System.out.println(rads[3].toString());
		System.out.println(rads[9].toString());
		
		System.out.println(rads[3].toString().compareTo(rads[9].toString()));
		
		Radical[] sorted = Radical.quickSort(rads);
		System.out.println(sorted[10000].toString());
//		for ( int i = 0; i < sort.length; i++ )
//			if ( sort[i] == 3 )
//				System.out.println(i);
//		
//		for ( int i = 0; i < 10; i++ )
//			System.out.println((i+1) + " " + sort[i]);

		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
