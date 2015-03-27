import java.util.*;

public class RadixSort
{
	static int[] radixSort(int[] arr)
	{
		// Bucket is only used in this method, so I declare it here
		// I'm not 100% sure I recommend doing this in production code
		// but it turns out, it's perfectly legal to do!
		class Bucket
		{
			private List<Integer> list = new LinkedList<Integer>();
			int[] sorted;

			public void add(int i)
			{
				list.add(i);
				sorted = null;
			}

			public int[] getSortedArray()
			{
				if (sorted == null)
				{
					sorted = new int[list.size()];
					int i = 0;
					for (Integer val : list)
					{
						sorted[i++] = val.intValue(); // probably could autobox,
														// oh well
					}
					Arrays.sort(sorted); // use whatever method you want to sort
											// here...
											// Arrays.sort probably isn't
											// allowed
				}
				return sorted;
			}
		}

		int maxLen = 0;
		for (int i : arr)
		{
			if (i < 0)
				throw new IllegalArgumentException(
						"I don't deal with negative numbers");
			int len = numKeys(i);
			if (len > maxLen)
				maxLen = len;
		}

		Bucket[] buckets = new Bucket[maxLen];

		for (int i = 0; i < buckets.length; i++)
			buckets[i] = new Bucket();
		for (int i : arr)
			buckets[numKeys(i) - 1].add(i);

		int[] result = new int[arr.length];
		int[] posarr = new int[buckets.length]; // all int to 0

		for (int i = 0; i < result.length; i++)
		{
			// get the 'best' element, which will be the most appropriate from
			// the set of earliest unused elements from each bucket
			int best = -1;
			int bestpos = -1;
			for (int p = 0; p < posarr.length; p++)
			{
				if (posarr[p] == buckets[p].getSortedArray().length)
					continue;
				int oldbest = best;
				best = bestOf(best, buckets[p].getSortedArray()[posarr[p]]);
				if (best != oldbest)
				{
					bestpos = p;
				}

			}
			posarr[bestpos]++;
			result[i] = best;
		}

		return result;

	}

	static int bestOf(int a, int b)
	{
		if (a == -1)
			return b;
		// you'll have to write this yourself :)
		String as = a + "";
		String bs = b + "";
		if (as.compareTo(bs) < 0)
			return a;
		return b;
	}

	static int numKeys(int i)
	{
		if (i < 0)
			throw new IllegalArgumentException(
					"I don't deal with negative numbers");
		if (i == 0)
			return 1;
		// return (i+"").length(); // lame method :}
		int len = 0;
		while (i > 0)
		{
			len++;
			i /= 10;
		}
		return len;
	}
}