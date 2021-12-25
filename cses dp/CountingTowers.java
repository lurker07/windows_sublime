import java.io.*;
import java.util.StringTokenizer;
 
public class CountingTowers {
 
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
 
        int t=fsr.nextInt();
        int mod=1000000007;

        out.println("--------------------------------------------------------");
        for(;t>0;t--)
        {
            int n=fsr.nextInt();
            int[][] res= new int[n+1][2];
            res[1][0]=res[1][1]=1;

            for(int i=2;i<=n;i++)
            {
                int op1=(res[i-1][0]+res[i-1][1]);
                if(op1>=mod)
                    op1-=mod;
                int op2=res[i-1][0];
                int op3=(2*res[i-1][0]);
                if(op3>=mod)
                    op3-=mod;
                int op4=res[i-1][1];

                res[i][0]=(op1+op2);
                if(res[i][0]>=mod)
                    res[i][0]-=mod;
                res[i][0]+=op3;
                if(res[i][0]>=mod)
                    res[i][0]-=mod;
                res[i][1]=(op1+op4);

                if(res[i][1]>=mod)
                    res[i][1]-=mod;
            }
            int ans=res[n][0]+res[n][1];
            if(ans>=mod)
                ans-=mod;
            out.println(ans);
        }

     
        out.flush();
        out.close();
    }
}