import java.util.*;
class Solution
{
	public static void main(String[] args) {
		int[] res= new int[n];
		int[] indeg= new int[n];
		for(int i=0;i<n;i++)
		{
			for(Integer it:adj.get(i))
				indeg[it]++;
		}
		Queue<Integer> q= new LinkedList<>();
		for(int i=0;i<n;i++)
		{
			if(indeg[i]==0)
				q.add(i);
		}
		int i=0;
		while(!q.isEmpty())
		{
			Integer node= q.poll();
			res[i++]=node;
			for(Integer it:adj.get(node))
			{
				indeg[it]--;
				if(indeg[it]==0)
					q.add(it);
			}
		}

	}
}