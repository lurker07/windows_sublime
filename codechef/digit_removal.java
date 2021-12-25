/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc= new Scanner(System.in);
		int t=sc.nextInt();
		for(int i=0;i<t;i++)
		{
		    int n=sc.nextInt();
		    int d= sc.nextInt();
		  //  int sum=0,mod=10;
		  //  while(mod<n*10)
		  //  {
		  //      int r=n%mod;
		  //      int c=r*10;
		  //      c/=mod;
		  //      if(c==d)
		  //      {
		  //          sum+=(mod-r);
		  //          n+=sum;
		  //      }
		  //      mod*=10;
		  //  }
		  //System.out.print(n+" ");
		  long sum=0l,mod=10l;
		  while(mod<=n*10l)
		  {
		      long r=n%mod;
		      long c=r*10;
		      c/=mod;
		      System.out.println(c+" "+mod+" "+n);
		      if(c==d)
		      {
		          if(d==0)
		          {
		              // sum+=mod/10;
		              // n+=mod/10;
		          		long num=mod/10;
		          		String s="";
		          		while(num>0)
		          		{
		          			num/=10;
		          			s+="1";
		          		}
		          		long add=(Integer.parseInt(s)-r);
		          		sum+=add;
		          		n+=add;
		          		System.out.println(sum+" "+r+" "+n);
		          }
		          else
		          {
		          sum+=((d+1)*mod/10-r);
		          n+=((d+1)*mod/10-r);
		          }
		      }
		      mod*=10;
		  }
		    System.out.println(sum+" "+n);
		}
	}
}
