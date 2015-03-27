package Problem184;

import java.util.ArrayList;

public class Problem184
{
	public static boolean inTriangle(Triangle ABC, Point P)
	{
		Point A = ABC.A;
		Point B = ABC.B;
		Point C = ABC.C;
		
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
	
	public static ArrayList<Point> createCoords(int r)
	{
		ArrayList<Point> coords = new ArrayList<Point>();
		for ( int x = 1-r; x < r; x++ )
			for ( int y = 1-r; y < r; y++ )
				if ( x*x + y*y < r*r )
					coords.add(new Point(x,y));
		return coords;
	}
	
	public static Triangle[] createTris(ArrayList<Point> coords)
	{
		int n = coords.size();
		Triangle[] tris = new Triangle[(n * (n - 1) * (n - 2))];
		
		int index = 0;
		for ( int a = 0; a < n; a++ )
			for ( int b = 0; b < n-1; b++ )
				for ( int c = 0; c < n-2; c++ )
				{
					Point A = coords.get(a);
					Point B = coords.get(b);
					Point C = coords.get(c);
					tris[index++] = new Triangle(A,B,C);
				}
		
		
		return tris;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		ArrayList<Point> coords = createCoords(2);
		System.out.println(coords.size());
		System.out.println(coords.get(0).toString());
		
		Triangle[] tri = createTris(coords);
		System.out.println(tri.length);
		Point origin = new Point(0,0);
		
		System.out.println();
		
		int ct = 0;
		for ( int i = 0; i < tri.length; i++ )
			if ( inTriangle(tri[i],origin) && !tri[i].degenerate() )
				System.out.println(tri[i].toString());
		System.out.println(ct);

		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
