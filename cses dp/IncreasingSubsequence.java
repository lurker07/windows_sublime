import java.io.*;
import java.util.*;
 
public class IncreasingSubsequence {
 
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

    public static int binarySearch(int i,int[] res,int l,int h)
    {
        while(l<=h)
        {
            int mid=(l+h)/2;
            if(res[mid]==i)
                return mid;
            else if(res[mid]<i)
                l=mid+1;
            else
                h=mid-1;
        }
        return l;
    }

    public static void main(String[] args) {
 
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
 
        FastReader fsr = new FastReader();
 
        int n=fsr.nextInt();
        int[] input=new int[n];
        for(int i=0;i<n;i++)
            input[i]=fsr.nextInt();

        int[] res= new int[n];
        res[0]=input[0];
        int len=1;
        for(int i=1;i<n;i++)
        {
            if(input[i]<res[0])
                res[0]=input[i];
            else if(input[i]>res[len-1])
                res[len++]=input[i];
            else
                res[binarySearch(input[i],res,0,len-1)]=input[i];
        }
        out.println(len);
        out.flush();
        out.close();
    }
}