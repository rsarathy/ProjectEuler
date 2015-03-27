
public class Problem085
{
	public static final int TWO_MILLION = 2000000;

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		int min = TWO_MILLION;
		int em = 2015;
		int en = 2015;
		
		for ( int m = 2; m < 2015; m++ )
		{
			int cM = m * (m - 1) / 2;
			for ( int n = 2; n < 2015; n++ )
			{
				int cN = n * (n - 1) / 2;
				if ( min > Math.abs(cM * cN - TWO_MILLION) )
				{
					min = Math.abs(cM * cN - TWO_MILLION);
					em = m;
					en = n;
				}
			}
		}
		
		System.out.println("m = " + em);
		System.out.println("n = " + en);
		
		System.out.println("m x n = " + (em - 1) + " x " + (en - 1) + " = "
				+ (em - 1) * (en - 1) );

		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 
	}

}
