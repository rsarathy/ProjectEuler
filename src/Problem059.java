public class Problem059
{
	public static boolean acceptableXOR(int x)
	{
		return (x >= 32 && x <= 126);
	}
	
	public static int[] message(int[] msg, int a, int b, int c)
	{
		int[] newMsg = new int[msg.length];
		for ( int i = 0; i < msg.length; i++ )
		{
			if ( i % 3 == 0 ) newMsg[i] = msg[i] ^ a;
			else if ( i % 3 == 1 ) newMsg[i] = msg[i] ^ b;
			else newMsg[i] = msg[i] ^ c;
		}
		return newMsg;
	}

	/**
	 * Find the three-character ASCII key.
	 * 
		a = 102, b = 108, c = 100
		a = 102, b = 110, c = 100
		a = 102, b = 111, c = 100
		a = 103, b = 108, c = 100
		a = 103, b = 110, c = 100
		a = 103, b = 111, c = 100
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		TextIO.readFile("p059_cipher.txt");
		
		String[] arr = TextIO.getln().split(",");
		int[] mesg = new int[arr.length];
		
		for ( int i = 0; i < arr.length; i++ )
			mesg[i] = Integer.parseInt(arr[i]);
		
//		int a = 103;
//			for ( int b = 97; b <= 122; b++ )
//				for ( int c = 97; c <= 122; c++ )
//				{
//					boolean isGud = true;
//					for ( int i = 0; i < mesg.length; i++ )
//					{
//						int xor;
//						
//						if ( i % 3 == 0 ) xor = mesg[i] ^ a;
//						else if ( i % 3 == 1 ) xor = mesg[i] ^ b;
//						else xor = mesg[i] ^ c;
//						
//						if ( !acceptableXOR(xor) )
//							isGud = false;
//					}
//					if ( isGud )
//						System.out.println("a = " + a + ", b = " + b + ", c = " + c);
//				}
		
		int[] msg = message(mesg,103,111,100);
		int sum = 0;
		for ( int i = 0; i < msg.length; i++ )
			sum += msg[i];
		System.out.println(sum);
		
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
