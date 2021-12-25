import java.util.*;
class Node
{
	int u;
	int v;
	int weight;

	Node(int u,int v,int weight)
	{
		this.u=u;
		this.v=v;
		this.weight=weight;
	}
	int getV()
	{
		return v;
	}
	int getU()
	{
		return u;
	}
	int getWeight()
	{
		return weight;
	}
}
class SortComparator implements Comparator<Node>
{
	public int compare(Node n1,Node n2)
	{
		if(n1.getWeight()<n2.getWeight())
			return -1;
		else if(n1.getWeight()>n2.getWeight())
			return 1;
		else return 0;
	}
}

class Solution
{

	public int findParent(int u,int[] parent)
	{
		if(u==parent[u])
			return u;
		return parent[u]=findParent(parent[u],parent);
	}

	public void union(int u,int v,int[] parent,int[] rank)
	{
		u=findParent(u,parent);
		v=findParent(v,parent);
		if(rank[u]<rank[v])
		{
			parent[u]=v;
		}
		else if(rank[u]>rank[v])
		{
			parent[v]=u;
		}
		else
		{
			parent[u]=v;
			rank[u]++;
		}
	}

	public void kruskals(ArrayList<Node> adj,int n)
	{
		int[] parent= new int[n];
		int[] rank= new int[n];

		for(int i=0;i<n;i++)
		{
			parent[i]=i;
			rank[i]=0;
		}

		int cost=0;
		ArrayList<Node> res= new ArrayList<>();
		Collections.sort(adj,new SortComparator());
		for(Node it:adj)
		{
			if(findParent(it.getU(),parent)!=findParent(it.getV(),parent))
			{
				cost+=it.getWeight();
				res.add(it);
				union(it.getU(),it.getV(),parent,rank);
			}
		}

		for(Node it:res)
			System.out.println(it.getU()+" "+it.getV());

	}

	public static void main(String[] args) {
		kruskals(adj,n);
	}
}