// Giannis Fillis A.M. 5380


import java.util.Random;

public class ComputerPlayer extends Player
{
	Random rnd = new Random();
	
	public ComputerPlayer(String name){
		super(name);
	}
	
	public int SelectNumber(){
		int myNumber = rnd.nextInt(1,5);
		return myNumber;
	}
}