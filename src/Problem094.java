
public class Problem094
{

	/**
	 *	Find the sum of all "almost equilateral triangles" perimeters ≤10^9.
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		int limit = (int)Math.pow(10, 9);

		int nlimit = (int)Math.sqrt(limit);
		long sum = 0;
		for (int m = 2; m < nlimit; m++)
			for (int n = 1; n < m; n++)
				if ((m - n) % 2 == 1 && Numbers.coprime(m, n))
				{
					int a = m * m - n * n;
					int b = 2 * m * n;
					int c = m * m + n * n;
					
					a = Math.min(a, b);
					b = Math.max(a, b);
					
					int P = 2*(a+c);
					
					if ( Math.abs(c-2*a) == 1 && P <= limit )
						sum += P;
				}
		
		System.out.println("Sum of all almost equilateral triangle perimeters: " + sum);

		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 
		
		
	}

}
