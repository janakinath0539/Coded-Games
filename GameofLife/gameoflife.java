/*ITS GAMEOFLIFE*/
/*IT GIVES US THE GENERATIONS OF PRESENT LIVING CELLS*/
/*PROGRAMMER:-JANAKINATH POKALA*/
package gameoflife;

public class gameoflife {

	public static void main(String[] args) {
		System.out.println("this is a game of life");
		System.out.println("this show ur next generation patterns for ur current input generation");
/* here we have two differnt inputs for differnt patterns*/
/*int a[5][5]={{0,0,0,0,0},{0,0,0,0,0},{0,1,1,1,0},{0,0,0,0,0},{0,0,0,0,0}};
int b[5][5]={{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};*/
		int a[][]={{0,0,0,0,0},{0,0,1,1,0},{0,1,1,0,0},{0,0,1,0,0},{0,0,0,0,0}};
		int b[][]={{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
		game g=new game();
		 g.print(a);
		 g.pass(a,b);

	}

}
class game{
    static int nosofpass;
	void print(int d[][])
	{
	  for(int i=0;i<5;i++)
	   {
	    for(int j=0;j<5;j++)
	    {
	      if(d[i][j]==0)
	      System.out.print("-");
	      else
	      System.out.print("*");
	    }
	   System.out.println();
	  }
	}
	void pass(int t1[][],int t2[][])
	{ 
	 for(int i=0;i<5;i++)
	 {
	  for(int j=0;j<5;j++)
	  {
	  int count1=neigh(i,j,t1);
	    if((count1<2)&&(t1[i][j]==1))
	    t2[i][j]=0;
	    else if((count1>3)&&(t1[i][j]==1))
	    t2[i][j]=0;
	    else if((count1==3)&&(t1[i][j]==0))
	    t2[i][j]=1;
	    else if((count1==2)||(count1==3))
	    {
	     if(t1[i][j]==1)
	     t2[i][j]=1;
	     else
	     t2[i][j]=0;
	     }
	    else
	    t2[i][j]=0;
	   }
	  }
	 print(t2);
	 /* if we want to restrict the output then use this
	 nosofpass++;
	 if(nosofpass<20)*/
	  pass(t2,t1);
	/* else
	  return;*/
	}
	int neigh(int i,int j,int[][] c)
	{
	 int count=0;
	 int leftn=j-1;
	 int rightn=j+1;
	 int topn=i-1;
	 int bottomn=i+1;
	 if(leftn<0)
	 leftn=0;
	 if(topn<0)
	 topn=0;
	 if(rightn==5)
	 rightn=j;
	 if(bottomn==5)
	 bottomn=i;
	 for(int k=topn;k<=bottomn;k++)
	 {
	   for(int m=leftn;m<=rightn;m++)
	   {
	    if(i==k&&j==m)
	    continue;
	    else if(c[k][m]==0)
	    continue;
	    else
	    count++;
	    }
	  }
	 return(count);
	}

}

