
public class Problem031
{

	public static int foo(int n)
	{
		if (n < 0) return 0;
		if (n == 0) return 1;
		
		return foo(n - 1) + foo(n - 2) + foo(n - 5)
				+ foo(n - 10) + foo(n - 20) + foo(n - 50)
				+ foo(n - 100) + foo(n - 200);
		
	}
	
	/**
	 * Calculate the number of ways to make change for 200 cents.
	 */
	public static void main(String[] args)
	{
		
		long startTime = System.currentTimeMillis();

		int tgt = 200;
		int ct = 0;
		
		 for ( int a = tgt; a >= 0; a -= 200 )
			 for ( int b = a; b >= 0; b -= 100 )
				 for ( int c = b; c >= 0; c -= 50 )
					 for ( int d = c; d >= 0; d -= 20 )
						 for ( int e = d; e >= 0; e -= 10 )
							 for ( int f = e; f >= 0; f -= 5 )
								 for ( int g = f; g >= 0; g -= 2 )
									 ct++;
		System.out.println(ct);

		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 
		

	}

}
