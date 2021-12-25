/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    public static boolean isSubsequence(String p,String q)
    {
        int n=p.length();
        int m=q.length();
        int j=0;
        for(int i=0;j<n&&i<m;i++)
        {
            if(q.charAt(i)==p.charAt(j))
            j++;
            if(j==n)
            return true;
        }
        return false;
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc= new Scanner(System.in);
		int t= Integer.parseInt(sc.nextLine());
		for(int i=0;i<t;i++)
		{
			String[] nk= sc.nextLine().split(" ");
			int n=Integer.parseInt(nk[0]);
			int k=Integer.parseInt(nk[1]);
		    String s=sc.nextLine().trim();
		    //System.out.println(s+" "+n+" "+k);
		    char prev=s.charAt(0);
		    char next;
		    if(prev=='0')
		    next='1';
			else
				next='0';
		    StringBuffer st= new StringBuffer("");
		    char ch;
		    if (k%2==0)
		    {
		        for(int j=0;j<k;j+=2)
		        st.append(next+""+prev);
		        ch=prev;
		    }
		    else{
		        for(int j=0;j<k-1;j+=2)
		        st.append(next+""+prev);
		        st.append(next);
		        ch=next;
		    }
		    String res= new String(st);
		   // System.out.println(res+" "+s);
		    if(!isSubsequence(res,s.substring(1,n)))
		    System.out.println(-1);
		    else{
		        int last=n-1;
		        while(s.charAt(last)!=ch)
		        last--;
		        System.out.println(last+1);
		    }
		}
	}
}
