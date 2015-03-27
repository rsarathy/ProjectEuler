
public class Problem089
{
	public static int roman(String s)
	{
		int sum = 0;
		s = s.replace("IV", "P"); //IV = 4
		s = s.replace("IX", "Q"); //IX = 9
		s = s.replace("XL", "R"); //XL = 40;
		s = s.replace("XC", "S"); //XC = 90;
		s = s.replace("CD", "T"); //CD = 400;
		s = s.replace("CM", "U"); //CM = 900;
		
		for ( int i = 0; i < s.length(); i++ )
		{
			switch(s.charAt(i))
			{
				case 'M': sum += 1000;
					break;
				case 'U': sum += 900;
					break;
				case 'D': sum += 500;
					break;
				case 'T': sum += 400;
					break;
				case 'C': sum += 100;
					break;
				case 'S': sum += 90;
					break;
				case 'L': sum += 50;
					break;
				case 'R': sum += 40;
					break;
				case 'X': sum += 10;
					break;
				case 'Q': sum += 9;
					break;
				case 'V': sum += 5;
					break;
				case 'P': sum += 4;
					break;
				case 'I': sum++;
					break;
			}
		}
		return sum;
	}
	
	public static String optimize(int r)
	{
		String optimal = "";
		while ( r > 0 )
		{
			if ( r >= 1000 )
			{
				optimal += 'M';
				r -= 1000;
				continue;
			}
			if ( r >= 900 )
			{
				optimal += "CM";
				r -= 900;
				continue;
			}
			if ( r >= 500 )
			{
				optimal += 'D';
				r -= 500;
				continue;
			}
			if ( r >= 400 )
			{
				optimal += "CD";
				r -= 400;
				continue;
			}
			if ( r >= 100 )
			{
				optimal += 'C';
				r -= 100;
				continue;
			}
			if ( r >= 90 )
			{
				optimal += "XC";
				r -= 90;
				continue;
			}
			if ( r >= 50 )
			{
				optimal += 'L';
				r -= 50;
				continue;
			}
			if ( r >= 40 )
			{
				optimal += "XL";
				r -= 40;
				continue;
			}
			if ( r >= 10 )
			{
				optimal += 'X';
				r -= 10;
				continue;
			}
			if ( r >= 9 )
			{
				optimal += "IX";
				r -= 9;
				continue;
			}
			if ( r >= 5 )
			{
				optimal += 'V';
				r -= 5;
				continue;
			}
			if ( r >= 4 )
			{
				optimal += "IV";
				r -= 4;
				continue;
			}
			if ( r >= 1 )
			{
				optimal += 'I';
				r--;
				continue;
			}
		}
		return optimal;
	}
	
//	public static int savedChars(String s)
//	{
//		int init = s.length();
//		s = s.replace("IIII", "IV"); //IV = 4
//		s = s.replace("VIIII", "IX"); //IX = 9
//		s = s.replace("XXXX", "XL"); //XL = 40;
//		s = s.replace("LXXXX", "XC"); //XC = 90;
//		s = s.replace("CCCC", "CD"); //CD = 400;
//		s = s.replace("DCCCC", "CM");
//		int fin = s.length();
//		return fin - init;
//	}
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		
		TextIO.readFile("p089_roman.txt");
		int[] roman = new int[1000];
		int saved = 0;
		for ( int i = 0; i < 1000; i++ )
		{
			String r = TextIO.getln();
			int orig = r.length();
			roman[i] = roman(r);
			
			int opti = optimize(roman[i]).length();
			int dif = orig - opti;
			saved += (dif);
		}
		
		System.out.println("Saved characters: " + saved);
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
