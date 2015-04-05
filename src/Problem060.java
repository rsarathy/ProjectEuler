import java.util.ArrayList;

public class Problem060
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		int[] primes = ESieve.generatePrimes(1000);
		System.out.println(primes.length);

		System.out.println("primes[0] = " + primes[0]);
		System.out.println("primes[1] = " + primes[1]);
		System.out.println("primes[2] = " + primes[2]);
		
		ArrayList<Integer> pSets = new ArrayList<Integer>();
		for ( int i = 0; i < primes.length; i++ )
			pSets.add(primes[i]);
		
		pSets.remove(0); //2 will generate evens
		pSets.remove(1); //5 will generate _5 which is divisible by 5
		
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
