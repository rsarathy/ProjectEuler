public class Radical
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
		return "(" + this.n +"," + this.rad + ")";
	}
	
	public int compareTo(Radical other)
	{
		if ( this.rad < other.rad )
			return -1;
		else if ( this.rad > other.rad )
			return -1;
		else
			return this.n < other.n ? -1 : 1;
	}
	
	public static Radical[] quickSort(Radical[] radArr)
	{
		return quickSort(radArr, 0, radArr.length - 1);
	}
	
	public static Radical[] quickSort(Radical[] radArr, int p, int r)
	{
		if (p < r)
		{
			int q = partition(radArr, p, r);
			quickSort(radArr, p, q);
			quickSort(radArr, q + 1, r);
		}

		return radArr;
	}

	private static int partition(Radical[] radArr, int p, int r)
	{

		Radical x = radArr[p];
		int i = p - 1;
		int j = r + 1;

		while (true)
		{
			i++;
			while (i < r && radArr[i].compareTo(x) < 0)
				i++;
			j--;
			while (j > p && radArr[j].compareTo(x) > 0)
				j--;

			if (i < j)
				swap(radArr, i, j);
			else
				return j;
		}
	}

	private static void swap(Radical[] radArr, int i, int j)
	{
		Radical temp = new Radical(radArr[i]);
		radArr[i] = new Radical(radArr[j]);
		radArr[j] = new Radical(temp);
	}
	
}
