package Problem102;

public class Vector
{
	public int x, y, z;
	
	public Vector(int abscissa, int ordinate, int azimuth)
	{
		this.x = abscissa;
		this.y = ordinate;
		this.z = azimuth;
	}
	
	public static Vector twoPt(Point p1, Point p2)
	{
		return new Vector(p2.x - p1.x, p2.y - p1.y, p2.z - p1.z);
	}
	
	public static Vector crossProduct(Vector u, Vector v)
	{
		int xcomp = u.y * v.z - u.z * v.y;
		int ycomp = u.x * v.z - u.z * v.x;
		int zcomp = u.x * v.y - u.y * v.x;
		
		return new Vector(xcomp, -ycomp, zcomp);
	}
	
	public static int dotProduct(Vector u, Vector v)
	{
		return u.x * v.x + u.y * v.y + u.z * v.z;
	}
	
	public String toString()
	{
//		String s = this.x + "i ";
//		
//		if ( this.y == 0 ) s.
		
		return this.x + "i + " + this.y + "j + " + this.z + "k";
	}
}
