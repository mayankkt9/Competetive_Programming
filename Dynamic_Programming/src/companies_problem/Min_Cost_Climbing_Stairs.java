package companies_problem;

import java.util.Scanner;

public class Min_Cost_Climbing_Stairs {
	public static int solve(int cost[]) {

		if (cost.length == 0)
			return 0;
		if (cost.length < 2)
			Math.min(cost[0], cost[1]);

		int a = cost[0];
		int b = cost[1];
		int temp;
		for (int i = 2; i < cost.length; i++) {

			temp = Math.min(a, b) + cost[i];
			a = b;
			b = temp;
		}
		return Math.min(a, b);
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
