import java.io.*;
import java.util.StringTokenizer;
public class Coin1
{
	  static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		public FastScanner()
		{
			br=new BufferedReader(new InputStreamReader(System.in));
		}
		String next() {
			while (st==null|| !st.hasMoreElements())
				try { 
                        st=new StringTokenizer(br.readLine());				               
                     }
                catch (IOException e) {}
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
	public static void main(String[] args) throws IOException {
		FastScanner fs= new FastScanner();
		PrintWriter out=new PrintWriter( new BufferedOutputStream(System.out));
		int n=fs.nextInt();
		int m=fs.nextInt();

		int[] coins=new int[n];
		for(int i=0;i<n;i++)
			coins[i]=fs.nextInt();
		int mod=1000000007;
		int[] res= new int[m+1];
		res[0]=1;
		for(int i=1;i<=m;i++)
		{
			for(int j=0;j<n;j++)
			{
					if(coins[j]<=i)
					{
						res[i]+=res[i-coins[j]];
						if(res[i]>=mod)
							res[i]-=mod;
					}
			}		
		}
		out.println(res[m]);
		out.flush();
		out.close();
	}
}