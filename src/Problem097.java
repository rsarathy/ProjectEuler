public class Problem097
{

	/**
	 * Find 28433 * 2^7830457 + 1 mod 10^10.
	 */
	public static void main(String[] args)
	{

		long a = 28433;
		String m = "10000000000";
		long mod = Long.parseLong(m);

		for ( int i = 1; i <= 7830457; i++)
			a = (a * 2) % mod;

		System.out.println(a + 1);
	}

}
