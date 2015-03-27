import java.util.ArrayList;

public class Problem043
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
		
		int[] primes = { 2, 3, 5, 7, 11, 13, 17 };

		permute("0123456789");

//		Iterator<String> itr = permutations.iterator();
		
		long sum = 0L;
		
		for ( int i = 0; i < permutations.size(); i++ )
		{
			boolean divisible = true;
			
			if ( permutations.get(i).charAt(0) == '0' )
				i++;
			else
			{
				for ( int j = 0; j < primes.length; j++ )
				{
					int substring = Integer.parseInt(permutations.get(i).substring(j + 1, j + 4));
					if ( substring % primes[j] != 0 )
						divisible = false;
				}
				if (divisible)
				{
					System.out.println(permutations.get(i));
					sum += (Long.parseLong(permutations.get(i)));
				}
			}
		}
		
		System.out.println("Sum of all sub-string divisible pandigital numbers: " + sum);
		
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime)
				+ " ms to compile.");
	}
}