
public class Problem222
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		double length = 0.0;
		for ( int r = 30; r < 50; r++ )
		{	
			System.out.println(400*r-9800);
			length += ( Math.sqrt(400 * r - 9800) );
		}
		
		length += 80; //30 + 50, endpoints of the pipe
		System.out.println(length * 1000);

		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 	
	}

}
