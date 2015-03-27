
public class Problem023
{
	public static int sumDiv(int n)
	 {
	    int sqrt = (int)Math.sqrt(n);
	    int sum = 1;
	 
	    //If the number is a perfect square
	    //Count the squareroot once in the sum of factors
	    if (n == sqrt * sqrt)
	    {
	        sum += sqrt;
	        sqrt--;
	    }
	 
	    for (int i = 2; i <= sqrt; i++) {
	        if (n % i == 0) {
	            sum += ( i + (n / i) );
	        }
	    }
	 
	    return sum;
	}
	
	/**
	 * Find the sum of integers that cannot be expressed as a sum of two abundant numbers.
	 */
	public static void main(String[] args)
	{
		final int limit = 28124;
		long startTime = System.currentTimeMillis();
		boolean[] can = new boolean[limit + 1];

		int ct = 0;
		int[] abundant = new int[6966];
		for ( int i = 1; i < limit; i++ )
			if ( sumDiv(i) > i )
			{
				abundant[ct] = i;
				ct++;
			}
		
		System.out.println(ct);
		
		for ( int j = 0; j < abundant.length; j++ )
			for ( int k = j; k < abundant.length; k++ )
				if ( abundant[j] + abundant[k] <= limit )
					can[abundant[j] + abundant[k]] = true;
				else
					break;
		
		int sum = 0;
		for ( int i = 1; i <= limit; i++ )
			if (!can[i])
			{
				System.out.println(i);
				sum += i;
			}
		
		System.out.println(sum);
			
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
