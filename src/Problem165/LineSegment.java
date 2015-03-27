package Problem165;

public class LineSegment
{
	Point A;
	Point B;
	
	double slope;
	int x0, y0;
	String signY = "", signX = "";
	
	public LineSegment(Point myA, Point myB)
	{
		this.A = new Point(myA.x,myA.y);
		this.B = new Point(myB.x,myB.y);
		
		this.x0 = myA.x;
		this.y0 = myA.y;
		
		double deltaY = (double)(myB.y - myA.y);
		double deltaX = (double)(myB.x - myA.x);
		
		this.slope = deltaY / deltaX;
		
		int signY0 = (int)Math.signum(y0);
		int signX0 = (int)Math.signum(x0);
		
		switch(signY0)
		{
			case -1: signY = "+";
				break;
			case 0: signY = "";
				break;
			case 1: signY = "-";
				break;
		}
		
		switch(signX0)
		{
			case -1: signX = "+";
				break;
			case 0: signX = "";
				break;
			case 1: signX = "-";
				break;
		}
	
//		String m = String.format("%.2f", this.slope);
//		this.slope = Double.parseDouble(m);
	}
	
	public boolean onLine(Point P)
	{
		double rhs = P.y - y0;
		double lhs = slope*(P.x-x0);
		
		return rhs == lhs;
	}
	
	public String toString()
	{	
		String m = String.format("%.2f", this.slope);
			
		return "y " + signY + " " + this.y0 + " = " + 
		m + "(x" + " " + signX + " " + this.x0 + ")";
	}
}
