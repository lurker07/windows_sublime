import java.io.*;
import java.util.StringTokenizer;
 
public class Coin2 {
 
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
        int m=fsr.nextInt();
        int[] coins= new int[n];
        for(int i=0;i<n;i++)
            coins[i]=fsr.nextInt();
        int[] res= new int[m+1];
        res[0]=1;
        int mod=1000000007;
        for(int j=0;j<n;j++)
        {
            for(int i=coins[j];i<=m;i++)
            {
                    res[i]=res[i]+res[i-coins[j]];
                if(res[i]>=mod)
                    res[i]-=mod;
            }
        }
        out.println();
        out.println(res[m]);
        out.flush();
        out.close();
    }
}