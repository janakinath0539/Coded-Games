import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.*;

public class facemash {

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
		panel p=new panel();
		add(p);
    }
}	
class panel extends JPanel implements MouseListener
{
	private File[] file;
	 private Image[] image;
	 private int nos1,nos2;
     private double rating[];
    private int[] win;
	private int[] loose;
	private double E0,E1;
	String msg="FACEMASH BY JANAKINATH";
	int top[];
	panel()
	{
		try{
			
			File path=new File("D:/images");
			file=path.listFiles();
			rating=new double[file.length];
			win=new int[file.length];
			loose=new int[file.length];
			image=new Image[file.length];
			top=new int[5];
			}
			catch(Exception a)
			{
				System.out.println("exception caught");
			}
			for(int i=0;i<file.length;i++)
			{
				rating[i]=1400;
				if(file[i].isFile())
				{
					try{
					image[i]=ImageIO.read(file[i]);
					   }
					catch(IOException e)
					{
						System.out.println("exception caught");
					}
				}
			}
		Random r=new Random();
		nos1=r.nextInt(file.length);
		nos2=r.nextInt(file.length);
		if(nos1==nos2)
		{
			do{
			nos1=r.nextInt(file.length);
			nos2=r.nextInt(file.length);
			}while(nos1==nos2);
			
		}
	    addMouseListener(this);
	}
		public void paint(Graphics g)
		{

			g.drawImage(image[nos1], 100, 50, this);
			g.drawImage(image[nos2], 300, 50, this);
			g.drawString(msg, 200, 30);
			
		}

	public void mouseClicked(MouseEvent me)
	{
      int x=me.getX();
      int y=me.getY();
      if(x>100 && x<200 && y>50 && y<117)
      {
    	  E0=1/(1+Math.pow(10,(rating[nos2]-rating[nos1])/400));
  		rating[nos1]=rating[nos1]+32*(1-E0);
  		win[nos1]=win[nos1]+1;
  		loose[nos1]=loose[nos1];
  		E1=1/(1+Math.pow(10,(rating[nos1]-rating[nos2])/400));
  		rating[nos2]=rating[nos2]+32*(0-E1);
  		win[nos2]=win[nos2];
  		loose[nos2]=loose[nos2]+1;
                			   System.out.println(file[nos1].getName()+"  "+ "rating is"+" "+ rating[nos1]);
		    	System.out.println(file[nos2].getName()+"  "+ "rating is"+" "+ rating[nos2]);
		    	System.out.println("win of "+file[nos1].getName()+" is "+ win[nos1]);
		    	System.out.println("loose of "+file[nos1].getName()+" is "+ loose[nos1]);
		    	System.out.println("win of "+file[nos2].getName()+" is "+ win[nos2]);
		    	System.out.println("loose of "+file[nos2].getName()+" is "+ loose[nos2]);
                Random r=new Random();
		nos1=r.nextInt(file.length);
		nos2=r.nextInt(file.length);

		if(nos1==nos2)
		{
			do{
			nos1=r.nextInt(file.length);
			nos2=r.nextInt(file.length);
			}while(nos1==nos2);
			
			repaint();
		}
		else
		{
			repaint();
		}
      }
      
      else if(x>300 && x<400 && y>50 && y<117)
      {
    	  E1=1/(1+Math.pow(10,(rating[nos1]-rating[nos2])/400));
  		rating[nos2]=rating[nos2]+32*(1-E1);
  		win[nos2]=win[nos2]+1;
  		loose[nos2]=loose[nos2];
  		E0=1/(1+Math.pow(10,(rating[nos2]-rating[nos1])/400));
  		rating[nos1]=rating[nos1]+32*(0-E0);
  		win[nos1]=win[nos1];
  		loose[nos1]=loose[nos1]+1;
                			   System.out.println(file[nos1].getName()+"  "+ "rating is"+" "+ rating[nos1]);
		    	System.out.println(file[nos2].getName()+"  "+ "rating is"+" "+ rating[nos2]);
		    	System.out.println("win of "+file[nos1].getName()+" is "+ win[nos1]);
		    	System.out.println("loose of "+file[nos1].getName()+" is "+ loose[nos1]);
		    	System.out.println("win of "+file[nos2].getName()+" is "+ win[nos2]);
		    	System.out.println("loose of "+file[nos2].getName()+" is "+ loose[nos2]);   
  		Random r=new Random();
		nos1=r.nextInt(file.length);
		nos2=r.nextInt(file.length);
		
		if(nos1==nos2)
		{
			do{
			nos1=r.nextInt(file.length);
			nos2=r.nextInt(file.length);
			}while(nos1==nos2);
			
			repaint();
		}
		else
			repaint();
      }
	}
	
	public void mousePressed(MouseEvent me)
	{	}
	public void mouseReleased(MouseEvent me)
	{	}
	public void mouseEntered(MouseEvent me)
	{	}
	public void mouseExited(MouseEvent me)
	{	}	
}