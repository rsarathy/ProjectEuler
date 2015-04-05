import java.util.ArrayList;

public class Problem061A
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
	
	public static void findCycle(int start)
	{
		//2016 ---> tr_34 = 20, nextB = 1
		
		int tr_34 = start % 100;
		int nextB = tr_34 / 10;
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{	
		long startTime = System.currentTimeMillis();

		ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> square = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> pentagon = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> hexagon = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> heptagon = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> octagon = new ArrayList<ArrayList<Integer>>();
		
		for ( int i = 0; i <= 9; i++ )
		{
			ArrayList<Integer> tbucket = new ArrayList<Integer>();
			ArrayList<Integer> sbucket = new ArrayList<Integer>();
			ArrayList<Integer> pbucket = new ArrayList<Integer>();
			ArrayList<Integer> hxbucket = new ArrayList<Integer>();
			ArrayList<Integer> hepbucket = new ArrayList<Integer>();
			ArrayList<Integer> obucket = new ArrayList<Integer>();
			triangle.add(tbucket);
			square.add(sbucket);
			pentagon.add(pbucket);
			hexagon.add(hxbucket);
			heptagon.add(hepbucket);
			octagon.add(obucket);
		}
		
		for ( int i = 15; i < 141; i++ )
		{
			int tri = (i*(i+1))/2;
			int sq = i*i;
			int pent = (i*(3*i-1))/2;
			int hex = i*(2*i-1);
			int hept = (i*(5*i-3))/2;
			int oct = i*(3*i-2);
			
			int triB = (tri / 1000);
			int sqB = (sq / 1000);
			int pentB = (pent / 1000);
			int hexB = (hex / 1000);
			int heptB = (hept / 1000);
			int octB = (oct / 1000);
			
			if ( bounds(tri) ) triangle.get(triB).add(tri);
			if ( bounds(sq) ) square.get(sqB).add(sq);
			if ( bounds(pent) ) pentagon.get(pentB).add(pent);
			if ( bounds(hex) ) hexagon.get(hexB).add(hex); 
			if ( bounds(hept) ) heptagon.get(heptB).add(hept);
			if ( bounds(oct) ) octagon.get(octB).add(oct);
		}
		
//		for ( int i = 0; i < triangle.size(); i++ )
//		{
//			for ( int j = 0; j < triangle.get(i).size(); j++ )
//			{
//				int tr_34 = triangle.get(i).get(j) % 100;
//				int nextB = tr_34 / 10;
//				
//				for ( int k = 0; k < square.get(nextB).size(); k++ )
//				{
//					
//				}
//			}
//		}
		
		print(triangle.get(2));
		print(square.get(2));
		System.out.println(triangle.get(2).size());
		System.out.println(square.get(2).size());
		
		System.out.println();
		
		for ( int i = 1; i <= 9; i++ )
		{
			System.out.print("tri(" + i + ") = " + triangle.get(i).size() + ", ");
			System.out.print("sq(" + i + ") = "+ square.get(i).size() + ", ");
			System.out.print("pent(" + i + ") = " + pentagon.get(i).size() + ", ");
			System.out.print("hex(" + i + ") = " + hexagon.get(i).size() + ", ");
			System.out.print("hept(" + i + ") = " + heptagon.get(i).size() + ", ");
			System.out.print("oct(" + i + ") = " + octagon.get(i).size());
			System.out.println();
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 
	}

}
