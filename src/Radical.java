public class Radical implements Comparable<Radical>
{
	int n, rad;

	public Radical(int en, int radic)
	{
		this.n = en;
		this.rad = radic;
	}

	public Radical(Radical other)
	{
		this.n = other.n;
		this.rad = other.rad;
	}

	public String toString()
	{
		return "(" + this.n + "," + this.rad + ")";
	}

	public int compareTo(Radical other)
	{
		if (this.rad < other.rad)
			return -1;
		else if (this.rad > other.rad)
			return 1;
		else
			return this.n < other.n ? -1 : 1;
	}
}