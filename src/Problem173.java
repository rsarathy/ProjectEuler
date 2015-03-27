public class Problem173
{
	public static boolean sameParity(int a, int b)
	{
		return a % 2 == b % 2;
	}
	
	public static int laminas(int n)
	{
		int ct = 0;
		for ( int p = 1; p * p < n; p++ )
		{
			if ( n % p == 0 )
			{
				int q = n / p;
				if ( sameParity(p,q) )
				{
//					int a = (q+p)/2;
//					int b = (q-p)/2;
//					System.out.println(a+"^2 - " + b + "^2 = " + n);
					ct++;
				}
			}
		}
		//(a+b)(a-b) = n
		//n = pq
		//p = a+b
		//q = a-b

		return ct;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		int ct = 0;
		
		for ( int i = 8; i <= 1000000; i+=4 )
			ct += laminas(i);

		System.out.println("Number of laminas that can be created with a million tiles: " + ct);

		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
