import java.math.BigInteger;

public class Problem113
{
	
	static boolean isIncreasing(int n)
	{
		if ( n < 10 ) return true;
		
		String s = n + "";
		for ( int i = 0; i < s.length()-1; i++ )
			if ( Character.getNumericValue(s.charAt(i)) > 
					Character.getNumericValue(s.charAt(i+1)) )
				return false;
		return true;
	}
	
	static boolean isDecreasing(int n)
	{
		if ( n < 10 ) return true;
		
		String s = n + "";
		for ( int i = 0; i < s.length()-1; i++ )
			if ( Character.getNumericValue(s.charAt(i)) < 
					Character.getNumericValue(s.charAt(i+1)) )
				return false;
		return true;
	}
	
	static boolean isBouncy(int n)
	{
		if ( n < 100 ) return false;
		return (!isIncreasing(n) && !isDecreasing(n));
	}
	
	/**
	 * increasing numbers: (10+n-1)Cn - 1
	 * decreasing numbers: (10+n)Cn - n
	 * increasing & decreasing: 9n
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		//O(1) solution - 109C10 + 110C10 + 8*100 - 1;
		int n = 100;
		BigInteger ans = Numbers.choose(10+n-1, n);
		ans = ans.add(Numbers.choose(10+n, n));
		ans = ans.subtract(new BigInteger(10*n+""));
		ans = ans.subtract(new BigInteger("1"));
		System.out.println("Non-Bouncy Numbers: " + ans);
		
		//debug purposes
//		int bCt = 0, iCt = 0, dCt = 0, c = 0;
//		int bound = 100000;
//		
//		for ( int i = 1; i <= bound; i++ )
//		{
//			if ( isDecreasing(i) ) dCt++;
//			if ( isIncreasing(i) ) iCt++;
//			if ( isDecreasing(i) && isIncreasing(i) ) c++;
//			if ( isBouncy(i) ) bCt++;
//		}
//		int nbct = bound - bCt;
//		
//		System.out.println("Non-Bouncy Numbers: " + nbct + "\n");
//		System.out.println("Increasing Numbers: " + iCt);
//		System.out.println("Decreasing Numbers: " + dCt);
//		System.out.println("Incr & Decr numbers: " + c + "\n");
//		System.out.println("Bouncy Numbers: " + bCt + "\n");

		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
