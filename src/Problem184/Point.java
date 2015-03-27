package Problem184;

public class Point
{
	public int x, y, z;
	
	public Point(int abscissa, int ordinate, int azimuth)
	{
		this.x = abscissa;
		this.y = ordinate;
		this.z = azimuth;
	}
	
	public Point(int abscissa, int ordinate)
	{
		this.x = abscissa;
		this.y = ordinate;
		this.z = 0;
	}
	
	public boolean equals(Point other)
	{
		return this.x == other.x && this.y == other.y && this.z == other.z;
	}
	
	public String toString()
	{
		return "(" + this.x + "," + this.y + "," + this.z + ")";
	}
	
}
