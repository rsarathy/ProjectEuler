import java.math.BigDecimal;

public class Problem205
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		
		BigDecimal peteWins = new BigDecimal("0.0"); 

		TextIO.readFile("p205_cube.txt");
		
		BigDecimal[] cubeProbs = new BigDecimal[37];
		BigDecimal[] pyramidProbs = new BigDecimal[37];
		BigDecimal divisor = new BigDecimal("100.0");
		
		for (int i = 6; i < cubeProbs.length; i++)
		{
			String ln = TextIO.getln();
			int comma = ln.indexOf(',');
			ln = ln.substring(comma + 1);
			cubeProbs[i] = new BigDecimal(ln);
			cubeProbs[i] = cubeProbs[i].divide(divisor);
		}

		TextIO.readFile("p205_pyramid.txt");

		for (int i = 9; i < pyramidProbs.length; i++)
		{
			String ln = TextIO.getln();
			int comma = ln.indexOf(',');
			ln = ln.substring(comma + 1);
			pyramidProbs[i] = new BigDecimal(ln);
			pyramidProbs[i] = pyramidProbs[i].divide(divisor);
		}
		
		for ( int i = 36; i >= 9; i-- )
			for ( int j = i - 1; j >= 6; j-- )
			{
				BigDecimal probability = new BigDecimal(pyramidProbs[i].toString());
				probability = probability.multiply(cubeProbs[j]);
				peteWins = peteWins.add(probability);
			}
		
		System.out.println(peteWins);
		
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
