package matrix;

import java.util.Arrays;

public class LC_363_Rectange_Sum_Less_K {
	public static void main(String[] args) {

	}
}

class Solution13 {
	public int maxSumSubmatrix(int[][] matrix, int target) {
		// return target;
		return getMaxRectange(matrix, target);
	}

	public int getMaxRectange(int[][] matrix, int target) {

		int n = matrix.length;
		int m = matrix[0].length;

		for (int i = 0; i < n; i++) {
			for (int j = 1; j < m; j++) {
				matrix[i][j] = matrix[i][j] + matrix[i][j - 1];
			}
		}
		int result = Integer.MIN_VALUE;
		int arr[];
		int curr = 0;
		int getMax = 0;
		int temp = Integer.MAX_VALUE;
		int sum = 0;

		for (int i = 0; i < m; i++) {
			for (int j = i; j < m; j++) {
				arr = new int[n];
				curr = 0;
				getMax = 0;
				for (int k = 0; k < n; k++) {
					curr += matrix[k][j] - (i > 0 ? matrix[k][i - 1] : 0);
					arr[k] = curr;
				}
				// System.out.println(Arrays.toString(arr));
				TreeSet<Integer> set = new TreeSet<Integer>();
				set.add(0);
				if (arr[0] <= target)
					result = Math.max(result, arr[0]);
				sum = 0;
				for (int k = 0; k < arr.length; k++) {
					sum = arr[k];
					Integer ceiling = set.ceiling(sum - target);
					if (ceiling != null) {
						result = Math.max(result, sum - ceiling);
					}

					set.add(sum);
				}
				set = null;
			}
		}
		return result;
	}

}