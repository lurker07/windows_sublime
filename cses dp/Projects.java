import java.io.*;
import java.util.*;

class MyComparator implements Comparator
{
    public int compare(Object o,Object b)
    {
        Project p1= (Project)o;
        Project p2=(Project) b;
        Integer i=p1.end;
        int res= i.compareTo(p2.end);
        if(res==0)
            return -1;
        return res;
    }
}
 
class Project
{
    int start;
    int end;
    int rew;
    Project()
    {}
    Project(int a,int b,int c)
    {
        start=a;
        end=b;
        rew=c;
    }
    public String toString()
    {
        return "("+start+" "+end+" "+rew+")";
    }
}
class Projects {
 
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

    public static int search(int[] end,int st)
    {
        int l=0,h=end.length-1,ans=-1;
        while(l<=h)
        {
            int mid=l+(h-l)/2;
            if(end[mid]==st)
                {
                    ans=mid;
                    h=mid-1;
                }
            else if(end[mid]<st)
                l=mid+1;
            else
                h=mid-1;
        }
        if(ans==-1)
            ans=l;
        return ans;
    }

    public static void main(String[] args) {
 
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
 
        FastReader fsr = new FastReader();
 
        Set<Project> st= new TreeSet<>(new MyComparator());
        int n=fsr.nextInt();
        for(int i=0;i<n;i++)
            st.add(new Project(fsr.nextInt(),fsr.nextInt(),fsr.nextInt()));
        long[] res= new long[n+1];
        res[0]=0l;
        int[] end= new int[n+1];
        int i=0;
        end[i++]=0;
        for(Project p:st)
        {
            end[i++]=p.end;
        }
        i=1;
        for(Project p:st)
        {
            long op1=res[i-1];
            int low=search(end,p.start);
            long op2=p.rew+res[--low];
            res[i++]=Math.max(op1,op2);
        }
        out.println(res[n]);
        out.flush();
        out.close();
    }
}