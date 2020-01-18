package companies_problem;

import java.util.Arrays;
import java.util.Scanner;

public class Longest_Increasing_Subsequence {
	public static int solve(int arr[]) {
		if(arr.length==0)return 0;
		int n=arr.length;
		int dp[]=new int[n];
		Arrays.fill(dp, 1);
		
		for(int i=1;i<n;i++)
		{
			for(int j=0;j<i;j++)
			{
				if(arr[i]>arr[j])
					dp[i]=Math.max(dp[i], 1+dp[j]);
			}
			//System.out.println(Arrays.toString(dp));
		}
		
		return Arrays.stream(dp).summaryStatistics().getMax();
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
