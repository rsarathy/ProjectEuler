
public class Problem120
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		int sum_r_max = 0;
		for ( int i = 3; i <= 1000; i++ )
		{
			if ( i % 2 == 1 ) sum_r_max += (i*i-i);
			else sum_r_max += (i*i-2*i);
		}	
		System.out.println("∑r_max = " + sum_r_max);

		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
