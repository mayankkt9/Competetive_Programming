package companies_problem;

import java.util.Arrays;
import java.util.Scanner;

import utility_method.Print_2D_array;
//https://leetcode.com/problems/super-egg-drop/submissions/
public class Egg_Droping_problem_time {
	public static int solve(int egg, int floor) {
		
		int moves = 0;
		int[][] dp = new int[floor + 1][egg + 1];
		
		while (dp[moves][egg] < floor) {
			moves = moves + 1;
			
			
			for (int k = 1; k <= egg; ++k)
				dp[moves][k] = 1 + dp[moves - 1][k - 1] + dp[moves - 1][k];

			//Print_2D_array.solve(dp);
		}
		return moves;
		
		
		
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int n = sc.nextInt();
		System.out.println(solve(k, n)); // keggs n floor

	}
}
