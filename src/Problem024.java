import java.util.ArrayList;

public class Problem024
{
	public static ArrayList<String> permutations = new ArrayList<String>();

	public static void permute(String prefix, String s)
	{
		int n = s.length();

		if (n == 0)
			permutations.add(prefix);
		else
			for (int i = 0; i < n; i++)
				permute(prefix + s.charAt(i),
						s.substring(0, i) + s.substring(i + 1, n));
	}

	private static void permute(String s)
	{
		permute("", s);
	}

	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		permute("0123456789");

		System.out
				.println("The millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9 is "
						+ permutations.get(999999));

		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime)
				+ " ms to compile.");
	}
}