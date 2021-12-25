import java.util.*;
class Solution
{
	public void sort(int i,int[] visited,ArrayList<ArrayList<Integer>> adj,Stack<Integer> st)
	{
		visited[i]=1;
		for(Integer it:adj.get(i))
		{
			if(visited[it]==0)
				sort(it,visited,adj,st);
		}
		st.push(i); 
	}
	public static void main(String[] args) {
		int[] visited= new int[n+1];
		Stack<Integer> st= new Stack<>();
		for(int i=1;i<=n;i++)
		{
			if(visited[i]==0)
			{
				sort(i,visited,adj,st);
			}
		}

		int[] rs= new int[n+1];
		int i=0;
		while(!st.isEmpty())
		{
			rs[i++]=st.pop();
		}
	}
}