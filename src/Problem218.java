
public class Problem218
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		int limit = (int)Math.pow(10, 8);

		int nlimit = (int) Math.sqrt(limit);
		int ct = 0;
		for (int m = 2; m < nlimit; m++)
			for (int n = 1; n < m; n++)
				if ((m - n) % 2 == 1 && Numbers.coprime(m, n))
				{
					int a = m * m - n * n;
					int b = 2 * m * n;
					int c = m * m + n * n;
					int L = a + b + c;
					
					if ( Numbers.isSquare(c) ) ct++;
				}
		
		System.out.println(ct);

		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
