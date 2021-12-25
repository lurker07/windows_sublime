import java.uti.*;
class Solution
{
	public boolean cycleCheck(int i,int[] visited,int[] dfs,ArrayList<ArrayList<Integer>> adj)
	{
		visited[i]=1;
		dfs[i]=1;
		for(Integer it:adj.get(i))
		{
			if(visited[it]==0)
			{
				if(cycleCheck(it,visited,dfs,adj))
				return true;
			}
			else if(dfs[it]==1)
				return true;

		}
		dfs[i]=0;
		return false;
	}
	public static void main(String[] args) {
		int[] visited= new int[n+1];
		int[] dfs= new int[n+1];
		for(int i=1;i<=n;i++)
		{
			if(visited[i]==0)
			{
				if(cycleCheck(i,visited,dfs,adj))
					return true;
			}
		}
		return false;
	}
}