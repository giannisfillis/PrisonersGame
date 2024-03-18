// Giannis Fillis A.M. 5380


class GameRounds
{
	private Player[] players = new Player[2];
	private int turn=0;
	
	public GameRounds(Player player1,Player player2){
		players[0] = player1;
		players[1] = player2;
	}
	
	public void playRound(){
		int firstPlayer;
		int secondPlayer;
		if (turn == 0){ //player[0] plays first
			firstPlayer = players[0].play(players[1]); //first player playing
			if (firstPlayer >31){
				System.out.println(players[0] + " busted!The winner of this round is " + players[1]);
				players[1].addWin();
			}
			else{
				secondPlayer = players[1].play(players[0]); //second player playing 
				if (secondPlayer >31){
					System.out.println(players[1] + " busted!The winner of this round is " + players[0]);
					players[0].addWin();
				}
				else{
					if ( firstPlayer >= secondPlayer ){
						System.out.println("The winner of this round is " + players[0]);
						players[0].addWin();
					}
					else if ( secondPlayer > firstPlayer){
						System.out.println("The winner of this round is " + players[1]);
						players[1].addWin();
					}
				}
			}
			turn++;
			return;
		}
		else{ //if turn >0 player[1] plays first 
			firstPlayer = players[1].play(players[0]);
			if (firstPlayer >31){
				System.out.println(players[1] +" busted!The winner of this round is  " + players[0]);
				players[0].addWin();
			}
			else{
				secondPlayer = players[0].play(players[1]);
				if (secondPlayer >31){
					System.out.println(players[0] +" busted!The winner of this round is " + players[1]);
					players[1].addWin();
				}
				else{
					if ( firstPlayer >= secondPlayer){
						System.out.println("The winner of this round is " + players[1]);
						players[1].addWin();
					}
					else if ( secondPlayer > firstPlayer){
						System.out.println("The winner of this round is " + players[0]);
						players[0].addWin();
					}
				}
			}
		}
		if (turn ==1){
				turn = 0;
				return;
			}
	}
	
	public void printScore(){
		System.out.println("Player " + players[0] + " : " + players[0].getWinnerRounds());
		System.out.println("Player " + players[1] + " : " + players[1].getWinnerRounds());

	}
}