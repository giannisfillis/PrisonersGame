// Giannis Fillis A.M. 5380


public abstract class Player
{
	private String name;
	private int winnerRounds = 0;
	
	public Player(String name){
		this.name = name;
	}
	
	public abstract int SelectNumber();
	
	public int play(Player other){
		int p1Points=0; //this player's points
		int selectedCard1;
		int selectedCard2;
		while (p1Points<26){
			selectedCard1 = this.SelectNumber();
			System.out.println("Player " + this + " selected " + selectedCard1);
			selectedCard2 = other.SelectNumber();
			System.out.println("Player " + other + " selected " + selectedCard2);
			p1Points = p1Points + selectedCard1 + selectedCard2;
			System.out.println(this + " has " + p1Points + " points ");
		}
		return p1Points;
	}
	
	public Player declareWinner(Player other){
		if (this.winnerRounds > other.winnerRounds){
			return this;
		}
		else if ( other.winnerRounds > this.winnerRounds){
			return other;
		}
		else{
			return null;
		}
	}
	
	public String toString(){
		return name;
	}
	
	public void addWin(){
		winnerRounds++;
	}
	
	public int getWinnerRounds(){
		return winnerRounds;
	}
} 