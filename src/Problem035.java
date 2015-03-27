public class Problem035
{
	public static int[] rotations (int n)
	{
		int[] rot = new int[String.valueOf(n).length()];
		rot[0] = n;
		
		if ( rot.length > 1 )
		{
			for ( int i = 1; i < rot.length; i++ )
			{
				String s = String.valueOf(n);
				s = s.charAt(s.length() - 1) + s.substring(0,s.length()-1);
				n = Integer.parseInt(s);
				rot[i] = n;
			}
		}
		
		return rot;
	}

	public static boolean isPrime(int n)
	{
		if (n <= 1)
			return false;
		if (n == 2)
			return true;
		for (int i = 2; i <= Math.sqrt(n) + 1; i++)
			if (n % i == 0)
				return false;
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		int[] primes = ESieve.generatePrimes(1000000);
		
		int ct = 0;
		
		for ( int i = 0; i < primes.length; i++ )
		{
			int[] cyclic = rotations(primes[i]);
			boolean isCircular = true;
			for ( int j = 0; j < cyclic.length; j++ )
			{
				if ( !isPrime(cyclic[j]) )
					isCircular = false;
			}
			if ( isCircular )
				ct++;
		}
		
		System.out.println(ct);
		
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 
		
		
		
	}

}
