public class Problem045
{
	public static boolean isInt(double d)
	{
	    return d == (int) d;
	}
	
	/**
	 * Find the next hexagonal pentagonal triangular number following 40,755.
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		
		
		for ( int i = 1; i < 100000; i++ )
		{
			long hexagonal =  i * (2 * i - 1);
			double pentagTest = ( Math.sqrt (24 * hexagonal + 1) + 1 ) / 6;
		//	double hexagTest = ( Math.sqrt(8 * triangle + 1) + 1) / 4;
			
			if ( isInt(pentagTest) )
				System.out.println(hexagonal);
		}
				
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 
	}

}
