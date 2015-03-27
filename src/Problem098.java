import java.awt.List;
import java.util.*;


public class Problem098
{
	public static void choose(int N)
	{
		Set<Integer> set = new TreeSet<Integer>();
		for (int c = 1; c < N; c++)
		{
			set.add(c);
		}

		ArrayList<Integer> list = new ArrayList<Integer>(set);
		Collections.shuffle(list);
		System.out.println(list.subList(0, 3));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

//		TextIO.readFile("p098_words.txt");
//		String[] words = TextIO.getln().split(",");
//		for ( int i = 0; i < words.length; i++ )
//			words[i] = words[i].substring(1, words[i].length()-1);
		
		choose(9);

		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
