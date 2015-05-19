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
		double[] pwrs = new double[1000];
		double[] exp = new double[1000];
		
		double max = 0D;
		int maxIndex = 0;
		
		for ( int i = 0; i < 1000; i++ )
		{
			String numbers = TextIO.getln();
			base_exp[i] = numbers.split(",");
			pwrs[i] = Double.parseDouble(base_exp[i][0]);
			exp[i] = Double.parseDouble(base_exp[i][1]);
			exp[i] /= 1000000; //work with simpler exponents
			pwrs[i] = Math.pow(pwrs[i], exp[i]);
			if ( pwrs[i] > max )
			{
				max = pwrs[i];
				maxIndex = i;
			}
		}
		
		System.out.println("The largest power is at line number " + (maxIndex+1) + ".");

		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}
}
