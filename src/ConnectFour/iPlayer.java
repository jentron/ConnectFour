package ConnectFour;

/*******************
 * Connect Four game for CS1400
 * Operation8 Assignment
 * CS 1400 ONL Spr 17 33235
 *  
 * This is the abstract Player Interface class.
 *  
 * 28 Feb 2017
 * @author Ronald Jensen
 *******************/



public abstract class iPlayer {
	public CharSequence name = ""; // The name for the player
//	public Game.Mode play = Game.Mode.NULL;

	public void setName(String sname){
		name =sname;
	}
	public String getName(){
		return name.toString();
	}
	// returns 1, 2, or 3 for Rock, Paper, Scissors
	public abstract int getMove(String prompt);
	public abstract int getMove();
}
