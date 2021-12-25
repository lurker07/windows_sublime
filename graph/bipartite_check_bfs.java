import java.util.*;
class Solution
{
	public boolean checkBipartite(int i,boolean[]color,ArrayList<ArrayList<Integer>> adj)
	{
		Queue <Integer> q= new LinkedList<>();
		q.add(i);
		color[i]=1;
		while(!q.isEmpty())
		{
		for(Integer it:adj.get[i])
		{
			Integer node=q.poll();
			if(color[it]==-1)
			{
				color[it]=1-color[node];
				q.add(it);
			}
			else if(color[it]==color[node])
				return false;
		}
	}
		return true;
	}
	public static void main(String[] args) {
		int[] color= new int[n+1];
		for(int i=0;i<=n;i++)
			color[i]=-1;
		for(int i=1;i<=n;i++)
		{
			if(color[i]==-1)
			{
				if(!checkBipartite(i,color,adj))
					return false;
			}
		}
		return true;
	}
}