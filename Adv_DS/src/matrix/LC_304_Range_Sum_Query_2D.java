package matrix;

public class LC_304_Range_Sum_Query_2D {
	public static void main(String[] args) {

	}
}

class NumMatrix {

	int sum[][];

	public NumMatrix(int[][] matrix) {
		if (matrix.length == 0)
			return;
		int n = matrix.length;
		int m = matrix[0].length;
		sum = new int[n + 1][m + 1];
		sum[1][1] = matrix[0][0];

		for (int i = 2; i <= n; i++)
			sum[i][1] = matrix[i - 1][0] + sum[i - 1][1];
		for (int j = 2; j <= m; j++)
			sum[1][j] = matrix[0][j - 1] + sum[1][j - 1];
		for (int i = 2; i <= n; i++) {
			for (int j = 2; j <= m; j++) {
				sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
			}
		}

		// System.out.println(Arrays.deepToString(sum));

	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		int answer = sum[row2 + 1][col2 + 1] - sum[row1][col2 + 1] - sum[row2 + 1][col1] + sum[row1][col1];
		return answer;
	}
}

/**
 * Your NumMatrix object will be instantiated and called as such: NumMatrix obj
 * = new NumMatrix(matrix); int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */