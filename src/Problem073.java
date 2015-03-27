public class Problem073
{
	static final double LO = 1.0/3.0;
	static final double HI = 1.0/2.0;
	
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		int ct = 0;
		
		for ( int i = 2; i <= 12000; i++ )
		{
			int lo = (int)(LO * i) - 1;
			int hi = (int)(HI * i) + 1;
			for ( double j = lo; j <= hi; j++ )
			{
				double frac = j / i;
				if ( frac > LO && frac < HI && Numbers.coprime(i, (int)j) )
					ct++;
			}
		}
		
		System.out.println(ct);

		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile.");
	}
}
