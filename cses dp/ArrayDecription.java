import java.io.*;
import java.util.StringTokenizer;
 
public class ArrayDecription {
 
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
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=fsr.nextInt();
         int[][] res= new int[n+2][m+2];
         int ans=0,mod=1000000007;
         for(int i=1;i<=n;i++)
         {
            for(int j=1;j<=m;j++)
            {
                if(i==1)
                {
                    if(arr[i-1]==0||arr[i-1]==j)
                        res[i][j]=1;
                    else
                        res[i][j]=0;
                }
                else
                {
                    if(arr[i-1]==0||arr[i-1]==j)
                        res[i][j]=((res[i-1][j-1]+res[i-1][j])%mod+res[i-1][j+1])%mod;
                    else
                        res[i][j]=0;
                }
            }
         }

         for(int i=1;i<=m;i++)
         {
            ans=(ans+res[n][i])%mod;
         }
         out.println(ans);
        out.flush();
        out.close();
    }
}