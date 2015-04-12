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

		int rows = 344;
		int ct = 0;

		BigInteger[][] triangle = new BigInteger[rows][rows];

		for (int i = 0; i < rows; i++)
		{
			StringBuffer row = new StringBuffer();
			for (int j = 0; j <= i; j++)
			{
				triangle[i][j] = Numbers.choose(i, j);
				if (triangle[i][j].mod(seven).compareTo(zero) == 0)
				{
					row.append("0 ");
					ct++;
				}
				else
					row.append("1 ");
			}
			String s = spacing(rows-i-1);
			String r = row.toString();
			r = s + r;
			System.out.println(r);
		}

		int triSize = (rows * rows + rows) / 2;
		System.out.println("\n" + (triSize - ct) + " / " 
				+ triSize + " not divisible by 7.");

		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime)
				+ " ms to compile.");
	}

}
