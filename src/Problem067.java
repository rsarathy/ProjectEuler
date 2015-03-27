import java.util.Iterator;
import java.util.Vector;

public class Problem067
{

	/**
	 * Compute the maximum triangular sum.
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		
		TextIO.readFile("p067_triangle.txt");
		
		//integers need to be parsed from the large triangle.
		
		Vector v = new Vector();
		String[][] tri = new String[100][100];
		int[] arr = new int[(100 * 101) / 2 ];
		
		for ( int i = 0; i < tri.length; i++ )
		{
			String line = TextIO.getln();
			tri[i] = line.split(" ");
		}
		
		for ( int i = 0; i < tri.length; i++ )
		{
			for ( int j = 0; j < tri[i].length; j++ )
			{
				arr[(i * (i + 1) / 2) + j] = Integer.parseInt(tri[i][j]);
			}
		}
		
		
//		System.out.println(tri[3][2]); //the 9th number
//		System.out.println(arr[8]);
//		System.out.println(tri[4][3]); //the 14th number
//		System.out.println(arr[13]);
		
		int numCount = 1;
		int last = 0;
		int parentLeftIndex = -1;
		int parentRightIndex = -1;
		int parentLeftSum = 0;
		int parentRightSum = 0;
		int currentRow = 1;
		
		for (int i = 0; i < arr.length; i++)
		{
			// System.out.print(arr[i] + " ");
			parentLeftSum = 0;
			parentRightSum = 0;
			// special case for the first element
			if (i == 0)
			{
				parentLeftSum = arr[i];
				parentRightSum = arr[i];
			}
			// find parents
			parentLeftIndex = i - currentRow;
			if (parentLeftIndex >= 0 && parentLeftIndex != i && numCount > 1)
			{
				parentLeftSum = ((Integer) v.elementAt(parentLeftIndex))
						.intValue() + arr[i];
			}
			parentRightIndex = i - (currentRow - 1);
			if (parentRightIndex >= 0 && parentRightIndex != i
					&& (numCount != (last + 1)))
			{
				parentRightSum = ((Integer) v.elementAt(parentRightIndex))
						.intValue() + arr[i];
			}
			// System.out.print("("+ parentLeft+ "," + parentRightIndex + ":" +
			// parentRight + "," + parentLeftSum + "~" + parentRightSum + " " +
			// ") ");
			if (parentRightSum > parentLeftSum)
			{
				v.add(i, new Integer(parentRightSum));
			} else
			{
				v.add(i, new Integer(parentLeftSum));
			}
			// handle new rows
			if (numCount == (last + 1))
			{
				// System.out.println();
				currentRow++;
				last = numCount;
				numCount = 0;
			}
			numCount++;
		}

		Iterator it = v.iterator();
		int colCount = 1;
		int overallCount = 0;
		int largest = 0;
		int current = 0;
		last = 0;
		while (it.hasNext())
		{
			current = ((Integer) it.next()).intValue();
			if (current > largest)
			{
				largest = current;
			}
			// System.out.print(overallCount + ":" + current + " ");
			if (colCount == (last + 1))
			{
				// System.out.println();
				last = colCount;
				colCount = 0;
			}
			colCount++;
			overallCount++;
		}
		System.out.println("largest: " + largest);

		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime)
				+ " ms to compile.");

	}

}
