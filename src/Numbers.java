import java.math.BigInteger;

public class Numbers
{
	static int[] primes = ESieve.generatePrimes(100000);
	
	static boolean isPrime(int n)
	{
	    if (n % 2 == 0) return n == 2;
	    if (n % 3 == 0) return n == 3;
	    int step = 4, m = (int)Math.sqrt(n) + 1; // we only check divisors of the form 6k±1.
	    for(int i = 5; i < m; step = 6 - step, i += step)
	        if (n % i == 0)
	            return false;
	    return true;
	}
	
	public static boolean isSquare(double zahl)
	{
		double m = Math.sqrt(zahl);
		double n = (int) Math.sqrt(zahl);
		if (m == n) return true;
		return false;
	}
	
	static boolean isCube(double N)
	{
		double cubeRoot = Math.cbrt(N);
		double rt = (int)Math.cbrt(N);
		return cubeRoot == rt;
	}
	
	public static boolean isPalindrome(String str)
	{    
	    int n = str.length();
	    for (int i = 0; i < n/2; i++)
	        if (str.charAt(i) != str.charAt(n-i-1)) return false;
	    return true;    
	}
	
	public static BigInteger fibonacci(int n)
	{
		BigInteger a = BigInteger.ONE;
		BigInteger b = BigInteger.ONE;
		BigInteger c;
		for (int i = 3; i <= n; i++)
		{
			c = a.add(b);
			a = b;
			b = c;
		}
		return b;
	}
	
	/**
	 * Works for N <= 12; small N only. 
	 */
	public static long factorial(int n)
	{
		if ( n <= 1 ) return 1;
		return n * factorial(n-1);
	}
	
	public static BigInteger choose(int n, int r)
	{
		if ( n == r ) return new BigInteger("1"); //nCr = 1;
		if ( n == r+1 ) return new BigInteger(n+""); //nC(r-1) = n;
		
		BigInteger combinatoric = new BigInteger("1");
		int m = Math.max(r, n - r);
		int nR = Math.min(r, n - r);
		for (int k = n; k > m; k-- )
			combinatoric = combinatoric.multiply(new BigInteger(k+""));
		for (int i = 2; i <= nR; i++ )
			combinatoric = combinatoric.divide(new BigInteger(i+""));
		return combinatoric;
	}
	
	public static int tau(long n)
	{
		int divs = 1;
		int p = 0;
		while ( n > 1 )
		{
			int factors = 0;
			while ( n % primes[p] == 0 )
			{
				n /= primes[p];
				++factors;
			}
			divs *= (factors + 1);
			p++;
		}
		return divs;
	}
	
	public static void swap ( int i, int j )
	{
		int temp = i;
		j = temp;
		i = j;
	}
	
	public static int GCF ( int a, int b )
	{
		if ( b > a )
			swap(a, b);
		
		while ( b != 0 )
		{
			int m = a % b;
			a = b;
			b = m;
		}
		
		return a;
	}
	
	public static boolean coprime(int a, int b)
	{
		return GCF(a,b) == 1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		
	}

}
