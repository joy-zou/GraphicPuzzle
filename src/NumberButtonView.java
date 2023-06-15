import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class NumberButtonView extends JFrame implements ActionListener
{
	private Puzzle p;
	private JButton[][] buttons; 
	private JButton b0, b1,b2,b3,b4,b5,b6,b7,b8,next;
	private JLabel directions,movesReport;
	
	public NumberButtonView(Puzzle p)
	{
		super("MixedUp Tile Game");
		this.p = p;
		
		//Print directions
		directions = new JLabel("Directions:  Shift the numbers until they are in order.");
		directions.setBounds(5, 5,100,20);  
		add(directions);
				
		//Report moves
		movesReport = new JLabel("Moves: " + p.getNumMoves());
		movesReport.setBounds(70,180,100,40);  
		add(movesReport);
		
		//Make new buttons with blank labels (optional: could put labels directly on them)	
		b0=new JButton("");
		b1=new JButton("");
		b2=new JButton("");
		b3=new JButton("");
		b4=new JButton("");
		b5=new JButton("");
		b6=new JButton("");
		b7=new JButton("");
		b8=new JButton("");
		JButton[][] buttonArr = { {b0, b1, b2}, 
				                  {b3, b4, b5}, 
				                  {b6, b7, b8} };
		this.buttons = buttonArr;
		
		//Labels the buttons to match the 2D array (converting the 0 to a " " to make it look blank)
		updateLabels();  
		
		
		//Set positions and sizes of buttons in the window
		b0.setBounds(10,30,50,40);
		b1.setBounds(70,30,50,40);
		b2.setBounds(130,30,50,40);
		b3.setBounds(10,80,50,40);
		b4.setBounds(70,80,50,40);
		b5.setBounds(130,80,50,40);
		b6.setBounds(10,130,50,40);
		b7.setBounds(70,130,50,40);
		b8.setBounds(130,130,50,40);
		
		  
		//Add buttons to the JFrame
		add(b0);add(b1);add(b2);add(b3);add(b4);add(b5);add(b6);add(b7);add(b8); 
		b0.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		
		//Create and color the "NEXT" button
		next=new JButton("NEXT");
		next.setBounds(50,220,100,40);
		next.addActionListener(this);
		next.setBackground(Color.black);
		next.setForeground(Color.green);
		add(next);
		 
		//Set attributes of the frame itself
		setSize(290, 350);  //size of window
		setLayout(null);
		setVisible(true);   //it's set up, so now you can make it visible!
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //hit X to close the window
	}
	
	public void actionPerformed(ActionEvent e)
	{
		//Code to shuffle when someone hits "Next"
		if(e.getSource()==next)
		{
			//reset move counter
			//call a Puzzle method to change the state of the puzzle
			next.setText("Just kidding!");
		}
		
		
		//Code to update text on buttons
		else if(e.getSource()==b0)
		{
			//If they click the first button, move the appropriate tile
			p.moveTile(0, 0);
			
		}
		else if(e.getSource()==b1)
		{
			p.moveTile(0, 1);
		}
		else if(e.getSource()==b2)
		{
			p.moveTile(0, 2);
		}
		else if(e.getSource()==b3)
		{
			p.moveTile(1, 0);
		}
		else if(e.getSource()==b4)
		{
			p.moveTile(1, 1);
		}
		else if(e.getSource()==b5)
		{
			p.moveTile(1, 2);
		}
		else if(e.getSource()==b6)
		{
			p.moveTile(2, 0);
		}
		else if(e.getSource()==b7)
		{
			p.moveTile(2, 1);
		}
		else if(e.getSource()==b8)
		{
			p.moveTile(2, 2);
		}
		
		p.resetNumMoves();
		updateLabels();
	}
	
	public void updateLabels()
	{
		for(int r=0; r<3; r++)
		{
			for(int c=0; c<3; c++)
			{
				if(p.getGrid()[r][c] == 0)
					buttons[r][c].setText(" ");
				else
					buttons[r][c].setText((p.getGrid())[r][c] + "");
			}
		}
		
		movesReport.setText(p.getNumMoves() + "");
	}
	
	public static void main(String[] args) 
	{
		Puzzle p = new Puzzle();
		new NumberButtonView(p);

	}

}

