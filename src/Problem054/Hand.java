package Problem054;

public class Hand
{
	Card[] myHand = new Card[5];
	int[] ranks = new int[15];
	int[] values = new int[6];
	int[] orderedRanks = new int[5];
	int tiebreak1;
	int tiebreak2;
	
	public Hand(String[] hand)
	{
		for( int i = 0; i < 5; i++ )
		{
			myHand[i] = new Card(hand[i]);
			ranks[myHand[i].rank]++;
		}
		
		if ( pair() ) values[0] = 2;
		else if ( twoPair() ) values[0] = 3;
		else if ( threeOfAKind() ) values[0] = 4;
		else if ( straight() ) values[0] = 5;
		else if ( flush() ) values[0] = 6;
		else if ( fullHouse() ) values[0] = 7;
		else if ( fourOfAKind() ) values[0] = 8;
		else values[0] = 1; //highcard
		
		int index = 0;
		for ( int k = 14; k >= 2; k-- )
			if ( ranks[k] == 1 )
			{
				orderedRanks[index] = k;
				index++;
			}
		
		switch ( values[0] )
		{
			case 1: //highcard
				for ( int i = 1; i < 6; i++ )
					values[i] = orderedRanks[i-1];
				break;
			case 2: //pair
				values[1] = tiebreak1;
				values[2] = orderedRanks[0];
				values[3] = orderedRanks[1];
				values[4] = orderedRanks[2];
				//incomplete, for pair tiebreaks
				break;
			case 3: //two pair
				values[1] = tiebreak1;
				values[2] = tiebreak2;
				values[3] = orderedRanks[0];
				break;
			case 4: //three of a kind
				values[1] = tiebreak1;
				values[2] = orderedRanks[0];
				values[3] = orderedRanks[1];
			case 5: //straight
				values[1] = tiebreak1;
			case 6: //flush
				for ( int i = 1; i < 6; i++ )
					values[i] = orderedRanks[i-1];
			case 7: //full house
				values[1] = tiebreak1;
				values[2] = tiebreak2;
			case 8: //four of a kind
				values[1] = tiebreak1;
				values[2] = orderedRanks[0];
		}
	}
	
	public boolean flush()
	{
		for ( int i = 0; i < 4; i++ )
			if ( !(myHand[i].suite).equals(myHand[i+1].suite) )
				return false;
		return true;
	}
	
	public boolean pair()
	{
		int pair1 = 0, pair2 = 0;
		for( int j = 2; j <= 14; j++ )
			if ( ranks[j] == 2 )
			{
				if ( pair1 == 0 )
					pair1 = j;
				else
					pair2 = j;
			}
		if (pair1 != 0  && pair2 == 0)
		{
			tiebreak1 = pair1;
			return true;
		}
		return false;
	}
	
	public boolean twoPair()
	{
		int pair1 = 0, pair2 = 0;
		for( int j = 2; j <= 14; j++ )
			if ( ranks[j] == 2 )
			{
				if ( pair1 == 0 )
					pair1 = j;
				else
					pair2 = j;
			}
		if ( pair1 != 0  && pair2 != 0 )
		{
			tiebreak1 = Math.max(pair1, pair2);
			tiebreak2 = Math.min(pair1, pair2);
			return true;
		}
		return false;
	}
	
	public boolean threeOfAKind()
	{
		int trips = 0, pair = 0;
		for( int j = 2; j <= 14; j++ )
		{
			if ( ranks[j] == 3 ) trips = j;
			if ( ranks[j] == 2 ) pair = j;
		}
		if ( trips != 0 && pair == 0 )
		{
			tiebreak1 = trips;
			return true;
		}
		return false;
	}
	
	public boolean fullHouse()
	{
		int trips = 0, pair = 0;
		for ( int j = 2; j <= 14; j++ )
		{
			if ( ranks[j] == 3 ) trips = j;
			if ( ranks[j] == 2 ) pair = j;
		}
		if ( trips != 0 && pair != 0 )
		{
			tiebreak1 = trips;
			tiebreak2 = pair;
			return true;
		}
		return false;
	}
	
	public boolean fourOfAKind()
	{
		for ( int j = 2; j <= 14; j++ )
			if ( ranks[j] == 4 )
			{
				tiebreak1 = j;
				return true;
			}
		return false;
	}
	
	public boolean straight()
	{
		for ( int i = 2; i <= 10; i++ )
			if (ranks[i]==1 && ranks[i+1]==1 && ranks[i+2]==1 && 
	        ranks[i+3]==1 && ranks[i+4]==1)
			{
				tiebreak1 = (i+4);
				return true;
			}
		return false;
	}
	
	public int compareTo(Hand other)
	{
		for ( int i = 0; i < 6; i++ )
		{
			if ( this.values[i] > other.values[i] ) return 1;
			else if ( this.values[i] != other.values[i] ) return -1;
		}
		return 0;
	}
}
