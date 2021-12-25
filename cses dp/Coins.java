import java.util.Scanner;
class Coins
{
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		String[] nm= sc.nextLine().split(" ");
		int n=Integer.parseInt(nm[0]);
		int m=Integer.parseInt(nm[1]);
		String[] coin=sc.nextLine().split(" ");
		int[] coins= new int[n];
		for(int i=0;i<n;i++)
			coins[i]=Integer.parseInt(coin[i]);

		int[][] res= new int[n+1][m+1];

		for(int i=0;i<=m;i++)
			res[0][i]=Integer.MAX_VALUE-1;
		for(int i=0;i<=n;i++)
			res[i][0]=0;
		for(int i=1;i<=m;i++)
		{
			if(i%coins[0]==0)
				res[1][i]=i/coins[0];
			else
				res[1][i]=Integer.MAX_VALUE-1;
		}
		for(int i=2;i<=n;i++)
		{
			for(int j=1;j<=m;j++)
			{
				if(coins[i-1]<=j)
				{
					res[i][j]=Math.min(res[i-1][j],1+res[i][j-coins[i-1]]);
				}
				else
					res[i][j]=res[i-1][j];
			}
		}
		if(res[n][m]==Integer.MAX_VALUE-1||res[n][m]==Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(res[n][m]);
	}
}