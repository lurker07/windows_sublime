import java.util.*;
class Node
{
	int u;
	int v;
	int weight;
	Node(int u,int v, int weight)
	{
		this.u=u;
		this.v=v;
		this.weight=weight;
	}
	int getU()
	{
		return u;
	}
	int getV()
	{
		return v;
	}
	int getWeight()
	{
		return weight;
	}

}
class Solution
{
	public void bellman(ArrayList<Node> adj,int n,int src)
	{
		int[] distance= new int[n];
		for(int i=0;i<n;i++)
			distance[i]=Integer.MAX_VALUE;
		distance[src]=0;
		for(int i=0;i<n-1;i++)
		{
			for(Node it:adj)
			{
				if(distance[it.getU()]+it.getWeight()<distance[it.getV()])
					distance[it.getV()]=distance[it.getU()]+it.getWeight();
			}
		}
		boolean flag= false;
		for(Node it:adj)
		{
			if(distance[it.getU()]+it.getWeight()<distance[it.getV()])
			{
				flag= true;
				System.out.println("Negative cycle");
				break;
			}
		}

		if(!flag)
		{
			for(int i=0;i<n;i++)
				System.out.print(i+" "+distance[i]+" ");
		}

	}
	public static void main(String[] args) {
		bellman(edges,n,0);
	}
}