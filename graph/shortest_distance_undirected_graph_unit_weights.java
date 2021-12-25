import java.util.*;
class Solution
{
	public static void main(String[] args) {
		int[] distance= new int[n];
		Queue <Integer> q= new LinkedList<Integer>();
		for(int i=0;i<n;i++)
		{
			distance[i]=Integer.MAX_VALUE;
		}
		distance[src]=0;
		q.add(src);
		while(!q.isEmpty())
		{
			Integer node= q.poll();
			for(Integer it:adj.get(node))
			{
				if(distance[it]>distance[node]+1)
				{
					distance[it]=distance[node]+1;
					q.add(it);
				}
			}
		}

		for(int i=0;i<n;i++)
			System.out.print(distance[i]+" ");
	}
}
