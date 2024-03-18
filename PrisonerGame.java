// Giannis Fillis A.M. 5380

import java.util.Scanner;


class PrisonerGame
{
	public static void main(String[] args){
		ComputerPlayer myComputer = new ComputerPlayer("Computer");
		HumanPlayer myHuman = new HumanPlayer("Human");
		GameRounds myGame = new GameRounds(myHuman,myComputer);
		ComputerPlayer myComputer1 = new ComputerPlayer("Computer1");
		ComputerPlayer myComputer2 = new ComputerPlayer("Computer2");
		GameRounds myGame2 = new GameRounds(myComputer1,myComputer2);
		Boolean gameStillOn = true; //user hasn't exited
		Boolean notValid = true; //for the loop to keep asking until it gets a proper response (yes or no)
		System.out.println("Do you want to play 1. Human vs Computer, or 2. Computer vs Computer? ");
		Scanner input = new Scanner(System.in);
		int choice = input.nextInt(); //human vs computer or computer vs computer
		while (gameStillOn){
			while (choice !=1 && choice !=2){
				System.out.println("Do you want to play 1. Human vs Computer, or 2. Computer vs Computer? ");
				choice = input.nextInt();
			} 
			if (choice == 1){ //human against computer 
				myGame.playRound();
				myGame.printScore();
				System.out.println("Do you want to play another round? ");
				String continueChoice = input.next(); //another round?
				while (notValid){
					if ( continueChoice.equals("yes") || continueChoice.equals("y")){
						myGame.playRound();
						myGame.printScore();
						System.out.println("Do you want to play another round? ");
						continueChoice = input.next();
					}
					else if (continueChoice.equals("no") || continueChoice.equals("n")){
						if (myHuman.declareWinner(myComputer) == null){
							System.out.println("No winner");
							gameStillOn = false;
							notValid = false;
						}
						else{
							System.out.println("The winner of the game is " + myHuman.declareWinner(myComputer));
							gameStillOn = false;
							notValid = false;
						} 
					}
					else{
						System.out.println("Do you want to play another round? ");
						continueChoice = input.next(); 
					} 
				}
			}
			else{ //computer against computer 
				myGame2.playRound();
				myGame2.printScore();
				System.out.println("Do you want to play another round? ");
				String continueChoice2 = input.next(); //another round?
				while (	notValid){
					if ( continueChoice2.equals("yes") || continueChoice2.equals("y")){
						myGame2.playRound();
						myGame2.printScore();
						System.out.println("Do you want to play another round? ");
						continueChoice2 = input.next();
					}
					else if (continueChoice2.equals("no") || continueChoice2.equals("n")){
						if (myComputer1.declareWinner(myComputer2) == null){
							System.out.println("No winner");
							notValid = false;
							gameStillOn = false;
						}
						else{
							System.out.println("The winner of the game is " + myComputer1.declareWinner(myComputer2));
							notValid = false;
							gameStillOn = false;
						} 
					}
					else{
						System.out.println("Do you want to play another round? ");
						continueChoice2 = input.next(); 
					}
				}
			}
		}
	}
}