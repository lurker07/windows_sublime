class Solution
{
	public static void main(String[] args) {
		int[] indeg= new int[n];
		for(int i=0;i<n;i++)
		{
			for(Integer it:adj.get(i))
				indeg[it]++;
		}
		Queue<Integer> q= new LinkedList<Integer>();
		for(int i =0;i<n;i++)
		{
			if(indeg[i]==0)
				q.add(i);
		}
		int count=0;
		while(!q.isEmpty())
		{
			Integer node=q.poll();
			count++;
			for(Integer it: adj.get(node))
			{
				indeg[it]--;
				if(indeg[it]==0)
					q.add(it);
			}
		}
		if(count==n)
			return false;
		return true;
	}
}