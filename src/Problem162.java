public class Problem162
{
	static boolean goodHex(String str)
	{
		return str.contains("0") && str.contains("1") && str.contains("A");
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		int cap = (int)Math.pow(16, 5);
		
		int ct = 0;		
		for ( int i = 0; i < cap; i++ )
		{
			String s = Integer.toHexString(i).toUpperCase();
			if ( goodHex(s) )
				ct++;
		}
		
		System.out.println(ct);	
		
		//at most 3 digits: 4 (6ms)
		//at most 4 digits: 262 (47ms)
		//at most 5 digits: 10190 (194ms)
		//at most 6 digits: 309680 (2171ms)
		//at most 7 digits: 8133504 (34352ms)
		
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile.");
	}

}
