import java.util.Scanner;

public class ConsoleView 
{
	Puzzle p;
	String[][] labels;
	
	public ConsoleView(Puzzle p)
	{
		this.p = p;
		this.labels = new String[3][3];
		updateLabels();
	}
	
	public void updateLabels()
	{
		//Converts the 2d array of numbers 0-8 into strings 1-8 with a space instead of 0
		for(int r=0; r<3; r++) 
		{
			for(int c=0; c<3; c++)
			{
				if(p.getGrid()[r][c]==0)
				{
					labels[r][c] = " ";
				}
				else 
				{
					labels[r][c] = p.getGrid()[r][c] + "";
				}
			}
		}
		
	}
	
	//For testing without GUI
	public void printGrid()
	{
		System.out.println("+---+---+---+");
		System.out.println("| "+ labels[0][0] +" | "+ labels[0][1] +" | "+ labels[0][2] +" |");
		System.out.println("+---+---+---+");
		System.out.println("| "+ labels[1][0] +" | "+ labels[1][1] +" | "+ labels[1][2] +" |");
		System.out.println("+---+---+---+");
		System.out.println("| "+ labels[2][0] +" | "+ labels[2][1] +" | "+ labels[2][2] +" |");
		System.out.println("+---+---+---+");
	}
	
	//The user enters the number of the tile that they want to move
	//This method figures out the row/col of that tile in the grid
	public int[] convertToPosition(String userNum)
	{
		int[] pos = {-1, -1};
		for(int r=0; r<labels.length; r++)
		{
			for(int c=0; c<labels[0].length; c++)
			{
				if(labels[r][c].equals(userNum))
				{
					pos[0] = r;
					pos[1] = c;
				}
			}
		}
		return pos;
	}
	

	public static void main(String[] args)
	{
		Puzzle p = new Puzzle();
		ConsoleView cv = new ConsoleView(p);
		
		cv.printGrid();
		Scanner console = new Scanner(System.in);
		String num = console.nextLine();
		while(!num.toLowerCase().equals("quit"))
		{
			int[] pos = cv.convertToPosition(num);
			p.moveTile(pos[0], pos[1]);
			cv.updateLabels();
			cv.printGrid();
			num = console.nextLine();
		}
		System.out.println("done!");
		
		}
}
