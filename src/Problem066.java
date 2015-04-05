public class Problem066
{
	public static int pellSolver(int D)
	{
		int p = 1, k = 1, x1 = 1, y = 0;
		double sd = Math.sqrt(D);
		
		while ( k != 1 || y == 0 )
		{
			p = k * (p/k + 1) - p;
			p = p - ((int)((p-sd)/k) * k);
			
			int x = (p * x1 + D * y) / Math.abs(k);
			y = (p * y + x1) / Math.abs(k);
			k = (p*p - D) / k;
			x1 = x;
		}
		
		return x1;
	}

	/**
	 * x^2 - Dy^2 = 1
	 * 
	 * Attempt using Chakravala Algorithm.
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		
		int maxX = 0, maxD = 5;
		for ( int i = 2; i <= 1000; i++ )
		{
			if ( Numbers.isSquare(i) ) continue;
			
			int xPellD = pellSolver(i);
			if ( xPellD > maxX )
			{
				maxX = xPellD;
				maxD = i;
			}
		}
		
		System.out.println(maxD + " " + maxX);
		
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
