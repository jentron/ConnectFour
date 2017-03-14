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

public class BetterRobotPlayer extends iPlayer {
	private Random rand;
	
	public BetterRobotPlayer() {
		this.setName("Better Robot");
		rand = new Random();
	} // constructor

	@Override
	public int getMove(String prompt) {
		return this.getMove();
	} // getMove(prompt)

	@Override
	public int getMove() {
		Board tempBoard = new Board();

		int [] moves = new int[7];
		int move = -1;
		
		for(int i=0; i<7; i++) // for each of our possible moves
		{
			// create a temporary board to test moves on
			tempBoard.setBoard(ConnectFourTextDriver.game.board.getBoard());
			
			// calculate the number of filled squares by adding up column heights
			int [] cH = tempBoard.getColumnHeights();
			int filled=0;
			for(int k=0; k<Board.WIDTH;k++){filled+=cH[k];}
			
			// this player is us, other player is them. Set player number 1&2
			int us = filled%2+1;
			int them = (filled+1)%2+1;
			
			if(tempBoard.columnFull(i+1)){ 
				moves[i] = -100;
			}  else {
				tempBoard.playCell(i+1, us); 
				if(tempBoard.checkWin())
				{
					moves[i] = 100; // This is a winning move, give it a large positive score
					move = i+1; // for now we'll accept the largest wining column
				} else {
					int ttBoard[][] = tempBoard.getBoard();
					for(int k=0; k<Board.WIDTH; k++) // try each of the opponents next moves
					{
						if(!tempBoard.columnFull(k+1)){
							tempBoard.playCell(k+1, them); 
							if(tempBoard.checkWin())
							{
								moves[k] = 75;// This is a blocking move, give it a meduim large positive score
								move = k+1; // for now we'll accept the largest blocking column
							}
							tempBoard.setBoard(ttBoard); // reset the board
						} // if column not full
					}// for k
				} // else
			} // else
		} // if

//		System.out.println("ROBOT BOARD");
//		tempBoard.dumpBoard();

		if(move < 0) // no winning move, so just make a random move FIXME: rip this out
		{
			int [] cH = ConnectFourTextDriver.game.board.getColumnHeights();
			int possibleMoves = 7;
			
			for(int i=0; i<7; i++)
			{
				if(cH[i] == 6) { possibleMoves--;}
			}
			
			move = rand.nextInt(possibleMoves)+1;
			for(int i=0; i<move; i++)
			{
				if(cH[i] == 6) { move++;}
			}

		} // if random move
			
		System.out.println(this.name + " chooses "+move);
		return move;
	} // getMove
} // class

