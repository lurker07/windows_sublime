import java.util.*;
class Solution
{

	public void dfs(int i,int parent,int[] low,int[] tof,int[] visited,int timer,ArrayList<ArrayList<Integer>> adj)
	{
		visited[i]=1;
		low[i]=tof[i]=timer++;

		for(Integer it:adj.get(i))
		{
			if(it==parent)
				continue;
			else if(visited[i]==0)
			{
				dfs(it,i,low,tof,visited,timer,adj);
				low[i]=Math.min(low[it],low[i]);
				 if(low[it]>tof[i])
				 	System.out.println(i+" "+it);
			}
			else
				low[i]=Math.min(low[i],tof[it]);
		}
	}

	public void bridge(ArrayList<ArrayList<Integer>> adj, int n)
	{
		int[] low= new int[n];
		int[] tof= new int[n];
		int[] visited= new int[n];
		int timer=0;
		for(int i=0;i<n;i++)
		{
			if(visited[i]==0)
			{
				dfs(i,-1,low,tof,visited,timer,adj);
			}
		}
	}
	public static void main(String[] args) {
		bridge(adj,n);
	}
}