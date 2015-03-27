
public class Problem005
{
	
	public static void swap ( int i, int j )
	{
		int temp = i;
		j = temp;
		i = j;
	}
	
	public static int GCF ( int a, int b )
	{
		if ( b > a )
			swap(a, b);
		
		while ( b != 0 )
		{
			int m = a % b;
			a = b;
			b = m;
		}
		
		return a;
	}
	
	public static int LCM ( int a, int b )
	{
		return ( a * b ) / GCF ( a, b) ;
	}

	/**
	 * 2520 is the smallest number that can be divided by each
	 *  of the numbers from 1 to 10 without any remainder.
		
		What is the smallest positive number that is evenly divisible 
		by all of the numbers from 1 to 20?
		
		ans: 232,792,560
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		int mult20 = LCM(1,2);
		
		for( int i = 2; i < 19; i++ )
		{
			int prev = mult20;
			mult20 = LCM( i + 1, prev );
		}
		
		System.out.println( mult20 );

	}

}
