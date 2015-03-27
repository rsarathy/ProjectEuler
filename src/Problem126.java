public class Problem126
{
	static int cuboids(int n)
	{
		return 0;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		int million = (int)Math.pow(10, 6);
		int[] cuboids = new int[2*million];
		for ( int a = 1; a <= 2000; a++ )
			for ( int b = 1; b <= a; b++ )
				for ( int c = 1; c <= b; c++ )
				{
					int SA = 2*(a*b+b*c+c*a);
					if ( SA < 2*million )
						cuboids[SA]++;
				}
		
		int max = 0, maxI = 0;
		for ( int i = 0; i < cuboids.length; i++ )
			if ( cuboids[i] > max )
			{
				max = cuboids[i];
				maxI = i;
			}
		
		System.out.println("C(" + maxI + ") = " + max);

		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
