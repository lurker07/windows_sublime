import java.util.*;
class Solution {
    public static boolean dfs(int i,List<List<Integer>> adj,boolean[] df,boolean[] vis)
    {
        vis[i]=df[i]=true;
        for(Integer it:adj.get(i))
        {
            if(!vis[it])
            {
                if(dfs(it,adj,df,vis))
                return true;
            }
            else if(df[it])
            return true;
        }
        df[i]=false;
        return false;
    }
    public static boolean isPossible(int n, int[][] pre)
    {
        List<List<Integer>> adj= new ArrayList<>();
        for(int i=0;i<n;i++)
        adj.add(new ArrayList<Integer>());
        for(int[] it:pre)
        adj.get(it[1]).add(it[0]);
        System.out.println(adj);
        boolean[] vis= new boolean[n];
        boolean[] df= new boolean[n];
        for(int i=0;i<n;i++)
        {
            if(!vis[i])
            {
                if(dfs(i,adj,df,vis))
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] a={{1,0},{2,1},{3,2}};
        System.out.println(isPossible(4,a));
    }
}