import java.util.Scanner;


public class Problem020
{

	/**
	 * Calculate the sum of digits of 100!
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		 int sum = 0;
         System.out.println("Enter number:");
         Scanner input = new Scanner(System.in);
         int n = input.nextInt();
         int t = n;
         while (n > 0)
         {
        	 int p = n % 10;
             sum += p;
             n /= 10;
         }
         System.out.println("sum of the digits in " + t + " is " + sum);

	}

}

//import java.math.BigInteger;
//public class euler_20
//{
//  public static void main(String[] args)
//  {
//    BigInteger num = new BigInteger("1");
//    for(int i = 100; i>1; i--)
//    {
//      num = num.multiply(new BigInteger(String.valueOf(i)));
//    }
//    System.out.println(num);
//    String stringOfNum = num.toString();
//    int sum = 0;
//    System.out.println(stringOfNum);
//    for(int i = 0; i<stringOfNum.length(); i++)
//    {
//      sum += Character.getNumericValue(stringOfNum.charAt(i));
//    }
//    System.out.println(sum);
//  }
//}
