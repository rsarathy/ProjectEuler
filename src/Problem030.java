public class Problem030
{
	public static final int[] dec = {1, 10, 100, 1000, 10000, 100000, 1000000};
	
	public static int pwr5(int n)
	{	
		int a = n / dec[6];
		int b = (n - a * dec[6]) / dec[5];
		int c = (n - a * dec[6] - b * dec[5]) / dec[4];
		int d = (n - a * dec[6] - b * dec[5] - c * dec[4]) / dec[3];
		int e = (n - a * dec[6] - b * dec[5] - c * dec[4] - d * dec[3]) / dec[2];
		int f = (n - a * dec[6] - b * dec[5] - c * dec[4] - d * dec[3] - e * dec[2]) / dec[1];
		int g = n - a * dec[6] - b * dec[5] - c * dec[4] - d * dec[3] - e * dec[2] - f * dec[1];
		
//		System.out.println("a = "  + a);
//		System.out.println("b = "  + b);
//		System.out.println("c = "  + c);
//		System.out.println("d = "  + d);
//		System.out.println("e = "  + e);
//		System.out.println("f = "  + f);
//		System.out.println("g = "  + g);
		
		return (int)( Math.pow(a, 5) + Math.pow(b, 5) + Math.pow(c, 5) + Math.pow(d, 5) + Math.pow(e, 5)
				+ Math.pow(f, 5) + Math.pow(g, 5) );
		
//		return 0;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		int pwr5Sum = 0;
		
		for ( int i = 1; i < 1000000; i++ )
			if ( i == pwr5(i) && i != 1 ) // System.out.println(i);
				pwr5Sum += i;

		System.out.println(pwr5Sum);
		
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 
		
	}
}
