import java.math.BigInteger;
import java.util.ArrayList;

public class Problem064
{
	static ArrayList<Integer> continuedFrac(int n)
	{
		ArrayList<Integer> fracs = new ArrayList<Integer>();
		double sqrt = Math.sqrt(n);
		for ( int i = 0; i < 100; i++ )
		{
			int fr = (int)sqrt / 1;
			sqrt -= fr;
			sqrt = 1.0/sqrt;
			fracs.add(fr);
		}
		
		return fracs;
	}
	
	@SuppressWarnings("unused for this problem")
	private BigInteger writeCF(int f, int[] period, int n)
	{
		BigInteger num, denom, temp;
		num = BigInteger.ONE;
		denom = BigInteger.valueOf(period[(n - 1) % period.length]);
		for (int i = n - 2; i >= 0; i--)
		{
			num = num.add(BigInteger.valueOf(period[i % period.length])
					.multiply(denom));
			temp = num;
			num = denom;
			denom = temp;
		}
		num = num.add(denom.multiply(BigInteger.valueOf(f)));
		System.out.println("Convergent " + n + ": " + num + " / " + denom);
		return num;
	}
    
	private static int[] CFPeriod(int i)
	{
		int[] terms = new int[500];
		int nS = (int)Math.sqrt(i);
		System.out.print("sqrt(" + i + ") = [" + nS + "; ");
		int a, b, c, d, e;
		a = 1;
		b = nS; // the fraction is a/(sqrt(i) - b)
		int startA = a;
		int startB = b;
		int gcd, nTerms;
		nTerms = 0;
		double sqrtI = Math.sqrt(i);
		do
		{
			c = i - b * b; // fraction is now (a*(sqrt(i) + b))/c
			gcd = Numbers.GCF(a, c);
			a /= gcd;
			c /= gcd;
			d = (int) (a * (sqrtI + b) / c);
			e = d * c / a - b;
			a = c;
			b = e;
			terms[nTerms++] = d;
			if (nTerms == 1)
				System.out.print("(");
			else
				System.out.print(", ");
			System.out.print(d);
		} while (!(a == startA && b == startB));
		System.out.println(")]");
		int[] termsFit = new int[nTerms];
		for (int j = 0; j < termsFit.length; j++)
			termsFit[j] = terms[j];
		return termsFit;
	}
	
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		int oddPeriodCt = 0;
		for (int i = 2; i <= 10000; i++)
		{
			if (Numbers.isSquare(i))
				continue;
			if (CFPeriod(i).length % 2 == 1)
				oddPeriodCt++;
		}

		System.out.println("\nNumber of continued fractions with odd period length: "
						+ oddPeriodCt);

		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime)
				+ " ms to compile.");

	}
}
