package companies_problem;

import java.util.Arrays;
import java.util.Scanner;

//nk^2 - time 


public class Egg_droping_problem {
	public static int solve(int n,int k) {

		int dp[][]=new int[n+1][k+1];
		
		for(int i=1;i<=n;i++)
		{
			dp[i][1]=1;
			dp[i][0]=0;
		}
		for(int i=1;i<=k;i++)
		{
			dp[1][i]=i;
		}
		int res;
		for(int i=2;i<=n;i++)
		{
			for(int j=2;j<=k;j++)
			{
				dp[i][j]=Integer.MAX_VALUE;
				for(int p=1;p<=j;p++)
				{
					res=1+Math.max(dp[i-1][p-1],dp[i][j-p]);
					if(res<dp[i][j])
						dp[i][j]=res;
				}
			}
			//System.out.println(Arrays.deepToString(dp));
		}
		
		
		return dp[n][k];
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		System.out.println(solve(n,k)); //n eggs k floor
	}
}
