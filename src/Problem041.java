import java.util.ArrayList;

public class Problem041
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

	public static boolean isPrime(int n) 
	{
        if (n <= 1) return false;
        if (n == 2) return true;
        for (int i = 2; i <= Math.sqrt(n) + 1; i++)
            if (n % i == 0)
                return false;
        return true;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		permute("1234567");
		int[] nums = new int[permutations.size()];
		
		for ( int i = 0; i < nums.length; i++ )
		{
			nums[i] = Integer.parseInt(permutations.get(i));
			if ( isPrime(nums[i]) )
				System.out.println(nums[i]);
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 
	}

}
