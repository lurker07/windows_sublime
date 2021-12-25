import java.util.*;
class Node
{
	int v;
	int weight;
	Node(int v,int weight)
	{
		this.v=v;
		this.weight=weight;
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
	public void prims(ArrayList<ArrayList<Node>> adj,int n)
	{
		boolean mst[]= new boolean[n];
		int[] key= new int[n];
		int[] parent= new int[n];

		for(int i=0;i<n;i++)
		{
			key[i]=Integer.MAX_VALUE;
			parent[i]=-1;
			mst[i]=false;
		}
		key[0]=0;

		for(int j=0;j<n-1;j++)
		{
			int min=Integer.MAX_VALUE,u=0;
			for(int i=0;i<n;i++)
			{
				if(mst[i]==false && key[i]<min)
				{
					min=key[i];
					u=i;
				}
			}
			mst[u]=true;

		for(Node it:adj.get(u))
		{
			if(mst[it.getV()]==false && key[it.getV()]>it.getWeight())
			{
				key[it.getV()]=it.getWeight();
				parent[it.getV()]=u;
			}
		}

		}	

		for(int i=1;i<n;i++)
			System.out.println(parent[i]+" "+i);
	}

	public static void main(String[] args) {
	  prims(adj,n);	
	}
}