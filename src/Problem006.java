public class Problem006
{

	public static int sumOfSquares(int n)
	{
		return ( n * (n + 1) * (2 * n + 1) ) / 6;
	}
	
	public static int squareOfSum(int n)
	{
		int tri = (n * n + n) / 2;
		
		return tri * tri;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		System.out.println(sumOfSquares(100));
		System.out.println(squareOfSum(100));
		
		System.out.println( squareOfSum(100) - sumOfSquares(100) );

	}

}
