
public class Problem095
{
	static int sumDiv(int n)
	{
		if ( n == 1 ) return 1;
		int sum = 0;
		for ( int i = 2; i * i <= n; i++ )
			if ( n % i == 0 )
			{
				int j = n / i;
				sum += (i+j);
			}
		
		return 1+sum;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		for ( int i = 1; i < 10000; i++ )
		{
			int p = sumDiv(i);
			int q = sumDiv(p);
//			if ( p == q )
//				System.out.println(i + "," + p);
		}
		
		System.out.println("Sum of divisors of 220: " + sumDiv(220));
		System.out.println("Sum of divisors of 284: " + sumDiv(284));
		
		int start = 12496;
		int iter = 12496;
		while ( iter != start )
		{
			int div = sumDiv(iter);
			System.out.print(iter + "-->");
			iter = div;
		}
		System.out.println(sumDiv(12496));
		
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
