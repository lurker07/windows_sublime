import java.util.Scanner;
class dice
{
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		int mod=1000000007;
		int[] res= new int[n+1];
		res[0]=1;
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=6;j++)
			{
				if(i-j>=0)
				{
					res[i]=(res[i]%mod+(res[i-j]%mod))%mod;
				}
			}
		}
		System.out.println(res[n]);
	}
}