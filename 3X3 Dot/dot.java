package dot;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;
public class dot {

	public static void main(String[] args) {
		
			 EventQueue.invokeLater(new Runnable()
		        {
		            public void run()
		            {
		                 simframe f = new simframe();
		                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		                f.setVisible(true);
		            }
		        });
	
	}
}
class simframe extends JFrame
{
	simframe()
	{
		setTitle("janakinath");
		setLocation(200,300);
		Toolkit t=Toolkit.getDefaultToolkit();
		Dimension d=t.getScreenSize();
		int framewidth=d.width/2;
		int frameheight=d.height/2;
		setSize(framewidth,frameheight);
		setBackground(Color.cyan);
		panel p=new panel();
		add(p);	
    }
}	
class panel extends JPanel implements MouseListener
{
	int x_cord=300,y_cord=100;
	int X,Y;
	int click=0;
	String p1,p2;
	String chance;
	int won1,won2,boxes=0;;
	int[] a;
	panel()
	{
		a =new int[4];
		System.out.println("ENTER THE NAME OF THE  PLAYER WHO PLAYS FIRST");
		   Scanner s=new Scanner(System.in);
		   p1=s.next();
		   System.out.println("ENTER THE NAME OF THE  PLAYER WHO PLAYS NEXT");
		   p2=s.next();
		   System.out.println("lets start the game");
		   System.out.println("chance of   :"+p1);
		   chance=p1;
		    addMouseListener(this);
		   
	}
	public void paintComponent(Graphics g)
	{
		
		g.drawString("HELLO  WELCOME", 300, 30);
		g.drawString("DOTS AND BOX GAME FOR TWO PLAYER", 250, 50);
		g.drawOval(x_cord, y_cord, 5, 5);
		g.drawOval(x_cord+50, y_cord, 5, 5);
		g.drawOval(x_cord+100, y_cord, 5, 5);
		g.drawOval(x_cord, y_cord+50, 5, 5);
		g.drawOval(x_cord+50, y_cord+50, 5, 5);
		g.drawOval(x_cord+100, y_cord+50, 5, 5);
		g.drawOval(x_cord, y_cord+100, 5, 5);
		g.drawOval(x_cord+50, y_cord+100, 5, 5);
		g.drawOval(x_cord+100, y_cord+100, 5, 5);
		if(click>0)
		{
			if(X>x_cord&&X<x_cord+50&&Y>y_cord&&Y<y_cord+10)
			{
				++a[0];
				g.drawLine(x_cord, y_cord,x_cord+50,y_cord);
				System.out.println(a[0]);
				
		     }
			else if(X>x_cord+50&&X<x_cord+100&&Y>y_cord&&Y<y_cord+10)
			{   ++a[1];
				g.drawLine(x_cord+50, y_cord,x_cord+100,y_cord);
			}
			else if(X>x_cord&&X<x_cord+50&&Y>y_cord+50&&Y<y_cord+60)
			{   ++a[0];
			    ++a[2];
				g.drawLine(x_cord, y_cord+50,x_cord+50,y_cord+50);
				System.out.println(a[0]);
			}
			else if(X>x_cord+50&&X<x_cord+100&&Y>y_cord+50&&Y<y_cord+60)
			{   ++a[1];
			    ++a[3];
				g.drawLine(x_cord+50, y_cord+50,x_cord+100,y_cord+50);
				
			}
			else if(X>x_cord&&X<x_cord+50&&Y>y_cord+100&&Y<y_cord+110)
			{   ++a[2];
				g.drawLine(x_cord, y_cord+100,x_cord+50,y_cord+100);
				
			}
			else if(X>x_cord+50&&X<x_cord+100&&Y>y_cord+100&&Y<y_cord+110)
			{   ++a[3];
				g.drawLine(x_cord+50, y_cord+100,x_cord+100,y_cord+100);
				
			}
			else if(X>x_cord&&X<x_cord+10&&Y>y_cord&&Y<y_cord+50)
			{   ++a[0];
				g.drawLine(x_cord, y_cord,x_cord,y_cord+50);
				System.out.println(a[0]);
			}
			else if(X>x_cord&&X<x_cord+10&&Y>y_cord+50&&Y<y_cord+100)
			{   ++a[2];
				g.drawLine(x_cord, y_cord+50,x_cord,y_cord+100);
				
			}
			else if(X>x_cord+50&&X<x_cord+60&&Y>y_cord&&Y<y_cord+50)
			{  ++a[0];
			   ++a[1];
				g.drawLine(x_cord+50, y_cord,x_cord+50,y_cord+50);
				System.out.println(a[0]);
			}
			else if(X>x_cord+50&&X<x_cord+60&&Y>y_cord+50&&Y<y_cord+100)
			{   ++a[2];
			    ++a[3];
				g.drawLine(x_cord+50, y_cord+50,x_cord+50,y_cord+100);
				
			}
			else if(X>x_cord+100&&X<x_cord+110&&Y>y_cord&&Y<y_cord+50)
			{   ++a[1];
				g.drawLine(x_cord+100, y_cord,x_cord+100,y_cord+50);
				
			}
			else if(X>x_cord+100&&X<x_cord+110&&Y>y_cord+50&&Y<y_cord+100)
			{   ++a[3];
				g.drawLine(x_cord+100, y_cord+50,x_cord+100,y_cord+100);
			}
			if(a[0]==4||a[1]==4||a[2]==4||a[3]==4)
			{
				for(int i=0;i<4;i++)
				{
					if(a[i]==4)
					{
						a[i]=0;
						boxes=boxes+1;
					}
				}
			
				if(chance==p1)
					{
					won1=won1+1;
					chance=p2;
					System.out.println(p1+" "+"has scored:"+won1);
					System.out.println(p2+" "+"has scored:"+won2);
					}
				else
				{
					won2=won2+1;
					chance=p1;
					System.out.println(p1+" "+"has scored:"+won1);
					System.out.println(p2+" "+"has scored:"+won2);
				}
			}
			if(boxes==4)
			{
				if(won1>won2)
					System.out.println(p1+"  "+"has won the game");
				else if(won1==won2)
					System.out.println("its a tie");
				else
					System.out.println(p2+" "+"has won the game");	
				System.exit(0);
			}
			if(p1==chance)
			{
				chance=p2;
				System.out.println("chance of  :"+chance);
			}
				
			else
				{
					chance=p1;
					System.out.println("chance of  :"+chance);	
				}
		   }
		}
	public void mouseClicked(MouseEvent me)
	{
		click++;
		X=me.getX();
		Y=me.getY();
		repaint();	

  }	
	public void mousePressed(MouseEvent me)
	{	}
	public void mouseReleased(MouseEvent me)
	{	}
	public void mouseEntered(MouseEvent me)
	{	}
	public void mouseExited(MouseEvent me)
	{}

}
