import java.util.ArrayList;

public class Problem068
{
	public static ArrayList<String> permutations = new ArrayList<String>();

	public static void permute(String prefix, String s)
	{
		int n = s.length();

		if (n == 0)
			permutations.add(prefix);
		else
			for (int i = 0; i < n; i++)
				permute(prefix + s.charAt(i),
						s.substring(0, i) + s.substring(i + 1, n));
	}

	private static void permute(String s)
	{
		permute("", s);
	}
	
	public static int toInt(int a, int b, int c)
	{
		return Integer.parseInt(a+""+b+""+c);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		final long ub = (long)Math.pow(10, 16);

		//(f,a,b)
		//(g,b,c)
		//(h,c,d)
		//(i,d,e)
		//(j,e,a)
		
		int[] abc = new int[10];

		permute("0123456789");
		System.out.println("Done creating permutations.");
		long maxConcat = 0L;

		for ( int i = 0; i < permutations.size(); i++)
		{
			String perm = permutations.get(i);
			for ( int j = 0; j < abc.length; j++ )
			{
				int temp = Character.getNumericValue(perm.charAt(j));
				if ( temp == 0 ) abc[j] = 10;
				else abc[j] = temp;
			}
			int fab = abc[5] + abc[0] + abc[1];
			int gbc = abc[6] + abc[1] + abc[2];
			int hcd = abc[7] + abc[2] + abc[3];
			int ide = abc[8] + abc[3] + abc[4];
			int jea = abc[9] + abc[4] + abc[0];
			
			if ( fab == gbc && gbc == hcd && hcd == ide && ide == jea )
			{
				int FAB = toInt(abc[5],abc[0],abc[1]);
				int GBC = toInt(abc[6],abc[1],abc[2]);
				int HCD = toInt(abc[7],abc[2],abc[3]);
				int IDE = toInt(abc[8],abc[3],abc[4]);
				int JEA = toInt(abc[9],abc[4],abc[0]);
				
				int min = Math.min(Math.min(FAB,GBC),Math.min(HCD,Math.min(IDE,JEA)));
				long str = 0L;
				if ( min == FAB )
					str = Long.parseLong(FAB + "" + GBC + "" + HCD + "" + IDE + "" + JEA);
				if ( min == GBC )
					str = Long.parseLong(GBC + "" + HCD + "" + IDE + "" + JEA + "" + FAB);
				if ( min == HCD )
					str = Long.parseLong(HCD + "" + IDE + "" + JEA + "" + FAB + "" + GBC);
				if ( min == IDE )
					str = Long.parseLong(IDE + "" + JEA + "" + FAB + "" + GBC + "" + HCD);
				if ( min == JEA )
					str = Long.parseLong(JEA + "" + FAB + "" + GBC + "" + HCD + "" + IDE);
				
				if ( str < ub )
					maxConcat = Math.max(str, maxConcat);
			}
		}
		
		System.out.println(maxConcat);

		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
