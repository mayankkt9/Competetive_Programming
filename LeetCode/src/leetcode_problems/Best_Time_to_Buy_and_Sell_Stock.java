package leetcode_problems;

import java.util.Scanner;

public class Best_Time_to_Buy_and_Sell_Stock {
	public static int solve(int arr[]) {

		int min = Integer.MAX_VALUE;
		int max=0;
		for (int i : arr) {
			min=Math.min(min, i);
			max=Math.max(max,i-min);
		}
		return max;
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
