
package leetcode_problems;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Minimum_cost_for_ticket {
	public static int solve(int[] a1,int cost[]) {

		
		int dp[]=new int[366];
		boolean[] day=new boolean[366];
		for(int i=0;i<a1.length;i++)
		{
			day[a1[i]]=true;
		}
		for(int i=1;i<366;i++)
		{
			if(day[i]==false) dp[i]=dp[i-1];
			else
			{
				int ans=Math.min(cost[0]+dp[i-1],cost[1]+dp[Math.max(0, i-7)]);
				dp[i]=Math.min(ans, cost[2]+dp[Math.max(0, i-30)]);
			}
		}
		
		return dp[365];
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		int cost[]=new int[3];
		for (int i = 0; i < n; i++)
			arr[i]=sc.nextInt();
		for(int i=0;i<3;i++)
			cost[i]=sc.nextInt();
			

		System.out.println(solve(arr,cost));
	}
}
