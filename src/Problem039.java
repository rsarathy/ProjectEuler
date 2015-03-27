public class Problem039
{	
	public static void swap ( int i, int j )
	{
		int temp = i;
		j = temp;
		i = j;
	}
	
	public static int GCF ( int a, int b )
	{
		if ( b > a )
			swap(a, b);
		
		while ( b != 0 )
		{
			int m = a % b;
			a = b;
			b = m;
		}
		
		return a;
	}

	/**
	 * Find an integer perimeter ≤ 1000 that generates the most Pythagorean Triples.
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		//use euclid's formula: 
		// a = k(m^2 - n^2)
		// b = k(2mn)
		// c = k(m^2 + n^2)
		
//		int[] p = new int[1001];
		
		int pMax = 0, triplesMax = 0;
		int m = 0, k = 0;
		 
		for (int perimeter = 1; perimeter <= 1000; perimeter++)
		{
			int triples = 0;
			int mlimit = (int) Math.sqrt(perimeter / 2);
			
			for (m = 2; m <= mlimit; m++)
			{
				if ((perimeter / 2) % m == 0)
				{ // m found
					if (m % 2 == 0) k = m + 1;
					else k = m + 2;
					
					while (k < 2 * m && k <= perimeter / (2 * m))
					{
						if (perimeter / (2 * m) % k == 0 && GCF(k, m) == 1)
							triples++;
						k += 2;
					}
				}
			}
			
			if (triples > triplesMax)
			{
				triplesMax = triples;
				pMax = perimeter;
			}
		}
		
		System.out.println("The maximum number of Pythagorean triples is when p = " + pMax + ".");
		
//		for ( int m = 2; m <= 25; m++ )
//			for ( int n = 1; n < m; n++ )
//				if ( m > n && ( m - n ) % 2 == 1 && GCF(m,n) == 1)
//				{
//					int a = m * m - n * n;
//					int b = 2 * m * n;
//					int c = m * m + n * n;
//					for ( int k = 1; k < 85; k++ )
//						if ( k * (a + b + c) <= 1000 && k * a < k * b )
//						{
//							System.out.println("(" + k * a + "," + k * b + "," + k * c + ")");
//							p[k * (a + b + c)]++;
//						}
//				}

//		for ( int i = 0; i < p.length; i++ )
//			System.out.println("Solutions for p = " + i + ": " + p[i]);
		
		
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
