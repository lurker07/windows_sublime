import java.util.Scanner;
class Solution
{
	public void dfs(int i,boolean [] visited,ArrayList<Integer> list,ArrayList<ArrayList<Integer>> adj)
		{
			list.add(i);
			visited[i]=true;
			for(Integer it:adj.get(i))
			{
				if(visited[it]==false)
					dfs(it,visited,list,adj);
			}
		}

	public static void main(String[] args) {
		boolean[] visited= new boolean[n+1];
		ArrayList<Integer> list= new ArrayList<>();
		for(int i=1;i<=n;i++)
		{
			if(visited[i]==false)
			{
				dfs(i,visited,list,adj);
			}
		}

	}
}