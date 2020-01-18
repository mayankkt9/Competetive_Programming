package matrix;

public class LC_498_Diagnol_Matrix_1 {
	public static void main(String[] args) {

	}
}

class Solution1 {
	public int[] findDiagonalOrder(int[][] matrix) {
		if (matrix.length == 0)
			return new int[0];
		int m = matrix.length;
		int n = matrix[0].length;
		int inc = -1;
		int count = 0;
		int total = m * n;
		int result[] = new int[total];
		int i = 0, j = 0;
		while (count < total) {
			while (safe(i, j, m, n)) {
				result[count] = matrix[i][j];
				i = i + inc;
				j = j - inc;
				count++;
			}
			inc = inc * -1;
			if (inc == 1) {
				i++;
				if (j == n) {
					i++;
					j--;
				}
			} else {
				j++;
				if (i == m) {
					i--;
					j++;
				}
			}
		}
		return result;

	}

	public boolean safe(int i, int j, int m, int n) {
		if (i >= 0 && i < m && j >= 0 && j < n)
			return true;
		return false;
	}
}
