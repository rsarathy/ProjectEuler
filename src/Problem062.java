import java.util.Arrays;

public class Problem062
{
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

		long[] cubes = new long[10000];
		for ( long i = 1; i < cubes.length; i++ )
			cubes[(int)i] = i*i*i;
		
		for ( int j = 10; j < cubes.length; j++ )
		{
			int cPermct = 0;
			for ( int k = j; k < cubes.length; k++ )
				if ( isPermutation(cubes[j]+"", cubes[k]+"") )
					cPermct++;
			if ( cPermct == 5 )
			{
				System.out.println(j + "^3 = " + cubes[j]);
				break;
			}
		}
		
		//5027 is the smallest number whose cube permutes 5 ways
		
//		long sol = 5027*5027*5027;
//		System.out.println(sol+"^3 = " + sol);
//		for ( long x = 5028; x < 10000; x++ )
//		{
//			long xCube = x*x*x;
//			if ( isPermutation(sol+"", xCube+"") )
//				System.out.println(x+"^3 = " + xCube);
//		}
		
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
