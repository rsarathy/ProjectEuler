import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Problem061
{
	public static boolean bounds(int n)
	{
		return n >= 1000 && n < 10000 && n % 100 >= 10;
	}
	
	public static void print(ArrayList<Integer> list)
	{
		for ( int i = 0; i < list.size(); i++ )
			System.out.print(list.get(i) + ", " );
		System.out.println();
	}
	
	public static Integer[] getDistinct(int[] input)
	{
		Set<Integer> distinct = new HashSet<Integer>();
		for ( Integer element : input)
			distinct.add(element);
		return distinct.toArray(new Integer[0]);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		//n(n+1)/2 < 10,000
		//n^2 < 10000 --> n = 32,...,99
		//n(3n-1)/2 < 10,000 --> n = 
		//n(2n-1) < 10,000 --> n =
		//n(5n-3)/2 < 10,000 --> n = 
		//n(3n-2) < 10,000 --> n =
		
		ArrayList<Integer> triangle = new ArrayList<Integer>();  //96, 88 reduced
		ArrayList<Integer> square = new ArrayList<Integer>();	 //68, 53 reduced
		ArrayList<Integer> pentagonal = new ArrayList<Integer>();//56, 47 reduced
		ArrayList<Integer> hexagonal = new ArrayList<Integer>(); //48, 44 reduced
		ArrayList<Integer> heptagonal = new ArrayList<Integer>();//43, 40 reduced
		ArrayList<Integer> octagonal = new ArrayList<Integer>(); //40, 30 reduced
		
		for ( int i = 1; i < 141; i++ )
		{
			int tri = (i*(i+1))/2;
			int sq = i*i;
			int pent = (i*(3*i-1))/2;
			int hex = i*(2*i-1);
			int hept = (i*(5*i-3))/2;
			int oct = i*(3*i-2);
			
			if ( bounds(tri) ) triangle.add(tri);
			if ( bounds(sq) ) square.add(sq);
			if ( bounds(pent) ) pentagonal.add(pent);
			if ( bounds(hex) ) hexagonal.add(hex);
			if ( bounds(hept) ) heptagonal.add(hept);
			if ( bounds(oct) ) octagonal.add(oct);
		}

//		System.out.println(triangle.size());
//		System.out.println(square.size());
//		System.out.println(pentagonal.size());
//		System.out.println(hexagonal.size());
//		System.out.println(heptagonal.size());
//		System.out.println(octagonal.size());
		
		for ( int i = 0; i < triangle.size(); i++ )
		{
			int tr_12 = triangle.get(i) / 100;
			int tr_34 = triangle.get(i) % 100;

			for ( int j = 0; j < square.size(); j++ )
			{
				int sq_12 = square.get(j) / 100;
				int sq_34 = square.get(j) % 100;
				for ( int k = 0; k < pentagonal.size(); k++ )
				{
					int pn_12 = pentagonal.get(k) / 100;
					int pn_34 = pentagonal.get(k) % 100;
					
					int t = triangle.get(i);
					int s = square.get(j);
					int p = pentagonal.get(k);
					
					int[] cyclic = new int[6];
					
					cyclic[0] = tr_12;
					cyclic[1] = tr_34;
					
					cyclic[2] = sq_12;
					cyclic[3] = sq_34;
					
					cyclic[4] = pn_12;
					cyclic[5] = pn_34;
					
					boolean cyUneq = (tr_12 != sq_12) && (sq_12 != pn_12) && (tr_12 != pn_12)
							&& (tr_34 != sq_34) && (sq_34 != pn_34) && (tr_34 != pn_34);
					
					boolean uneq = (t != s) && (s != p) && (t != p);
					
					boolean isCyclic = getDistinct(cyclic).length == 3 && uneq && cyUneq;
					if ( isCyclic )
					{
						System.out.println(triangle.get(i) + ", " + square.get(j) + ", "
								+ pentagonal.get(k) );
					}
				}
			}
		}
		
//		print(triangle);
//		print(square);
//		print(pentagonal);
//		print(hexagonal);
//		print(heptagonal);
//		print(octagonal);
		
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 
	}

}
