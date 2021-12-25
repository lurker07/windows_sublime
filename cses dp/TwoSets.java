import java.io.*;
import java.util.StringTokenizer;
 
public class TwoSets {
 
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

 
    public static void main(String[] args) {
 
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
 
        FastReader fsr = new FastReader();
 
        int n=fsr.nextInt();
        int mod=1000000007;
        if((n*(n+1))%4!=0)
            out.println(0);
        else
        {
        int sum=n*(n+1)/4;
        int[][] res= new int[n+1][sum+1];
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=sum;j++)
            {
                if(i==0)
                    res[i][j]=0;
                if(j==0)
                    res[i][j]=1;
                if(i>0&&j>0)
                {
                    if(i<=j)
                        {
                            res[i][j]=res[i-1][j]+res[i-1][j-i];
                            if(res[i][j]>=mod)
                                res[i][j]-=mod;
                        }
                    else
                        res[i][j]=res[i-1][j];
                }
            }
        }
        out.println(res[n-1][sum]);
        }
        out.flush();
        out.close();
    }
}