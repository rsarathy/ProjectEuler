public class Problem047
{
	public static boolean isPrime(int n) 
	{
        if (n <= 1) return false;
        if (n == 2) return true;
        for (int i = 2; i <= Math.sqrt(n) + 1; i++)
            if (n % i == 0)
                return false;
        return true;
    }
	
	public static int primeDiv(int n)
	{
		if ( n == 1 ) return 0;
		if ( isPrime(n) ) return 1;
		
		int ct = 0;
		for ( int i = 1; i <= Math.sqrt(n); i++ )
			if ( n % i == 0 )
			{
				if ( isPrime(i) )
					ct++;
				if ( isPrime(n/i))
					ct++;
			}
		return ct;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		
		for ( int i = 15; i < 200000; i++ )
			if ( primeDiv(i) == 4 && primeDiv(i + 1) == 4 
					&& primeDiv(i + 2) == 4 && primeDiv(i + 3) == 4 )
				System.out.println(i);

		
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 
		
	}

}
