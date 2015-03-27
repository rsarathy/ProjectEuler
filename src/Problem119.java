
public class Problem119
{
	public static int digitSum(int N)
	{
		String s = N + "";
		int dSum = 0;
		for ( int j = 0; j < s.length(); j++ )
			dSum += Character.getNumericValue(s.charAt(j));
		return dSum;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		
		long startTime = System.currentTimeMillis();
		
		long[] powers = new long[99*9];
		int index = 0;
		for ( int m = 2; m <= 100; m++ )
			for ( int n = 1; n <= 9; n++ )
				powers[index++] = (long)Math.pow(m,n);

		int ct = 0;
		for ( int i = 10; i < 1000000000; i++ )
		{
			int ds = digitSum(i);
			int pow = ds;
			if ( ds == 1 ) continue;
			while ( ds < i )
			{
				ds *= pow;
				if ( ds == i )
				{
					ct++;
					System.out.println("a_" + ct + ": " + i);
				}
			}
		}

		System.out.println("Powerful digit numbers: " + ct);
//		System.out.println(powers[400]);
//		a_1: 81
//		a_2: 512
//		a_3: 2401
//		a_4: 4913
//		a_5: 5832
//		a_6: 17576
//		a_7: 19683
//		a_8: 234256
//		a_9: 390625
//		a_10: 614656
//		a_11: 1679616
//		a_12: 17210368
//		a_13: 34012224
//		a_14: 52521875
//		a_15: 60466176
//		a_16: 205962976

		
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 
	}

}
