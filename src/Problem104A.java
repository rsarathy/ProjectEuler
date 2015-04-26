import java.util.Arrays;

public class Problem104A
{
	final static String pandigital = "123456789";
	
	static boolean isPandigital(String s)
	{
		return isPermutation(pandigital, s);
	}
	
	static boolean isPermutation(String str1, String str2)
	{
		if (str1.length() != str2.length())
			return false;

		char[] a = str1.toCharArray();
		char[] b = str2.toCharArray();

		Arrays.sort(a);
		Arrays.sort(b);

		return Arrays.equals(a, b);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		
		long f_1 = 1, f_2 = 1, f_n;
		
		long tailCut = (long)Math.pow(10, 9);
		
		int n = 2;
		
		boolean superPan = false;
		
		while ( !superPan )
		{
			n++;
			f_n = (f_1 + f_2) % tailCut;
			f_2 = f_1;
			f_1 = f_n;
			
			if ( isPandigital(f_n + "") )
			{
				double t = (n * 0.20898764024997873 - 0.3494850021680094);
				long front = (long)Math.pow(10, t - (long)t + 8);
				if ( isPandigital(front + "") )
					superPan = true;
			}
		}
		
		System.out.println("F_" + n + " is super pandigital.");
		
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}
}
