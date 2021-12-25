import java.util.*;
class Solution
{

	public void revdfs(int i,int[] visited,ArrayList<ArrayList<Integer>> rev)
	{
		visited[i]=1;
		System.out.print(i+" ");
		for(Integer it:rev.get(i))
			{
				if(visited[it]==0)
					revdfs(it,visited,rev);
			}
	}

	public void dfs(int i,Stack<Integer> st,int[] visited,ArrayList<ArrayList<Integer>> adj)
	{
		visited[i]=0;
		for(Integer it:adj.get(i))
		{
			if(visited[it]==0)
				dfs(it,st,visited,adj);
		}
		st.push(i);
	}

	public void kosarajus(ArrayList<ArrayList<Integer>> adj, int n)
	{
		int [] visited= new int[n];
		Stack <Integer> st= new Stack<>();
		for(int i=0;i<n;i++)
		{
			if(visited[i]==0)
				dfs(i,st,visited,adj);
		}

		ArrayList<ArrayList<Integer>> rev= new ArrayList<>();
		for(int i=0;i<n;i++)
			rev.add(new ArrayList<Integer>());
		for(int i=0;i<n;i++)
		{
			visited[i]=0;
			for(Integer it:adj.get(i))
				rev.get(it).add(i);
		}

		while(!st.isEmpty())
		{
			int node=st.pop();
			if(visited[node]==0)
				revdfs(node,visited,rev);
			System.out.println();
		}
	}

	public static void main(String[] args) {
		kosarajus(adj,n);
	}
}