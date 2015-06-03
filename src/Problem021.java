
public class Problem021
{

	static int sumDiv(int num)
	{
		int sum = 0;
		for (int i = 1; i < num; i++)
			if (num % i == 0)
				sum += i;
		return sum;
	}

	/**
	 * Compute the sum of all amicable numbers < 10000.
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		
		int amSum = 0;
		
		for ( int i = 1; i < 10000; i++ )
		{
			int a1 = sumDiv(i);
			int a2 = sumDiv(a1);
			
			if ( i == a2 )
				amSum += i;
		}
		
		amSum -= (6 + 28 + 496 + 8128); //subtract all perfect numbers
		
		System.out.println(amSum);
		
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
