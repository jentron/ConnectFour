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
	}

	public void play()
	{
		int round = 21;
		int move;
		int p = -1; // in the top scope so it can be checked for who won. 
		while(round-- > 0){
			for(p=0; p < 2; p++){
				board.dumpBoard();
				move = player[p].getMove(player[p].getName()+", Please enter a column. [1-7]: ");
				board.playCell(move, p+1);
				if(board.checkWin()){
					// do what is needed to end the game
					round = -100;
					break;
				}
			}
		}
		board.dumpBoard();
		if(round < -99){
			System.out.println(player[p].getName()+" Connected FOUR!");
		} else {
			System.out.println("NOBODY Connected FOUR!");
		}
	} // play
	
	
}
