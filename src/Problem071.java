public class Problem071
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		final double ts = 3.0/7.0;
		final int million = (int)Math.pow(10,6);
		
		double minDif = 1.0;
		int minDenom = 0, minNume = 0;
		
		for ( int i = 1; i <= million; i++ )
		{
			int lo = (int)(i * ts) - 1;
			int hi = (int)(i * ts) + 1;
			for ( double j = lo; j <= hi; j++ )
			{
				double frac = j / i;
				double diff = frac-ts;
				if ( diff < 0 && Math.abs(diff) < Math.abs(minDif) && Numbers.coprime(i, (int)j) )
				{
					minDif = Math.abs(diff);
					minNume = (int)j;
					minDenom = i;
				}
			}
		}
			
		System.out.println(minNume + "/" + minDenom);
		
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
