public class Problem174
{
	public static boolean sameParity(int a, int b)
	{
		return a % 2 == b % 2;
	}
	
	public static int laminas(int n)
	{
		int ct = 0;
		for ( int p = 1; p * p < n; p++ )
			if ( n % p == 0 )
			{
				int q = n / p;
				if ( sameParity(p,q) )
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

		int ct = 0;
		int million = (int)(Math.pow(10, 6));
		for ( int i = 8; i < million; i += 4 )
		{
			int lamina = laminas(i);
			if ( lamina <= 10 )
				ct++;
		}
		System.out.println(ct);

		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 
		
	}

}
