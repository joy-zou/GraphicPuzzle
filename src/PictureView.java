import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PictureView extends JFrame implements ActionListener
{
    //Fields
    private JButton b0,b1,b2,b3,b4,b5,b6,b7,b8,next;
    private JButton[][] buttons;
    private Icon[] icons;
    private JLabel directions,movesReport;
    private Puzzle p;
    
    public PictureView(Puzzle puzz)
    {
        super("MixedUp Tile Game");
        
        this.p = puzz;
        
        //Print directions
        directions = new JLabel("Directions:  Shift the numbers until they are in order.");
        directions.setBounds(5,5,200,20);  
        add(directions);
                
        //Report moves
        movesReport = new JLabel("Moves: " + p.getNumMoves());
        movesReport.setBounds(130,400,100,40);  
        add(movesReport);
        
        //Make icons from a split up picture.
        Icon ic0=new ImageIcon("");  
        Icon ic1=new ImageIcon("pic/1.png");  
        Icon ic2=new ImageIcon("pic/2.png");  
        Icon ic3=new ImageIcon("pic/3.png");  
        Icon ic4=new ImageIcon("pic/4.png");  
        Icon ic5=new ImageIcon("pic/5.png");  
        Icon ic6=new ImageIcon("pic/6.png");  
        Icon ic7=new ImageIcon("pic/7.png");  
        Icon ic8=new ImageIcon("pic/8.png"); 
        
        Icon[] ic = {ic0,ic1,ic2,ic3,ic4,ic5,ic6,ic7,ic8};
        this.icons = ic;
        
        //Create buttons using each icon        
        b0=new JButton(""); 
        b1=new JButton(""); 
        b2=new JButton("");  
        b3=new JButton("");
        b4=new JButton("");
        b5=new JButton("");
        b6=new JButton("");
        b7=new JButton("");
        b8=new JButton("");
        next=new JButton("NEXT");
        
        JButton[][] buttonArr = { {b0, b1, b2}, {b3, b4, b5}, {b6, b7, b8} };
        this.buttons = buttonArr;
        
        updateIcons();
        
        //Set positions and sizes of buttons in the window
        b0.setBounds(10,80,100,100);  
        b1.setBounds(110,80,100,100);  
        b2.setBounds(210,80,100,100);   
        b3.setBounds(10,180,100,100);  
        b4.setBounds(110,180,100,100);   
        b5.setBounds(210,180,100,100);    
        b6.setBounds(10,280,100,100);    
        b7.setBounds(110,280,100,100);    
        b8.setBounds(210,280,100,100);  
    
        next.setBounds(110,440,100,40);
          
        //Add buttons to the JFrame
        add(b0);add(b1);add(b2);add(b3);add(b4);add(b5);add(b6);add(b7);add(b8); add(next);
        b0.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        next.addActionListener(this);
        
        //Color the "NEXT" button
        next.setBackground(Color.black);
        next.setForeground(Color.green);
        
         
        //Set attributes of the frame itself
        setSize(375, 540);  //size of window
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //hit X to close the window
    }
    
    public void actionPerformed(ActionEvent e)
    {

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
		updateIcons();
        
    }
    
    public void updateIcons()
    {
        for(int r=0; r<3; r++)
        {
            for(int c=0; c<3; c++)
            {
                if(p.getGrid()[r][c] == 0)
                    buttons[r][c].setIcon(new ImageIcon("") );
                else
                {
                	ImageIcon icon = new ImageIcon("pic/" + p.getGrid()[r][c] + ".png");
    			ImageIcon scaledIcon = new ImageIcon((icon.getImage()).getScaledInstance(100, 100, Image.SCALE_SMOOTH););
                	buttons[r][c].setIcon(scaledIcon);
    				
                }
            }
        }
        
        movesReport.setText(p.getNumMoves() + "");
    }
    
    public static void main(String[] args) 
    {
        Puzzle p = new Puzzle();
        new PictureView(p);

    }
}
