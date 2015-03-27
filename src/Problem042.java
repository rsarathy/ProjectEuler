public class Problem042
{

	/**
	 * Find the number of coded triangular words.
	 */
	public static void main(String[] args)
	{
		
		long startTime = System.currentTimeMillis();
		
		TextIO.readFile("p042_words.txt");
		
		String s = TextIO.getln();
		
		String[] words = s.split(",");
		int[] wCode = new int[words.length];
		
		for ( int i = 0; i < words.length; i++ )
			words[i] = words[i].substring(1, words[i].length() - 1);
		
		for ( int i = 0; i < words.length; i++ )
			for ( int j = 0; j < words[i].length(); j++ )
				wCode[i] += ( Character.getNumericValue(words[i].charAt(j)) - 9);
		
		int triCt = 0;
		
		for ( int k = 0; k < wCode.length; k++ )
			for ( int t = 1; t <= 40; t++ )
				if ( wCode[k] == (t * (t + 1) / 2))
				{
					System.out.println(words[k]);
					triCt++;
				}
		
		System.out.println("Number of coded triangular words: " + triCt);
		
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 		

	}

}
