
public class Problem223
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		int ct = 0;
		for ( int c = 2; c <= 100; c++ )
			for ( int b = c; b > 0; b-- )
				for ( int a = b; a > 0; a-- )
					if ( a*a + b*b == c*c + 1 )
					{
//						System.out.println("(" + a + "," + b + "," + c + ")");
						ct++;
					}
		System.out.println(ct);
		
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
