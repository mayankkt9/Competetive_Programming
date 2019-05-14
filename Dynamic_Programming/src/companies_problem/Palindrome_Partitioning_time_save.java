package companies_problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import utility_method.Is_Palindrome;
import utility_method.Print_2D_array;

public class Palindrome_Partitioning_time_save {
	public static int solve(String str) {

		int n = str.length();
		if(n==0) return 0;
		boolean dp[][] = palindrome_substring(str);
		
		//Print_2D_array.solve(dp);
		
		int res[] = new int[n];
		res[0] = 0;
		for (int i = 0; i < n; i++) {
			if (dp[0][i] == true)
				res[i] = 0;
			else {
				res[i]=Integer.MAX_VALUE;
				for (int j = 0; j < i; j++) {
					if (dp[j + 1][i] == true && 1 + res[j] < res[i])
						res[i] = res[j] + 1;
				}
			}
		}

		return res[n-1];
	}

	public static void main(String args[]) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while (test > 0) {
			String str = br.readLine();
			System.out.println(solve(str));
			test--;
		}

	}

	public static boolean[][] palindrome_substring(String str) {

		int n = str.length();
		boolean dp[][] = new boolean[n][n];

		for (int i = 0; i < n; i++)
			dp[i][i] = true;
		int max = 1;
		int length = 2;
		int start = 0;
		while (length == 2) {
			for (int i = 0; i < n - 1; i++) {
				int nextindex = i + length - 1;

				if (str.charAt(i) == str.charAt(nextindex)) {
					dp[i][nextindex] = true;
					start = i;
					max = 2;
				}
			}
			length++;
		}

		for (int lt = 3; lt <= n; lt++) {
			for (int i = 0; i < n - lt + 1; i++) {
				int last = i + lt - 1;

				if (dp[i + 1][last - 1] == true
						&& str.charAt(i) == str.charAt(last)) {
					dp[i][last] = true;
					if (lt > max) {
						max = lt;
						start = i;
					}
				}
			}
			// Print_2D_array.solve(dp);
		}

		return dp;
	}

}
