/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */

 class Codechef {
 
    static class FastReader {
 
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
 
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt() {
            return Integer.parseInt(next());
        }
 
        long nextLong() {
            return Long.parseLong(next());
        }
 
        double nextDouble() {
            return Double.parseDouble(next());
        }
 
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

     public static boolean canReach(String s, int min, int max) {
        char[] c= s.toCharArray();
        int n=s.length();
        boolean[] res= new boolean[n];
        if(c[n-1]=='1')
            return false;
        res[0]=true;
        for(int i=1;i<n;i++)
        {
            for(int j=min;j<=max;j++)
            {
                if((i-j)>=0&&c[i-j]=='0')
                    res[i]=true;
            }
        }
        for(boolean i:res)
            System.out.print(i+" ");
        System.out.println();
        return res[n-1];
    }
 
    public static void main(String[] args) {
 
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
 
        FastReader sc = new FastReader();
 
        //	Scanner sc= new Scanner(System.in);
		int t=sc.nextInt();
		for(int i=0;i<t;i++)
		{
		    int n=sc.nextInt();
		    int [] input=new int[n];
            int max=Integer.MIN_VALUE;
		    for(int j=0;j<n;j++)
		    {input[j]=sc.nextInt();max=Math.max(max,input[j]);}
		    //int [] res= new int[n];
		    int size=0;
		    Set<Integer> set= new HashSet<>();
            max--;
		    for(int j=0;j<n;j++)
		    {
		        if(size<n)
		        {
                    //out.print("in if");
		        int temp=Math.min(input[j]-1,max);
		        temp=Math.max(0,temp);
                out.print(temp);
		        while(temp>0&&set.contains(temp))
		        temp--;
                //out.print("temp "+temp);
		        out.print((input[j]*1+temp)+" ");
		        if(!set.contains(temp))
		        {
		            size++;
		            set.add(temp);
                    if(temp==max)
                        max--;
		        }//System.out.println(res[j]);
		        }
		        else
                
		        out.print("int else "+input[j]+" ");
		    }
		    out.println();
		}

 
        
 
        out.flush();
        out.close();
    }
}