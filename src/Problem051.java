
public class Problem051
{

	/**
	 * 4 digits removed: {0,4,8,12,16,20,24,28,32,36}
	 * 	4d residue mod 3: {0,1,2,0,1,2,0,1,2,0}
	 * 	2d residue mod 3: {0,2,1,0,2,1,0,2,1,0}
	 * 	3d residue mod 3: {0,0,0,0,0,0,0,0,0,0}
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		//5___3
		int[] primeFam = new int[8];
		
		for ( int i = 100; i <= 999; i++ )
		{
			//1___1, 9___9
			String num = i + "";
			int a = Integer.parseInt(num.substring(0,1));
			int b = Integer.parseInt(num.substring(1,2));
			int c = Integer.parseInt(num.substring(2,3));
			
			String family = "A"+a+"A"+b+"A"+c;
			
			int ct = 0;
			for ( int j = 0; j <= 9; j++ )
			{
				String temp = j + "";
				char digit = temp.charAt(0);
				String s = family.replace('A', digit);
				int p = Integer.parseInt(s);
				if ( Numbers.isPrime(p) )
					ct++;
			}
			if ( ct == 8 )
			{
				System.out.println(family); //A2A3A3
				break;
			}
		}
		
		System.out.println(Numbers.isPrime(121313));
				
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
