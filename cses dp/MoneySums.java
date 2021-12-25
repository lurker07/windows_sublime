import java.io.*;
import java.util.*;
 
public class MoneySums {
 
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
        
        int n=fsr.nextInt(),sum=0;
        int[] coins= new int[n];
        for(int i=0;i<n;i++)
            sum+=coins[i]=fsr.nextInt();
        boolean[][] res= new boolean[n+1][sum+1];
        for(int i=0;i<=sum;i++)
            res[0][i]=false;
        for(int i=0;i<=n;i++)
            res[i][0]=true;
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=sum;j++)
            {
                if(coins[i-1]<=j)
                    res[i][j]=res[i-1][j]|res[i-1][j-coins[i-1]];
                else
                    res[i][j]=res[i-1][j];
            }
        }
        List<Integer> l= new ArrayList<>();
        for(int i=1;i<=sum;i++)
        {
            if(res[n][i]==true)
                l.add(i);
        }
        out.println(l.size());
        for(Integer it:l)
            out.print(it+" ");
        out.flush();
        out.close();
    }
}