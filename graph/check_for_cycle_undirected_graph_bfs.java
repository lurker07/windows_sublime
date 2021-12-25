class Node
{
	int first;
	int second;
	public Node(int first,int second)
	{
		this.first=first;
		this.second=second;
	}
}

class Solution
{
	public boolean cyclebfs(int i,boolean[] visited,ArrayList<ArrayList<Integer>> adj)
	{
		Queue<Node> q= new LinkedList<>();
		q.add(new Node(i,-1));
		visited[i]=true;
		while(!q.isEmpty())
		{
			int node=q.peek().first;
			int parent=q.peek().second;
			q.remove();
			for(Integer it:adj.get(node))
			{
				if(visited[it]==false)
				{
					visited[it]=true;
					q.add(new Node(it,node));
				}
				else if(parent!=it)
					return true;
			}
		}
		return false;
	}
	public boolean checkForCycle(int n,ArrayList<ArrayList<Integer>> adj)
	{
		boolean [] visited= new boolean[n+1];
		for(int i=1;i<=n;i++)
		{
			if(visited[i]==false)
			{
				if(checkForCycle(i,visited,adj)==true)
					return true;
			}
		}
		return false;
	}
}