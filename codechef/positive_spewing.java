/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc= new Scanner(System.in);
		int t=sc.nextInt();
		for(int i=0;i<t;i++)
		{
		    int n=sc.nextInt();
		    int k=sc.nextInt();
		    int[] a= new int[n];
		    long sum=0l;
		    List<Integer> l= new ArrayList<>();
		    for(int j=0;j<n;j++)
		    {
		        a[j]=sc.nextInt();
		        if(a[j]>0)
		        {
		            sum+=a[j];
		            l.add(j);
		        }
		    }
		    if(sum==0)
		    {
		        System.out.println(sum);
		        continue;
		    }
		    l.add(0,l.get(l.size()-1)-n);
		    l.add(n+l.get(1));
		    int[] min= new int[n];
		    int low=0,left,right;
		    for(int j=0;j<n;j++)
		    {
		        if(a[j]>0)
		        min[j]=0;
		        else
		        {
		        while(l.get(low+1)<j)
		        low++;
		        left=l.get(low);
		        right=l.get(low+1);
		        min[j]=Math.min(j-left,right-j);
		        
		        }
		        sum+=2*Math.max(0,(k-min[j]));
		    }
		    System.out.println(sum);
		}
	}
}
