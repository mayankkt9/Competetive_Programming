package random_problems;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class NEU_1 {
	public static int solve(int n, int distance[], int profit[], int k) {

		TreeMap<Integer, Integer> tmap = new TreeMap<Integer, Integer>();
		tmap.put(0, 0);
		for (int i = 0; i < n; i++) {
				tmap.put(distance[i], i+1);
		}
		int[] dp = new int[n + 1];
		int[] pred = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			int lastHouseDist = distance[i - 1] - k + 1;
			if (tmap.lowerKey(lastHouseDist) != null) {
				int profitTillLastHouse = dp[tmap.get(tmap.lowerKey(lastHouseDist))];
				dp[i] = Math.max(dp[i - 1], profitTillLastHouse + profit[i - 1]);
			} else {
				dp[i] = Math.max(dp[i - 1], profit[i - 1]);
			}
		}
		System.out.println(tmap);
		System.out.println(Arrays.toString(dp));
		System.out.println(Arrays.toString(pred));
		return 0;
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int distance[] = new int[n];
		int profit[] = new int[n];

		for (int i = 0; i < n; i++)
			distance[i] = sc.nextInt();
		for (int i = 0; i < n; i++)
			profit[i] = sc.nextInt();
		int k = sc.nextInt();

		System.out.println(solve(n, distance, profit, k));
		sc.close();
	}
}

/*
7
1 4 9 18 20 21 28
7 9 10 5 4 8 12
5
[0, 7, 9, 19, 24, 24, 27, 39]
*/
