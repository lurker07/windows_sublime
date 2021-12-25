import java.io.*;
import java.util.StringTokenizer;
 
public class BookShop {
 
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
        int x= fsr.nextInt();
        int[] price= new int[n];
        int[] pages= new int[n];
        for(int i=0;i<n;i++)
            price[i]=fsr.nextInt();
        for(int i=0;i<n;i++)
            pages[i]=fsr.nextInt();

        int[][] res= new int[n+1][x+1];
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=x;j++)
            {
                if(i==0||j==0)
                    res[i][j]=0;
                else
                {
                    if(price[i-1]<=j)
                    {
                        
                        res[i][j]=Math.max(res[i-1][j],pages[i-1]+res[i-1][j-price[i-1]]);
                    }
                    else
                        res[i][j]=res[i-1][j];
                }
            }
        }
        out.println(res[n][x]);
        out.flush();
        out.close();
    }
}