public class Problem176
{
	public static boolean sameParity(int a, int b)
	{
		return a % 2 == b % 2;
	}

	public static int laminas(int n)
	{
		int ct = 0;
		for (int p = 1; p * p < n; p++)
			if (n % p == 0)
			{
				int q = n / p;
				if (sameParity(p, q))
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

		System.out.println(laminas(12));

		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 
	}

}
