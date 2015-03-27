import java.math.BigInteger;

public class Problem013
{

	/**
	 * Find the sum of one hundred 50-digit numbers given in a text file.
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		
		TextIO.readFile("Problem013numbers.txt");
		
		BigInteger sum = new BigInteger("0");

		while ( !TextIO.eof() )
			sum = sum.add(new BigInteger(TextIO.getln()));
		
		System.out.println(sum);
		System.out.println(sum.toString().substring(0, 10)); //first 10 digits
		
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 
	}

}
