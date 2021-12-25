import java.util.Scanner;
class Solution
{
	public static void main(String[] args) {
		boolean [] visited= new boolean[n+1];
		ArrayList<Integer> bfs= new ArrayList<>();
		for(int i=1;i<=n;i++)
		{
			if(visited[i]==false)
			{

				Queue<Integer> nodes= new LinkedList<>();
				nodes.add(i);
				visited[i]=true;

				while(!nodes.isEmpty())
				{
					Integer node=nodes.poll();
					bfs.add(node);
					for(Integer j:adj.get(node))
					{
						if(visited[j]==false)
						{
							nodes.add(j);
							visited[j]=true;
						}
					}
				}
			}
		}

		return bfs;
	}
}