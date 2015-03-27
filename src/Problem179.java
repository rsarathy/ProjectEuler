public class Problem179
{
	public static boolean isSquare(double zahl)
	{
		double m = Math.sqrt(zahl);
		double n = (int) Math.sqrt(zahl);
		if (m == n) return true;
		return false;
	}

	public static int divs(int n)
	{
		if ( n == 1 ) return 1;
		
		int ct = 0;
		boolean square = isSquare(n);
		for ( int i = 2; i*i <= n; i++ )
			if ( n % i == 0 )
				ct++;
		
		if ( square ) return 1 + 2*ct;
		return 2 + ct * 2;
	}
		
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		int ct = 0;
		//10^7 = 199,352ms
		//10^6 = 6,249ms
		//10^5 = 216ms
		//10^4 = 9ms
		for ( int i = 1; i < (int)(Math.pow(10, 7)); i++ )
		{
			if ( divs(i) == divs(i+1) )
				ct++;
			if ( i % (int)(Math.pow(10, 6)) == 0 )
				System.out.println(i / 1000000 + "0% complete.");
		}
		System.out.println(ct);
		
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
