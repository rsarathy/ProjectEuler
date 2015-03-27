
public class Problem065
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		String s = "6963524437876961749120273824619538346438023188214475670667";
		int digitSum = 0;
		for ( int i = 0; i < s.length(); i++ )
			digitSum += Character.getNumericValue(s.charAt(i));
		System.out.println(digitSum);

		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
