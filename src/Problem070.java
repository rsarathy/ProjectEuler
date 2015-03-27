import java.util.Arrays;

public class Problem070
{
	static boolean isPermutation(String str1, String str2)
	{
		  if (str1.length() != str2.length())
		      return false;

		    char[] a = str1.toCharArray();
		    char[] b = str2.toCharArray();

		    Arrays.sort(a);
		    Arrays.sort(b);

		    return Arrays.equals(a, b);
	}
	
	public static int totient(int n) //this is the number you want to find the totient of
	{
		int orig = n;
		int totient = n; //this will be the totient at the end of the sample
		for (int div = 2; div*div <= n; div++)
		{
		    if (n % div == 0 )
		    {
		        totient /= div;
		        totient *= (div-1);
		        while ( n % div == 0 ) 
		            n /= div;
		    }
		}
		if ( n > 1 )
		{ // now n is the largest prime divisor
		    totient /= n;
		    totient *= (n-1);
		}
		
		return totient;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		
		double minTot = 87109.0;
		minTot /= 79180;
		//initialize a minimum ratio
		
		int minN = 0;

		for ( int i = 2; i < 10000000; i++ )
		{
			double n = i;
			String s1 = i + "";
			String s2 = totient(i) + "";
			if ( isPermutation(s1,s2) )
				if ( minTot > n / totient(i) )
				{
					minTot = n / totient(i);
					minN = i;
				}
		}
		
		System.out.println("phi(" + minN + ") = " + totient(minN));

		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
