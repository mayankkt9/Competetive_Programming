package companies_problem;

import java.util.Arrays;
import java.util.Scanner;

public class Coin_Change {

	
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int arr[]=new int[n];
		int amt=sc.nextInt();
		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();
		
	    System.out.println(solve(arr,amt));
	}

	private static int solve(int[] arr, int amt) {
		// TODO Auto-generated method stub
		if(amt<1) return 0;
		int dp[]=new int[amt+1];
		Arrays.fill(dp, Integer.MAX_VALUE-10);
		dp[0]=0;
		
		for(int i=1;i<=arr.length;i++)
		{
			for(int j=arr[i-1];j<=amt;j++)
			{
					dp[j]=Math.min(dp[j],1+dp[j-arr[i-1]]);
			}
			//System.out.println(Arrays.toString(dp));
		}
		
		
		return dp[amt]>amt?-1:dp[amt];
	}
}
