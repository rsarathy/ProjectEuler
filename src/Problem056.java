import java.math.BigInteger;


public class Problem056
{

	public static int digitSum(BigInteger num)
	{	
	    String stringOfNum = num.toString();
	    
	    int sum = 0;
	    
	    for( int i = 0; i < stringOfNum.length(); i++)
	    	sum += Character.getNumericValue(stringOfNum.charAt(i));
	    
	    return sum;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		int max = 0;
		
		for ( int a = 2; a < 100; a++ )
			for ( int b = 1; b < 100; b++ )
			{
				BigInteger exp = new BigInteger(String.valueOf(a));
				exp = exp.pow(b);
				int dSum = digitSum(exp);
				if ( max < dSum )
					max = dSum;
//				addend = addend.pow(i);
//				sum = sum.add(addend);
			}
		
		System.out.println(max);
		
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
