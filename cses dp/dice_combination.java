import java.util.Scanner;
class Solution
{
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		long mod=1000000007;
		long[] res= new long[n+1];
		res[0]=1l;
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=6;j++)
			{
				if(i-j>=0)
				res[i]+=(1l*res[i-j]%mod);
			}
		}
		System.out.println((int)(res[n])%mod);
	}
}