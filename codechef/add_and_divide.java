/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    public static String fractionToDecimal(int numr, int denr)
	{
		String res = "";
		HashMap<Integer, Integer> mp = new HashMap<>();
		mp.clear();
		int rem = numr % denr;
		while ((rem != 0) && (!mp.containsKey(rem)))
		{
			mp.put(rem, res.length());
			rem = rem * 10;
			int res_part = rem / denr;
			res += String.valueOf(res_part);
			rem = rem % denr;
		}

		if (rem == 0)
			return "";
		else if (mp.containsKey(rem))
			return res.substring(mp.get(rem));

		return "";
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc= new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++)
        {
	    int a=sc.nextInt();
	    int b=sc.nextInt();
	        
	    String res = fractionToDecimal(b, a);

		if (res == "")
			System.out.print("YES"+" "+res);
		else
			System.out.print("NO"+" "+res);
	       
	   
        }
	}
}
