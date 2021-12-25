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
	        n=n-1;
	        int [] arr= new int[n];
	        for(int j=0;j<n;j++)
	        {
	            arr[j]=sc.nextInt();
	        }
	        
	        long sum=0l,limit=100000l;
	        int mod=1000000007;
	        if(n==1)
	        {
	            sum=2*(limit-arr[0])+1;
	            System.out.println(sum);
	        }
	        else{
	            for(int j=0;j<n-1;j++)
	            {
	                if(arr[j+1]<arr[j])
	                {
	                	sum+=(limit-arr[j]+1);
	                	System.out.println((limit-arr[j]+1));
	                	sum%=mod;
	            	}
	            }
	            if(arr[n-2]<=arr[n-1])
	            {
	            	sum+=2*(limit-arr[n-1])+1;
	            	System.out.println(2*(limit-arr[n-1])+1);
	            }
	            else
	            {
	            	sum+=limit-arr[n-2]+1;
	            	System.out.println(limit-arr[n-2]+1);
	            }
	            sum%=mod;
	            System.out.println(sum);
	        }
	    }
	}
}
