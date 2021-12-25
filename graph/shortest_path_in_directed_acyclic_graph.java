import java.util.*;



class Solution
{
	public void topSort(int i,ArrayList<ArrayList<Pair> adj,boolean[] visited,Stack<Integer> st)
	{
		visited[i]=true;
		for(Pair p:adj.get(i))
		{
			if(!visited[p.getV()])
			topSort(p.getV(),adj,visited,st);
		}
		st.push(i);
	}

	public static void main(String[] args) {
		boolean[] visited= new boolean[n];
		Stack<Integer> st= new Stack<>();
		int[] distance= new int[n];
		for(int i=0;i<n;i++)
		{
			if(!visited[i])
			{
				topSort(i,adj,visited,st);
			}
		}
		for(int i=0;i<n;i++)
			distance[i]=Integer.MAX_VALUE;
		distance[src]=0;
		while(!st.isEmpty())
		{
			Integer node= st.pop();
			if(distance[node]!=Integer.MAX_VALUE)
			{
				for(Pair p:adj.get(node))
				{
					if(distance[p.getV()]>distance[node]+p.getWeight())
						distance[p.getV]=distance[node]+p.getWeight();
				}
			}
		}
	}
}