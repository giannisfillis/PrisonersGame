// Giannis Fillis A.M. 5380


import java.util.Scanner;

class HumanPlayer extends Player
{
	public HumanPlayer(String name){
		super(name);
	}
	
	public int SelectNumber(){
		Scanner input = new Scanner(System.in);
		System.out.println("Please give a number between 1 and 5 : ");
		int selectedNumber = input.nextInt();
		while (!(1<=selectedNumber && selectedNumber<=5)){
			System.out.println("Please give a number between 1 and 5 : ");
			selectedNumber = input.nextInt();
		}
		return selectedNumber;
	}
}