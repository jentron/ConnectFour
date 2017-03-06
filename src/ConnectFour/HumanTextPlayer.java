package ConnectFour;
/*******************
 * Connect Four game for CS1400
 * Operation8 Assignment
 * CS 1400 ONL Spr 17 33235
 *  
 * This is the Human Text Player class 
 * containing the code to get the Human user's move
 * via the console.
 *  
 * 28 Feb 2017
 * @author Ronald Jensen
 *******************/

import java.util.InputMismatchException;
import java.util.Scanner;

public class HumanTextPlayer extends iPlayer{
//	InputStreamReader ins =new InputStreamReader(System.in);
	Scanner in = new Scanner(System.in);
//	CharArray name = new CharArray.array();
	
	
	public HumanTextPlayer(String string) {
		this.setName(string);
	}


	public int getMove(){
		return this.getMove("Please Enter Play: ");
	}
	
	
	public int getMove(String prompt)
	{
		int result = -1;
		boolean inputCorrect = false;
		
		do{
			try{
				System.out.print(prompt);
				result = in.nextInt();
				if(result < 1 || result > 7) {
					throw new InputMismatchException("The input was out of range");
				}
				// Check if move is possible, eg, column not full
				if(ConnectFourTextDriver.game.board.columnFull(result)){
					throw new InputMismatchException("That column is filled");
				}
				// can only get here if exceptions aren't thrown
				in.nextLine();
				inputCorrect = true;
			}
			catch(java.util.InputMismatchException e)
			{
				String extra ="";
				if(in.hasNextLine()) extra = in.nextLine(); // flush the buffer
				//EXTRA CREDIT: Add additional logic so if a player enters “Spock” they will get the
				//response, “Spock is the ultimate, but maintains an unfair advantage and is, therefore, not
				//allowed.”
				if(extra.equalsIgnoreCase("Spock")){
					System.out.println("Spock is the ultimate, but maintains an unfair advantage and is, therefore, not allowed");
				}else{ 
					String errorMessage = e.getMessage();
					if(errorMessage == null)
					{
						System.out.println("Sorry, I didn't understand that. Please try again.");
					} else {
						System.out.println(errorMessage + " Please try again.");
					}
				}
			} 
		}while(!inputCorrect);
		return(result);
	} // inputInt
}
