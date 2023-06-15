
import java.util.Scanner;

public class Puzzle 
{
	private int[][] grid;
	private int numMoves;
	
	public Puzzle()
	{
		grid = new int[3][3];
		int[] row1 = {1, 0, 3};
		int[] row2 = {4, 5, 6};
		int[] row3 = {7, 8, 2};
		
		grid[0] = row1;
		grid[1] = row2;
		grid[2] = row3;
		
		numMoves = 0;
	}
	
	public int[][] getGrid()
	{
		return grid;
	}
	
	public int getNumMoves()
	{
		return numMoves;
	}
	public void resetNumMoves()
	{
		numMoves++;
	}
	
	//Given row and column, move value if possible
	public void moveTile(int r, int c)
	{
		if(r-1>=0 && grid[r-1][c]==0)
		{
			//Move up
			grid[r - 1][c] = grid[r][c];
			grid[r][c] = 0;
		}
		else if(r+1<=2 && grid[r+1][c]==0)
		{
			//Move down
			grid[r + 1][c] = grid[r][c];
			grid[r][c] = 0;
		}
		else if(c-1>=0 && grid[r][c-1]==0)
		{
			//Move left
			grid[r][c - 1] = grid[r][c];
			grid[r][c] = 0;
		}
		else if(c+1<=2 && grid[r][c+1]==0)
		{
			//Move right
			grid[r][c + 1] = grid[r][c];
			grid[r][c] = 0;
		}
	}	
}
