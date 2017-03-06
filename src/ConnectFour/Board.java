package ConnectFour;
/*******************
 * Connect Four game for CS1400
 * Operation8 Assignment
 * CS 1400 ONL Spr 17 33235
 *  
 * This is the game Board class.
 *  
 * 28 Feb 2017
 * @author Ronald Jensen
 *******************/
public class Board {
	public final static int WIDTH = 7;
	public final static int HEIGHT = 6;
	
	private int[][] cells =  new int[HEIGHT][WIDTH];
	private int[] columnHeight = new int[WIDTH];
	
	private String [] cellArt = {" _ "," X "," 0 "};
	
	Board()
	{
		this.clearBoard();
	}
	
/* 
 * Clears the board in preparation for a game.	
 */
	public void clearBoard()
	{
		for(int i = 0; i < HEIGHT; i++)
		{
			for(int j = 0; j < WIDTH; j++) { cells[i][j] = 0; }
		}
		
		for(int i = 0; i < WIDTH; i++) { this.columnHeight[i] = 0; }
		
	} // clearBoard
	
	public void setBoard(int [][] inputCells )
	{
		clearBoard(); 
		
		for(int i = 0; i < HEIGHT; i++)
		{
			for(int j = 0; j < WIDTH; j++) { 
				cells[i][j] = inputCells[i][j];
				if(inputCells[i][j] > 0) this.columnHeight[j]++;
			}
		}
		
		for(int i = 0; i < WIDTH; i++) { this.columnHeight[i] = 0; }		
	}
	
	public int[][] getBoard()
	{
		return cells.clone();
	}

	/* Returns true of there is still space in a column
	 * 
	 */
	public boolean columnFull(int column)
	{
		if(cells[HEIGHT-1][column-1] == 0) return false;
		return true;
	} // columnFull
	
	public int[] getColumnHeights()
	{
		return columnHeight;
	}
	
	/*
	 * Prints a visual representation of the board to System.out
	 */
	public void dumpBoard()
	{
		System.out.println("-------------------------");
		for(int i = HEIGHT-1; i >= 0; i--)
		{
			for(int j = 0; j < WIDTH; j++)
			{
				System.out.print( cellArt[cells[i][j]] );
			}
			System.out.println();
		}		
		System.out.println("-------------------------");
	} // dumpBoard

	/* give the column [1-7] and the player number [1 or 2]
	 * this method sets the column to played.
	 * It is the responsibility of the caller to validate the move.
	 */
	public void playCell(int column, int player)
	{
		int internalColumn=column-1;

//		while(cells[count][internalColumn] != 0) count++;
		cells[columnHeight[internalColumn]][internalColumn] = player;
		columnHeight[internalColumn]++;
		
	} // playCell
	
	/* Checks for a winning condition 
	 * 
	 */
	public boolean checkWin()
	{
		return checkRows() | checkDiagonals() | checkColumns();
	} // checkWin
	
	public boolean checkRows()
	{
		for(int i = 0; i < HEIGHT; i++)
		{
			for(int j=0; j< 4; j++)

				if( cells[i][j]  > 0 &&
					cells[i][j]   == cells[i][j+1] &&
					cells[i][j+1] == cells[i][j+2] &&
					cells[i][j+2] == cells[i][j+3] ) return true;
		}
		return false;
	} // checkRows
	
	public boolean checkDiagonals()
	{
		// Going up left-right
		for(int i = 0; i < 3; i++)
		{
			for(int j=0; j< 4; j++)

				if( cells[i][j]  > 0 &&
					cells[i][j]   == cells[i+1][j+1] &&
					cells[i+1][j+1] == cells[i+2][j+2] &&
					cells[i+2][j+2] == cells[i+3][j+3] ) return true;
		}
		// Going up left-right
		for(int i = 3; i < HEIGHT; i++)
		{
			for(int j=0; j< 4; j++)

				if( cells[i][j]  > 0 &&
					cells[i][j]     == cells[i-1][j+1] &&
					cells[i-1][j+1] == cells[i-2][j+2] &&
					cells[i-2][j+2] == cells[i-3][j+3] ) return true;
		}		return false;
	} // checkDiagonals
	
	public boolean checkColumns()
	{
		for(int i = 0; i < 3; i++)
		{
			for(int j=0; j< WIDTH; j++)

				if( cells[i][j]  > 0 &&
					cells[i][j]   == cells[i+1][j] &&
					cells[i+1][j] == cells[i+2][j] &&
					cells[i+2][j] == cells[i+3][j] ) return true;
		}
		return false;
	} // checkColumns
}
