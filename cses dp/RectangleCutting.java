import java.io.*;
import java.util.StringTokenizer;
 
public class RectangleCutting {
 
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
    
        int l=fsr.nextInt();
        int b=fsr.nextInt();
        int[][] res= new int[l+1][b+1];
        for(int i=0;i<=l;i++)
        {
            for(int j=0;j<=b;j++)
            {
                if(i==j)
                    res[i][j]=0;
                else
                {
                    res[i][j]=1000000007;
                    for(int k=1;k<=i;k++)
                        res[i][j]=Math.min(res[i][j],1+res[i-k][j]+res[k][j]);
                    for(int k=1;k<=j;k++)
                        res[i][j]=Math.min(res[i][j],1+res[i][j-k]+res[i][k]);
                }
            }
        }
        out.println(res[l][b]);
        out.flush();
        out.close();
    }
}