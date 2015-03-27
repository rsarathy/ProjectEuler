
public class Problem021
{

	public static int sumDiv(int n)
	{
		int sum = 0;
		
		for ( int i = 1; i < Math.sqrt(n) + 1; i++ )
			if ( n % i == 0 )
				sum += (i + (n/i));
		
		return sum - n;
	}
	
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
	 * Compute the sum of all amicable numbers < 10000.
	 * 
	 * 220 + 284 + 1184 + 1210 + 2620 + 2924 + 5020 + 5564 + 6232 + 6368
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		
		int amSum = 0;
		
		for ( int i = 1; i < 10000; i++ )
		{
			boolean amicable = sumDiv(i) == sumDiv(sumDiv(i)) 
					&& i != sumDiv(sumDiv(i)) && !isPrime(i);
			if ( amicable )
			{
				System.out.println(i);
				amSum += i;
			}
		}

		// System.out.println(sumDiv(28));
//		System.out.println( sumDiv(220));
//		System.out.println( sumDiv(sumDiv(220)));
		System.out.println(amSum);

		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
