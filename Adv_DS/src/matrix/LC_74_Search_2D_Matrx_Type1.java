package matrix;

public class LC_74_Search_2D_Matrx_Type1 {
	public static void main(String[] args) {

	}
}

class Solution {
	public boolean searchMatrix(int[][] matrix, int target) {

		int n = matrix.length;
		if (n == 0)
			return false;
		int m = matrix[0].length;
		if (m == 0)
			return false;
		int low = 0;
		int high = n * m - 1;
		int mid = 0;
		int row = 0, col = 0;
		while (low != high) {
			mid = low + (high - low) / 2;
			row = mid / m;
			col = mid % m;
			if (matrix[row][col] < target)
				low = mid + 1;
			else
				high = mid;
		}
		return matrix[high / m][high % m] == target;
	}
}