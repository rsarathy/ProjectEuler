package Problem091;

public class Problem091
{
	/**
	 * 0 ≤ x1, y1, x2, y2 ≤ 50 --> 14234 triangles.
	 * 0 ≤ x1, y1, x2, y2 ≤ 2  --> 14 triangles.
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		int ct = 0;
		Point O = new Point(0,0);
		for ( int x1 = 0; x1 <= 50; x1++ )
			for ( int y1 = 0; y1 <= 50; y1++ )
				for ( int x2 = 0; x2 <= 50; x2++ )
					for ( int y2 = 0; y2 <= 50; y2++ )
					{
						Point P = new Point(x1,y1);
						Point Q = new Point(x2,y2);
						Triangle OPQ = new Triangle(O,P,Q);
						if ( OPQ.right() && !OPQ.degenerate() )
							ct++;
					}
		System.out.println(ct/2);

		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
