package ConnectFour;
/*******************
 * Connect Four game for CS1400
 * Operation8 Assignment
 * CS 1400 ONL Spr 17 33235
 *  
 * This is a Robot Player class.
 *  
 * 28 Feb 2017
 * @author Ronald Jensen
 *******************/
import java.util.Random;

public class RandomRobotPlayer extends iPlayer {
	private Random rand;
	
	public RandomRobotPlayer() {
		this.setName("Random Robot");
		rand = new Random();
	}

	@Override
	public int getMove(String prompt) {
		return this.getMove();
	}

	@Override
	public int getMove() {
		int [] cH = ConnectFourTextDriver.game.board.getColumnHeights();
		int possibleMoves = 7;
		
		for(int i=0; i<7; i++)
		{
			if(cH[i] == 6) { possibleMoves--;}
		}
		
		int move = rand.nextInt(possibleMoves)+1;
		for(int i=0; i<move; i++)
		{
			if(cH[i] == 6) { move++;}
		}

		
		System.out.println(this.name + " chooses "+move);
		return move;
	}
}
