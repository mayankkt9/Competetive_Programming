package companies_problem;

import java.util.Scanner;

import utility_method.Print_2D_array;
import utility_method.Score;




public class Optimal_Stratergy_Game {
	public static int solve(int arr[]) {

		int n=arr.length;
		Score dp[][]=new Score[n][n];
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				dp[i][j]=new Score(0,0);
			}
		}
		//System.out.println(dp[0][0].f);
		Print_2D_array.solve(dp);
		
		for(int i=0;i<n;i++)
		{
			dp[i][i].f=arr[i];
			dp[i][i].s=0;
		}
		for(int i=2;i<=n;i++)
		{
			for(int j=0;j<=n-i;j++)
			{
				int end=j+i-1;
				
				if(arr[j]+dp[j+1][end].s >= dp[j][end-1].s+arr[end])
				{
					dp[j][end].f=arr[j]+dp[j+1][end].s;
					dp[j][end].s=dp[j+1][end].f;
				}
				else
				{
					dp[j][end].f=arr[end]+dp[j][end-1].s;
					dp[j][end].s=dp[j][end-1].f;
				}
			}
		}
		
		Print_2D_array.solve(dp);
		
		return dp[0][n-1].f;
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();

		System.out.println(solve(arr));
	}
}
