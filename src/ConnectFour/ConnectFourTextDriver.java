package ConnectFour;
/*******************
 * Connect Four game for CS1400
 * Operation8 Assignment
 * CS 1400 ONL Spr 17 33235
 *  
 * This is the main class for the text-based game.
 *  
 * 28 Feb 2017
 * @author Ronald Jensen
 * Credit for the JOptionPane dropdown goes to http://alvinalexander.com/java/joptionpane-showinputdialog-examples
 *******************/
import javax.swing.JOptionPane;

public class ConnectFourTextDriver {
	public static Game game; // Game Programming Patterns says singleton patterns aren't great
	final static String[] robots = {"None", "One", "Two"};
	
	public static void main(String[] args) {
		iPlayer playerOne;
		iPlayer playerTwo;
		
		String p = (String)JOptionPane.showInputDialog(null, "How Many Robots?", "Robots?",
				  JOptionPane.QUESTION_MESSAGE, null, robots,robots[2]);
		
		if(p.equals("None"))
		{
			playerOne = new HumanTextPlayer(JOptionPane.showInputDialog(null, "What is player one's name?", null));
			playerTwo = new HumanTextPlayer(JOptionPane.showInputDialog(null, "What is player two's name?", null));			
		} else if (p.equals("Two"))	{
			playerOne = new BetterRobotPlayer();
			playerTwo = new RandomRobotPlayer();
			playerTwo.setName("Another Random Robot");
		} else {
			playerOne = new HumanTextPlayer(JOptionPane.showInputDialog(null, "What is player one's name?", null));
			playerTwo = new BetterRobotPlayer();			
		}
		
		game = new Game(playerOne, playerTwo);
		game.play();
		System.out.println("Game Over");
	}
}
