import java.util.*;
class Solution
{
	public boolean checkBipartite(int i,ArrayList<ArrayList<Integer>> adj,int[] color)
	{
		if(color[i]==-1)
			color[i]=1;
		for(Integer it:adj.get(i))
		{
			if(color[it]==-1)
			{
				color[it]=1-color[i];
				if(!checkBipartite(it,adj,color))
					return false;
			}
			else if(color[it]==color[i])
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		int[] color= new int[n+1];
		for(int i=1;i<=n;i++)
			color[i]=-1;
		for(int i=1;i<=n;i++)
		{
			if(color[i]==-1)
			{
				if(!checkBipartite(i,adj,color))
					return false;

			}
		}
		return true;
	}
}