
public class Problem110
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		
		for ( int a = 0; a < 9; a ++ )
			for ( int b = 0; b < 9; b++ )
				for ( int c = 1; c < 9; c++ )
					for ( int d = 1; d < 9; d++ )
						for ( int e = 1; e < 9; e++ )
							for ( int f = 1; f < 9; f++ )
							{
								int product = (2*a+1)*(2*b+1)*(2*c+1)*(2*d+1)*(2*e+1)*(2*f+1);
								if ( product > 1999 )
								{
									int sols = (product + 1)/2;
									System.out.println("Number of solutions: " + sols);
									System.out.print("a = " + a);
									System.out.print(", b = " + b);
									System.out.print(", c = " + c);
									System.out.print(", d = " + d);
									System.out.print(", e = " + e);
									System.out.print(", f = " + f);
									System.out.println();
									System.exit(0);
								}
							}
	
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
