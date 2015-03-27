public class Problem007
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
	
	/**
	 * Find the 10,001st prime number.
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		
		int primeCt = 0;
		int i = 1;
		
		while ( primeCt != 10001 )
		{
			if ( isPrime(i) )
				primeCt++;
			i++;
		}
		
		System.out.println(i - 1);
		
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
