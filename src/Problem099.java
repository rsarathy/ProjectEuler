import java.math.BigInteger;

public class Problem099
{

	/**
	 * Compare a^b within the given text file.
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		TextIO.readFile("p099_base_exp.txt");
		
		String[][] base_exp = new String[1000][2];
		BigInteger[] pwrs = new BigInteger[1000];
		int[] exp = new int[1000];
		
		for ( int i = 0; i < base_exp.length; i++ )
		{
			String numbers = TextIO.getln();
			base_exp[i] = numbers.split(",");
			pwrs[i] = new BigInteger(base_exp[i][0]); //bigInts = bases
			exp[i] = Integer.parseInt(base_exp[i][1]);
		}
		
		BigInteger max = new BigInteger("1");
		int maxIndex = 0;
		
		for ( int i = 0; i < pwrs.length; i++ )
			pwrs[i] = pwrs[i].pow(exp[i]);
		
		for ( int i = 0; i < pwrs.length; i++ )
			if ( pwrs[i].compareTo(max) == 1 )
			{
				max = pwrs[i];
				maxIndex = i;
				System.out.println("maxIndex = " + maxIndex);
			}
		
		System.out.println(maxIndex);
		

		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
