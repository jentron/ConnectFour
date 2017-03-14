package ConnectFour;
/*******************
 * Connect Four game for CS1400
 * Operation8 Assignment
 * CS 1400 ONL Spr 17 33235
 *  
 * This is the game class.
 *  
 * 28 Feb 2017
 * @author Ronald Jensen
 *******************/
public class Game {
	public Board board;
	private iPlayer []  player = new iPlayer[2];
	
	public Game(iPlayer playerOne, iPlayer playerTwo)
	{
		player[0] = playerOne;
		player[1] = playerTwo;
		
		board = new Board();
	} // constructor

	public void play()
	{
		int round = 21; // there are 6*7=42 cells to fill, 42/2 = 21 rounds
		int move;
		int p = -1; // in the top scope so it can be checked for who won. 
		while(round-- > 0){
			for(p=0; p < 2; p++){ // player alternates between 0 and 1
				board.dumpBoard();
				move = player[p].getMove(player[p].getName()+", Please enter a column. [1-7]: ");
				board.playCell(move, p+1);
				if(board.checkWin()){
					// do what is needed to end the game
					round = -100; // Set the round to a large negative, both to end the while loop and to signal a win to the follow-on code
					break; // break out of the for loop. Needed if player 1 wins, otherwise player 2 gets to play
				} // if
			} // for, player swap
		} // while the game is in-progress
		board.dumpBoard();
		if(round < -99){
			System.out.println(player[p].getName()+" Connected FOUR!");
		} else {
			System.out.println("NOBODY Connected FOUR!");
		}
	} // play
	
	
}
