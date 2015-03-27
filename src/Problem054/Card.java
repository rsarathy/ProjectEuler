package Problem054;

public class Card
{
	String suite;
	int rank;
	
	public Card(String c)
	{
		switch(c.charAt(0))
		{
			case 'T': this.rank = 10;
				break;
			case 'J': this.rank = 11;
				break;
			case 'Q': this.rank = 12;
				break;
			case 'K': this.rank = 13;
				break;
			case 'A': this.rank = 14;
				break;
			default:
				this.rank = Character.getNumericValue(c.charAt(0));
		}
		
		switch(c.charAt(1))
		{
			case 'S': this.suite = "Spade";
				break;
			case 'H': this.suite = "Heart";
				break;
			case 'C': this.suite = "Club";
				break;
			case 'D': this.suite = "Diamond";
		}
	}
}
