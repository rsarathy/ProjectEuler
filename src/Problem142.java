
public class Problem142
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		for ( int x = 3; x < 3000; x++ )
			for ( int y = 2; y < x; y++ )
				for ( int z = 1; z < y; z++ )
				{
					boolean xAndY = Numbers.isSquare(x+y) && Numbers.isSquare(x-y);
					boolean xAndz = Numbers.isSquare(x+z) && Numbers.isSquare(x-z);
					boolean yAndz = Numbers.isSquare(y+z) && Numbers.isSquare(y-z);
					
					if ( xAndY && xAndz && yAndz )
						System.out.println("(" + x + "," + y + "," + z + ")");
				}

		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
