package Problem102;

public class Point
{
	public int x, y, z;
	
	public Point(int abscissa, int ordinate, int azimuth)
	{
		this.x = abscissa;
		this.y = ordinate;
		this.z = azimuth;
	}
	
	public String toString()
	{
		return "(" + this.x + "," + this.y + "," + this.z + ")";
	}
	
}
