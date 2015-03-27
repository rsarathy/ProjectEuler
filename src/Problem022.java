public class Problem022
{
	public static String[] quickSort(String[] strArr, int p, int r)
	{
		if (p < r)
		{
			int q = partition(strArr, p, r);
			quickSort(strArr, p, q);
			quickSort(strArr, q + 1, r);
		}

		return strArr;
	}

	private static int partition(String[] strArr, int p, int r)
	{
		String x = strArr[p];
		int i = p - 1;
		int j = r + 1;

		while (true)
		{
			i++;
			while (i < r && strArr[i].compareTo(x) < 0)
				i++;
			j--;
			while (j > p && strArr[j].compareTo(x) > 0)
				j--;

			if (i < j)
				swap(strArr, i, j);
			else
				return j;
		}
	}

	private static void swap(String[] strArr, int i, int j)
	{
		String temp = strArr[i];
		strArr[i] = strArr[j];
		strArr[j] = temp;
	}

	/**
	 * Find the total of the name scores in the file p022_names.txt.
	 * 
	 * Implements a regex to parse all the names into a list of Strings, and then
	 * uses a quicksort to arrange the names alphabetically.
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		TextIO.readFile("p022_names.txt");

		String s = TextIO.getln();		
		String[] names = s.split(",");
		for ( int i = 0; i < names.length; i++ )
			names[i] = names[i].substring(1, names[i].length() - 1);
		
		quickSort(names, 0, names.length - 1);
		
		int namesScore = 0;
		
		for ( int i = 0; i < names.length; i++ )
			for ( int j = 0; j < names[i].length(); j++ )
				namesScore += ( ( i + 1 ) * ( Character.getNumericValue(names[i].charAt(j)) - 9 ) );
		
		System.out.println(namesScore);

		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
