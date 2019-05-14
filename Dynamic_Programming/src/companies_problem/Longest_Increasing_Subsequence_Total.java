package companies_problem;

import java.util.Arrays;
import java.util.Scanner;

public class Longest_Increasing_Subsequence_Total {
		public static int solve(int arr[]) {
			return 1;
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
