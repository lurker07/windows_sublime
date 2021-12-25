import java.io.*;
import java.util.StringTokenizer;
 
public class RemovingDigits {
 
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
        int[] res= new int[n+1];
        res[0]=0;
        for(int i=1;i<=n;i++)
        {
            int temp=i;
            res[i]=Integer.MAX_VALUE;
            while(temp>0)
            {
                if(temp%10!=0)
                   res[i]=Math.min(res[i],1+res[i-(temp%10)]);
                temp/=10;
            }
        }
        out.println(res[n]);
        out.flush();
        out.close();
    }
}