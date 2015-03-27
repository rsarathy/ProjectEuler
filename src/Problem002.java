
public class Problem002
{

	public int evenFib (int n)
	{
		return 0;
	}
	
	/**
	 * Sum of all even Fibonacci numbers under 4 million.
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		
		int[] fibs = { 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377,
				610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368,
				75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309,
				3524578 }; // all fib #s under 4,000,000
		
		long sum = 0;
		
		for ( int i = 0; i < fibs.length; i++ )
			if ( fibs[i] % 2 == 0 )
				sum += fibs[i];
		
		System.out.println(sum);
			
	}

}
