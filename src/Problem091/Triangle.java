package Problem091;

public class Triangle
{
	public Point A,B,C;
	
	public Triangle(Point myA, Point myB, Point myC)
	{
		this.A = new Point(myA.x,myA.y,myA.z);
		this.B = new Point(myB.x,myB.y,myB.z);
		this.C = new Point(myC.x,myC.y,myC.z);
	}
	
	public boolean right()
	{	
		Vector AB = Vector.twoPt(this.A, this.B);
		Vector BC = Vector.twoPt(this.B, this.C);
		Vector CA = Vector.twoPt(this.C, this.A);
		
		int ABdotBC = Vector.dotProduct(AB, BC);
		int BCdotCA = Vector.dotProduct(BC, CA);
		int CAdotAB = Vector.dotProduct(CA, AB);
		
		return ABdotBC == 0 || BCdotCA == 0 || CAdotAB == 0;
	}
	
	public boolean degenerate()
	{
		if ( this.A.equals(this.B) ) return true;
		if ( this.A.equals(this.C) ) return true;
		if ( this.B.equals(this.C) ) return true;
		
		double A_x = this.A.x;
		double A_y = this.A.y;
		
		double B_x = this.B.x;
		double B_y = this.B.y;
		
		double C_x = this.C.x;
		double C_y = this.C.y;
		
		double slopeAB = (B_y - A_y) / (B_x - A_x);
		double slopeBC = (C_y - B_y) / (C_x - B_x);
		
		return slopeAB == slopeBC;
	}
	
	public String toString()
	{
		String a = "(" + this.A.x + "," + this.A.y + ")";
		String b = "(" + this.B.x + "," + this.B.y + ")";
		String c = "(" + this.C.x + "," + this.C.y + ")";
		
		return a + "," + b + "," + c;
	}
}
