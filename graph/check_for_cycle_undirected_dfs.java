import java.util.*;
class Solution
{
	public boolean checkForCycle(int i,int par,boolean[] visited,ArrayList<ArrayList<Integer>> adj)
	{
		visited[i]=true;
		for(Integer it:adj.get(i))
		{
			if(!visited[it])
			{
			if(checkForCycle(it,i,visited,adj))
				return true;
			}
			else if(par!=it)
				return true;	
		}
		return false;
	}
	public static void main(String[] args) {
		boolean []visited= new boolean[n+1];
		for(int i=1;i<=n;i++)
		{
			if(!visited[i])
			{
				if(checkForCycle(i,-1,visited,adj))
					return true;

			}
		}
		return false;
	}
}