import java.util.*;
class Node implements Comparator<Node>
{
	int v;
	int weight;
	public Node(int v,int weight)
	{
		this.v=v;
		this.weigth=weigth;
	}
	public int getV()
	{
		return this.v;
	}
	public int getWeight()
	{
		return this.weigth;
	}

	public int compare(Node n1,Node n2)
	{
		if(n1.weigth<n2.weigth)
			return -1;
		else if(n1.weight>n2.weight)
			return 1;
		else
			return 0;
	}
}
class Solution
{

	public void dijkstra(int src,ArrayList<ArrayList<Node> adj,int n)
	{
		int[] distance= new int[n];
		for(int i=0;i<n;i++)
			distance[i]=Integer.MAX_VALUE;
		distance[src]=0;

		PriorityQueue<Node> pq= new PriorityQueue<Node>(n,new Node());
		pq.add(new node(src,0));
		while(pq.size()>0)
		{
			Node node = pq.poll();
			for(Node it:adj.get(node.getV()))
			{
				if(distance[it.getV()]>distance[node.getV()]+it.getWeight());
				{
					distance[it.getV()]=distance[node.getV()]+it.getWeight();
					pq.add(new Node(it.getV(),distance[it.getV()]));
				}
			}
		}
		for(int i=0;i<n;i++)
			distance[i]+" ";
	}

	public static void main(String[] args) {
		dijkstra(src,adj,n );
	}
}