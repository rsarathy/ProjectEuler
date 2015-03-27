
public class Problem086
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		int M = 3;
		int solutions = 0;
		while ( solutions < 1000000 )
		{
			if ( M == 3 )
				for ( int a = 1; a <= M; a++ )
					for ( int b = 1; b <= a; b++ )
						for ( int c = 1; c <= b; c++ )
						{
							int diag = a*a + (b+c)*(b+c);
							if ( Numbers.isSquare(diag) )
								solutions++;
						}
			else
			{
				int a = M;
				for ( int b = 1; b <= a; b++ )
					for ( int c = 1; c <= b; c++ )
					{
						int diag = a*a + (b+c)*(b+c);
						if ( Numbers.isSquare(diag) )
							solutions++;
					}
			}
			
			if ( solutions > 1000000 )
			{
				System.out.println("M = " + M + ": " + solutions);
				break;
			}
			M++;
		}

		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
