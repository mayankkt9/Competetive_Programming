package weekly_contest;

public class W156_P3 {
	public static void main(String[] args) {

		int grid[][] = new int[][] { { 0, 0, 1, 1, 1, 1 },
				{ 0, 0, 0, 0, 1, 1 }, { 1, 1, 0, 0, 0, 1 },
				{ 1, 1, 1, 0, 0, 1 }, { 1, 1, 1, 0, 0, 1 },
				{ 1, 1, 1, 0, 0, 0 } };

		int dp[][] = new int[grid.length][grid[0].length];

		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				dp[i][j] = Integer.MAX_VALUE;
			}
		}
		for (int i = 2; i < dp.length; i++) {
			if (grid[0][i] == 1)
				break;
			dp[0][i] = 1 + dp[0][i-1];
		}
		
		
		

		int initialpos = 1;

		for (int i = 0; i < grid.length; i++) {
			int j;
			if (i == 0)
				j = 0;
			else
				j = 1;
			for (; j < grid[0].length; j++) {

			}
		}

	}
}
