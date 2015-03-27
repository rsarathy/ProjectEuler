import java.math.BigInteger;


public class Problem138
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		BigInteger sumL = new BigInteger("0");
		for ( int n = 1; n <= 12; n++ )
		{
			int k = 6*n+3;
			BigInteger L_k = Numbers.fibonacci(k).divide(new BigInteger("2"));
			System.out.println("L_" + n + " = " + L_k);
			sumL = sumL.add(Numbers.fibonacci(k));
		}
		
		System.out.println("Sum of first 12 special isoceles triangles: " + sumL);
//		int limit = (int)Math.pow(10, 9);
//
//		int nlimit = (int)Math.sqrt(limit);
//		long sum = 0;
//		for (int m = 2; m < nlimit; m++)
//			for (int n = 1; n < m; n++)
//				if ((m - n) % 2 == 1 && Numbers.coprime(m, n))
//				{
//					int a = m * m - n * n;
//					int b = 2 * m * n;
//					int c = m * m + n * n;
//					
//					int tempA = a, tempB = b;
//					a = Math.min(tempA, tempB);
//					b = Math.max(tempA, tempB);
//					
//					int P = a + b + c;
//					
//					if ( Math.abs(b-2*a) == 1 && P <= limit )
//					{
//						System.out.println("b = " + 2*a + ", L = " + c + ", h = " + b);
//					}
//				}
		
//				b = 16, L = 17, h = 15
//				b = 272, L = 305, h = 273
//				b = 4896, L = 5473, h = 4895
//				b = 87840, L = 98209, h = 87841
//				b = 1576240, L = 1762289, h = 1576239
//				b = 28284464, L = 31622993, h = 28284465
//				The program took 19522 ms to compile.
		
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 
		
		

	}

}
