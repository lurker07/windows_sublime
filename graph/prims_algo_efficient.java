import java.util.*;
class Node implements Comparator<Node>
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

	public int compare(Node n1,Node n2)
	{
		if(n1.weight<n2.weight)
			return -1;
		else if(n1.weight>n2.weight)
			return 1;
		return 0;
	}
}

class Solution
{
	public void prims(ArrayList<ArrayList<Node>> adj,int n)
	{
		boolean mst[]= new boolean[n];
		int[] key= new int[n];
		int[] parent= new int[n];
		PriorityQueue<Node> pq= new PriorityQueue<>(n,new Node());
		for(int i=0;i<n;i++)
		{
			key[i]=Integer.MAX_VALUE;
			parent[i]=-1;
			mst[i]=false;
		}
		key[0]=0;
		pq.add(new Node(0,0));
		for(int j=0;j<n-1;j++)
		{
			Node node= pq.poll();
			mst[node.getV()]=true;

		for(Node it:adj.get(node.getV()))
		{
			if(mst[it.getV()]==false && key[it.getV()]>it.getWeight())
			{
				key[it.getV()]=it.getWeight();
				parent[it.getV()]=node.getV();
				pq.add(new Node(it.getV(),key[it.getV()]));
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