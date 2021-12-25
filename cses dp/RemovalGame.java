import java.io.*;
import java.util.StringTokenizer;
 
public class RemovalGame {
 
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
        int[] val= new int[n];
        for(int i=0;i<n;i++)
            val[i]=fsr.nextInt();

        long[][] res= new long[n][n];
        
        for(int g=0;g<n;g++)
        {
            for(int i=0,j=g;j<n;i++,j++)
            {
                if(g==0)
                    res[i][j]=val[i];
                else if(g==1)
                    res[i][j]=Math.max(val[i],val[j]);
                else
                {
                    long val1=val[i]+Math.min(res[i+2][j],res[i+1][j-1]);
                    long val2=val[j]+Math.min(res[i+1][j-1],res[i][j-2]);
                    res[i][j]=Math.max(val1,val2);
                }
            }
        }
        out.println(res[0][n-1]);
        out.flush();
        out.close();
    }
}