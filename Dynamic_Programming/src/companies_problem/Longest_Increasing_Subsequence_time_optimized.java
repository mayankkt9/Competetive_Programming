package companies_problem;

import java.util.Scanner;

import utility_method.Binary_Search;
//nlogn
public class Longest_Increasing_Subsequence_time_optimized {
	public static int solve(int arr[]) {

		int tail[]=new int[arr.length];
		
		tail[0]=arr[0];
		int len=1;
		for(int i=1;i<arr.length;i++)
		{
			if(arr[i]<tail[0])
				tail[0]=arr[i];
			else if(arr[i]>tail[len-1])
				tail[len++]=arr[i];
			else
				tail[Binary_Search.solve_for_LIS(tail, -1, len-1, arr[i])]=arr[i];
		
			
			
		}
		
		
		return len;
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
