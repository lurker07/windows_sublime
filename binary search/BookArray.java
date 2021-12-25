import java.io.*;
import java.util.StringTokenizer;
 
public class BookArray {
 
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

    public static boolean isValid(int[] nums,int n,int k,int mid)
    {
        int stu=1;
        int sum=0;
        for(int i=0;i<n;i++)
        {
            if(nums[i]>mid)
                return false;
            if(sum+nums[i]>mid)
            {
                stu++;
                sum=nums[i];
                if(stu>k)
                    return false;
            }
            else
                sum+=nums[i];
        }
        return true;
    }

    public static void main(String[] args) {
 
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
 
        FastReader fsr = new FastReader();
        
        int n=fsr.nextInt();
        int k=fsr.nextInt();
        int[] books= new int[n];
        for(int i=0;i<n;i++)
            books[i]=fsr.nextInt();
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int i:books)
        {
            sum+=i;
            if(i>max)
                max=i;
        }
        int l=max,h=sum,res=-1;
        if(n<k)
            out.println(-1);
        else
        {
            while(l<=h)
            {
                int mid=l+(h-l)/2;
                if(isValid(books,n,k,mid))
                    {
                        res=mid;
                        h=mid-1;
                    }
                else
                    l=mid+1;
            }
        }
        out.println(res);
        out.flush();
        out.close();
    }
}