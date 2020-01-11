/*T20 CRICKET GAME*/
/*AUTOPLAY OF CRICKET*/
/*PROGRAMMER:-JANAKINATH POKALA*/
#include<stdio.h>
#include<conio.h>
#include<stdlib.h>
#include<math.h>
#include<time.h>
int player[2][11]={ {0,0,0,0,0,0,0,0,0,0,0},
		    {0,0,0,0,0,0,0,0,0,0,0}
		  };
int out[2][11]={ {1,1,1,1,1,1,1,1,1,1,1},
		    {1,1,1,1,1,1,1,1,1,1,1}
		};
int total_score[2]={0,0};
void batting(int[][11],int,int);
void score_cal(int[][11],int,int);
void swap_ptr(int*,int*);
void swap_num(int*,int*);
int main()
{
  int toss,i,j;
  srand(time(NULL));
  toss=rand()%2;
  if(toss==0)
  {
    batting(player,0,11);
    batting(player,1,11);
  }
  else
  {
    batting(player,1,11);
    batting(player,0,11);
  }
  for(i=0;i<2;i++)
  {
    for(j=0;j<11;j++)
    {
      printf("player %d\t has scored %d\t",j+1,player[i][j]);
      if(out[i][j]==0)
      printf("he is out\n");
      else
      printf("he is not out\n");
    }
    printf("total score of team %d\t is %d\n",i+1,total_score[i]);
  }
  if(total_score[0]<total_score[1])
  printf("team 2 has won the match\n");
  else if(total_score[0]==total_score[1])
  printf("its a draw match\n");
  else
  printf("team 1 has won the match\n");
  getch();
}
void batting(int a[][11],int m,int n)
{
  int i=0,j=1,k=1,score=0,check=1,ball=1;
  printf("team %d is batting\n",m+1);
  int *strike=&a[m][i];
  int *non_strike=&a[m][j];
  while(check<n)
  {
    while(ball<=120)
    {
      printf("player %d is on strike\n",i+1);
      printf("player %d is on non-strike\n",j+1);
      srand(time(NULL));
      score=(-1+rand()%8);
      if(ball%6==0)
      {
	swap_ptr(strike,non_strike);
	swap_num(&i,&j);
      printf("player %d is on strike\n",i+1);
      printf("player %d is on non-strike\n",j+1);

      }
      switch(score)
      {
       case -1:
	       check++;
	       out[m][i]=0;
	       i=k+1;
	       k=i;
	       strike=&a[m][i];
	       break;
      case 0:
	      break;
      case 1:
	      a[m][i]=a[m][i]+1;
	      swap_ptr(strike,non_strike);
	      swap_num(&i,&j);
	      printf("player %d is on strike\n",i+1);
	      printf("player %d is on non-strike\n",j+1);
	      break;

     case 2:  a[m][i]=a[m][i]+2;
	      break;

    case 3:  a[m][i]=a[m][i]+3;
	      swap_ptr(strike,non_strike);
	      swap_num(&i,&j);
	      printf("player %d is on strike\n",i+1);
	      printf("player %d is on non-strike\n",j+1);
	      break;

   case 4:   a[m][i]=a[m][i]+4;
	      break;

   case 5:   printf("\a");
              check++;
	      out[m][i]=0;
	      i=k+1;
	      k=i;
	      strike=&a[m][i];
	      swap_ptr(strike,non_strike);
	      swap_num(&i,&j);
	      printf("player %d is on strike\n",i+1);
	      printf("player %d is on non-strike\n",j+1);
	      break;

   case 6:   a[m][i]=a[m][i]+6;
	      break;
    }
    ball++;
    if(check>10)
    break;
    }
    if(ball>120)
    break;
    }
    score_cal(a,m,n);
 }
 void score_cal(int c[][11],int m,int n)
 {
  int j;
    for(j=0;j<11;j++)
    {
      total_score[m]=total_score[m]+c[m][j];
    }

  }

 void swap_ptr(int *s,int *n)
 {
  int *temp;
  temp=s;
  s=n;
  n=s;
  }
 void swap_num(int *p,int *q)
 {
   int temp;
   temp=*p;
   *p=*q;
   *q=temp;
   }

