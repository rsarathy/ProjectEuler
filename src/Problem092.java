public class Problem092
{
	public static final int[] dec = {1, 10, 100, 1000, 10000, 100000, 1000000};
	
	public static int chain(int n)
	{
		if(n == 1) return 1;
		if(n == 89) return 89;
		
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
		
		return chain(a*a + b*b + c*c + d*d + e*e + f*f + g*g);
		
//		return 0;
	}

	/**
	 * Square digit chains
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

//		chain(3448392); //works
//		chain(125); //works 10000000
		int eighty9 = 0, one = 0;
		
		for ( int i = 1; i < 10000000; i++ )
		{
			if ( chain(i) == 1 ) one++;
			if ( chain(i) == 89 ) eighty9++;
		}
		
		System.out.println("1s = " + one);
		System.out.println("89s = " + eighty9);

		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
