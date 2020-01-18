package companies_problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Knapsack_01 {

	public static int solve(int n, int wt[], int vl[], int maxwt) {
		int arr[][] = new int[n + 1][maxwt + 1];

		for (int i = 0; i <= n; i++) {
			for (int w = 0; w <= maxwt; w++) {
				if(i==0||w==0)
					arr[i][w]=0;
				else if(w>=wt[i-1])
					arr[i][w]=Math.max(arr[i-1][w], vl[i-1]+arr[i-1][w-wt[i-1]]);
				else
					arr[i][w]=arr[i-1][w];
			}
		}
		return arr[n][maxwt];
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(
				(new InputStreamReader(System.in)));

		int n = Integer.parseInt(br.readLine());
		int maxwt = Integer.parseInt(br.readLine());
		String weight[];
		String value[];
		int wt[] = new int[n];
		int vl[] = new int[n];

		weight = br.readLine().split("\\s");
		value = br.readLine().split("\\s");

		for (int i = 0; i < n; i++) {
			wt[i] = Integer.parseInt(weight[i]);
			vl[i] = Integer.parseInt(value[i]);
		}

		int ans = solve(n, wt, vl, maxwt);
		System.out.println(ans);
	}

}
