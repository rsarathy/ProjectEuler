import java.math.BigInteger;

public class Problem148
{
	public static String spacing(int n)
	{
		StringBuffer space = new StringBuffer();
		for ( int i = 0; i < n; i++ )
			space.append(' ');
		return space.toString();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		BigInteger seven = new BigInteger("7");
		BigInteger zero = BigInteger.ZERO;

		int rows = 100;
		int ct = 0;

		BigInteger[][] triangle = new BigInteger[100][100];
		for (int i = 0; i < 100; i++)
			for (int j = 0; j <= i; j++)
			{
				triangle[i][j] = Numbers.choose(i, j);
				if (triangle[i][j].mod(seven).compareTo(zero) == 0)
					ct++;
			}

		for (int i = 0; i < 100; i++)
		{
			StringBuffer row = new StringBuffer();
			for (int j = 0; j <= i; j++)
			{
				if (triangle[i][j].mod(seven).compareTo(zero) == 0)
					row.append("0 ");
				else
					row.append("1 ");
			}
			String s = spacing(99-i);
			String r = row.toString();
			r = s + r;
			System.out.println(r);
		}

		System.out.println("\n" + ((rows * rows + rows) / 2 - ct) + " / "
				+ (rows * rows + rows) / 2 + " not divisible by 7.");

		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime)
				+ " ms to compile.");
	}

}
