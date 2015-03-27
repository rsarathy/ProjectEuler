package Problem054;

public class Problem054
{
	final static int thousand = 1000;
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();

		TextIO.readFile("p054_poker.txt");
		
		String[][] hands = new String[thousand][10];
		String[][] player1 = new String[thousand][5];
		String[][] player2 = new String[thousand][5];
		Hand[] player1Hands = new Hand[thousand];
		Hand[] player2Hands = new Hand[thousand];
		
		for ( int i = 0; i < thousand; i++ )
			hands[i] = TextIO.getln().split(" ");
		
		int p1wins = 0, p2wins = 0;
		
		for ( int i = 0; i < thousand; i++ )
		{
			for ( int j = 0; j < 5; j++ )
			{
				player1[i][j] = hands[i][j];
				player2[i][j] = hands[i][j+5];
			}
			player1Hands[i] = new Hand(player1[i]);
			player2Hands[i] = new Hand(player2[i]);
			
			if ( player1Hands[i].compareTo(player2Hands[i]) == 1 ) p1wins++;
			if ( player1Hands[i].compareTo(player2Hands[i]) == -1 ) p2wins++;
		}
		
		System.out.println("Player 1 wins: " + p1wins);
		System.out.println("Player 2 wins: " + p2wins);
		
		long endTime = System.currentTimeMillis();
		System.out.println("The program took " + (endTime - startTime) + " ms to compile."); 

	}

}
