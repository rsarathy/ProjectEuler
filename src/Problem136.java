
public class Problem136
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		final int limit = 50*(int)Math.pow(10, 6);
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
		        if (sols[i] == 1)
		            count++;
		    System.out.println(count);

		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
