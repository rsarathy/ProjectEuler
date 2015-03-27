package Problem102;

public class Problem102
{
	
	public static boolean inTriangle(Point A, Point B, Point C, Point P)
	{
		Vector AB = Vector.twoPt(A,B);
		Vector BC = Vector.twoPt(B,C);
		Vector CA = Vector.twoPt(C,A);
		
		Vector AP = Vector.twoPt(A,P);
		Vector BP = Vector.twoPt(B,P);
		Vector CP = Vector.twoPt(C,P);
		
		Vector crossP = Vector.crossProduct(AB, AP);
		Vector crossQ = Vector.crossProduct(BC, BP);
		Vector crossR = Vector.crossProduct(CA, CP);
		
		int cPz = crossP.z;
		int cQz = crossQ.z;
		int cRz = crossR.z;
		
		return Math.signum(cPz) == Math.signum(cQz)
				&& Math.signum(cQz) == Math.signum(cRz);
		

//		Create 3d vectors AB, BC, CA with z=0 (this has to be done only once per triangle)
//		Create 3d vectors AP, BP, CP with z=0 (this has to be done once per point P)
//		Calculate p=ABxAP, q=BCxBP and r=CAxCP (this has to be done once per point P)
//		Your point is inside the triangle, if p,q and r have the same sign on their z coordinates
	}
	

	/**
	 * Find all triangles that contain the origin.
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		TextIO.readFile("p102_triangles.txt");
		
		String[][] coords = new String[1000][6];
		
		for ( int i = 0; i < coords.length; i++ )
			coords[i] = TextIO.getln().split(",");
		
		int[][] coordsA = new int[1000][2];
		int[][] coordsB = new int[1000][2];
		int[][] coordsC = new int[1000][2];
		
		Point[] pointA = new Point[1000];
		Point[] pointB = new Point[1000];
		Point[] pointC = new Point[1000];
		
		for ( int k = 0; k < coords.length; k++ )
			for ( int m = 0; m < coordsA[0].length; m++ )
			{
				coordsA[k][m] = Integer.parseInt(coords[k][m]);
				coordsB[k][m] = Integer.parseInt(coords[k][m + 2]);
				coordsC[k][m] = Integer.parseInt(coords[k][m + 4]);
			}
		
		int origins = 0;
		Point origin = new Point(0,0,0);
		
		for ( int i = 0; i < 1000; i++ )
		{
			pointA[i] = new Point(coordsA[i][0], coordsA[i][1], 0);
			pointB[i] = new Point(coordsB[i][0], coordsB[i][1], 0);		
			pointC[i] = new Point(coordsC[i][0], coordsC[i][1], 0);	
			boolean originInside = inTriangle(pointA[i], pointB[i], pointC[i], origin);
			if(originInside)
				origins++;
		}
				
		System.out.println("Number of triangles containing the origin: " + origins);
		
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
