
public class Problem009
{

	/**
	 * Find the product abc where the ordered triple (a, b, c) is a Pythagorean triple
	 * with the property a + b + c = 1000.
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		
		for ( int i = 1; i < 500; i++ )
			for ( int j = 1; j < 500; j++ )
				for ( int k = 1; k < 500; k++ )
					if ( i * i + j * j == k * k && (i + j + k == 1000) )
					{
						System.out.println("a = " + i);
						System.out.println("b = " + j);
						System.out.println("c = " + k);
						System.out.println("abc = " + i * j * k);
					}
		
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
