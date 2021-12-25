import java.util.*;
class Solution
{

	public void dfs(int i,int parent,int[] low,int[] tin,int[] visited,ArrayList<ArrayList<Integer>> adj,int timer,int[] art)
	{
		visited[i]=1;
		low[i]=tin[i]=timer++;
		int child=0;

		for(Integer it:adj.get(i))
		{
			if(parent==it)
				continue;
			if(visited[it]==0)
			{
				dfs(it,i,low,tin,visited,adj,timer,art);
				low[i]=Math.min(low[i],low[it]);
				if(low[it]>=tin[i]&& parent!=-1)
					art[i]=1;
				child++;
			}
			else
			{
				low[i]=Math.min(tin[it],low[i]);
			}
		}
		if(parent==-1&&child>1)
			art[i]=1;
	}

	public void articulation(ArrayList<ArrayList<Integer>> adj , int n)
	{
		int[] visited= new int[n];
		int[] low= new int[n];
		int[] tin= new int[n];
		int[] art= new int[n];
		int timer=0;

		for(int i=0;i<n;i++)
		{
			if(visited[i]==0)
			{
				dfs(i,-1,low,tin,visited,adj,timer,art);
			}
		}

		for(int i=0;i<n;i++)
		{
			if(art[i]==1)
				System.out.println(i);
		}
	}

	public static void main(String[] args) {
		articulation(adj,n);
	}
}