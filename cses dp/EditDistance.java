import java.io.*;
import java.util.StringTokenizer;
 
public class EditDistance {
 
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
 
        String s1=fsr.next();
        String s2=fsr.next();
        int n=s1.length();
        int m=s2.length();
        char [] ch1= s1.toCharArray();
        char[] ch2=s2.toCharArray();
        int[][] res= new int[n+1][m+1];
        for(int i=1;i<=m;i++)
        res[0][i]=i;
        for(int i=1;i<=n;i++)
        res[i][0]=i;
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                if(ch1[i-1]==ch2[j-1])
                    res[i][j]=res[i-1][j-1];
                else
                {
                    res[i][j]=1+Math.min(res[i-1][j],Math.min(res[i][j-1],res[i-1][j-1]));
                }
            }
        }
        out.println(res[n][m]);
        out.flush();
        out.close();
    }
}