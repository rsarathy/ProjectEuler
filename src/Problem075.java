
public class Problem075
{
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		int limit = 1500000;
		int counter = 0;
		int nlimit = (int) Math.sqrt(limit);
		int[] triple = new int[limit + 1];
		for (int m = 2; m < nlimit; m++)
			for (int n = 1; n < m; n++)
				if ((m - n) % 2 == 1 && Numbers.coprime(m, n))
				{
					int a = m * m - n * n;
					int b = 2 * m * n;
					int c = m * m + n * n;
					int L = a + b + c;

					for (int k = 1; L * k <= limit; k++)
					{
						if (triple[k * L] == 0)
						{
							triple[k * L] = 1;
							counter++;
						} 
						else if (triple[k * L] == 1)
						{
							triple[k * L] = -1;
							counter--;
						}
					}
				}

		System.out.println("Values of L that have one unique Pythagorean triple: " + counter);
		
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
