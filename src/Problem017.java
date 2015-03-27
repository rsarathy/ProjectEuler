public class Problem017
{	
	public static String toString(int n)
	{
		String h = "", t = "", o = "";
		
		int hundreds = n / 100;
		int tens = (n - 100 * hundreds) / 10;
		int ones = (n - 100 * hundreds - 10 * tens);
		
		switch (hundreds)
		{
			case 0: h = "";
					break;
			case 1: h = "one";
					break;
			case 2: h = "two";
					break;
			case 3: h = "three";
					break;
			case 4: h = "four";
					break;
			case 5: h = "five";
					break;
			case 6: h = "six";
					break;
			case 7: h = "seven";
					break;
			case 8: h = "eight";
					break;
			case 9: h = "nine";
		}
		
		if ( hundreds != 0 ) h += "hundred";
		
		switch (tens)
		{
			case 0: t = "";
					break;
			case 1: t = "ten";
					break;
			case 2: t = "twenty";
					break;
			case 3: t = "thirty";
					break;
			case 4: t = "forty";
					break;
			case 5: t = "fifty";
					break;
			case 6: t = "sixty";
					break;
			case 7: t = "seventy";
					break;
			case 8: t = "eighty";
					break;
			case 9: t = "ninety";
		}
		
		if ( ( hundreds != 0 && tens != 0 ) || ( hundreds != 0 && ones != 0 )) 
			t = "and" + t;
		
		switch (ones)
		{
			case 0: o = "";
					break;
			case 1: o = "one";
					break;
			case 2: o = "two";
					break;
			case 3: o = "three";
					break;
			case 4: o = "four";
					break;
			case 5: o = "five";
					break;
			case 6: o = "six";
					break;
			case 7: o = "seven";
					break;
			case 8: o = "eight";
					break;
			case 9: o = "nine";
		}
		
		return h + t + o;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		
		int letters = 0;
		
		for ( int i = 1; i < 1000; i++ )
			letters += toString(i).length();

		System.out.println(toString(101)); //onehundredone vs. onehundredandone
		System.out.println(letters + 40 + "onethousand".length()); //4 * 10 for each of the "teens"
			
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 
	}

}
