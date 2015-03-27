package Problem165;

public class Problem165
{
	public static int[] BlumBlumShub(int n)
	{
		int[] pseudo = new int[n];
//		pseudo[0] = 290797;
		long s_i = 290797;
		for ( int i = 1; i < n; i++ )
		{	
			long s_iPlus1 = (s_i*s_i) % 50515093;
			int t_i = (int)s_iPlus1 % 500;
			pseudo[i] = t_i;
			s_i = s_iPlus1;
		}
		
		return pseudo;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		final int N = 5000;
		int[] blub = BlumBlumShub(4*N+1);
		Point[][] coords = new Point[N][2];
		for ( int i = 1; i <= 4*N - 3; i += 4 )
		{
			int x1 = blub[i];
			int y1 = blub[i+1];
			int x2 = blub[i+2];
			int y2 = blub[i+3];
			
			coords[(i-1)/4][0] = new Point(x1,y1);
			coords[(i-1)/4][1] = new Point(x2,y2);
		}
		
		Point A = new Point(27,44);
		Point B = new Point(12,32);
		LineSegment AB = new LineSegment(A,B);
		Point F = new Point(22,40);
		System.out.println(AB.onLine(F));

		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
