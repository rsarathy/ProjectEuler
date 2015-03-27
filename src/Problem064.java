import java.util.ArrayList;

public class Problem064
{
	static ArrayList<Integer> continuedFrac(int n)
	{
		ArrayList<Integer> fracs = new ArrayList<Integer>();
		double sqrt = Math.sqrt(n);
		for ( int i = 0; i < 100; i++ )
		{
			int fr = (int)sqrt / 1;
			sqrt -= fr;
			sqrt = 1.0/sqrt;
			fracs.add(fr);
		}
		
		return fracs;
	}
	
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		

		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}
}
