public class Problem135
{
	public static int solutions(int n)
	{
		int ct = 0;
		for ( int p = 1; p <= n; p++ )
			if ( n % p == 0 )
			{
				int q = n / p;
				if ( (p + 3*q) % 2 == 0 && (p+q) % 4 == 0 )
				{
					int a = (3*q-p)/4;
					int d = (p+q)/4;
					if ( a > 0 && d > 0 )
						ct++;
				}
			}
		return ct;
	}
	/**
	 * 4989
		The program took 1964895 ms to compile.
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

//		int ct = 0;
//		for ( int i = 1154; i < 1000000; i++ )
//		{
//			if ( i % 100000 == 0 )
//				System.out.println(i/10000 + "% complete.");
//			if ( solutions(i) == 10 )
//				ct++;
//		}
//		System.out.println(ct);
		
		 final int limit = 1000000;
		 int[] sols = new int[limit];
		    
		    for (int p = 1; p < limit; p++)
		    {
		        int q = 1;
		        while (p * q < limit)
		        {
		        	//(3d-a)(a+d) = n
		        	// p = 3d - a
		        	// q = 	d + a
		        	
		        	// d = (p+q)/4
		        	// a = (3q-p)/4
		            if ( (p+q) % 4 == 0 && 3 * q > p && (3*q - p) % 4 == 0)
		                sols[p * q] ++;
		            q++;
		        }
		    }
		    
		    int count = 0;
		    for (int i = 1; i < limit; i++)
		        if (sols[i] == 10)
		            count++;
		    System.out.println(count);
		
		/**
		 * 1444^2 - 1155^2 - 866^2 = 1155
			482^2 - 385^2 - 288^2 = 1155
			290^2 - 231^2 - 172^2 = 1155
			208^2 - 165^2 - 122^2 = 1155
			134^2 - 105^2 - 76^2 = 1155
			100^2 - 77^2 - 54^2 = 1155
			74^2 - 55^2 - 36^2 = 1155
			52^2 - 35^2 - 18^2 = 1155
		 */
		//1444,1155,866 --> a = 866, d = 289, p = 1, q = 1155
		//482,385,288 --> a = 288, d = 97, p = 3, q = 385
		//290,231,172 --> a = 172, d = 59, p = 5, q = 231
		//208,165,122 --> a = 122, d = 43, p = 7, q = 165
		//134,105,76 --> a = 76, d = 29, p = 11, q = 105
		//100,77,54 --> a = 54, d = 23, p = 15, q = 77
		//74,55,36 --> a = 36, d = 19, p = 21, q = 55
		//52,35,18 --> a = 18, d = 17, p = 33, q = 35
		
		//50,33,16 --> a = 16, d = 17, p = 35, q = 33
		//40,21,2 --> a = 2, d = 19, p = 55, q = 21

		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
