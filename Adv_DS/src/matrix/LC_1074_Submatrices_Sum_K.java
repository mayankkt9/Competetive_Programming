package matrix;

import java.util.HashMap;

public class LC_1074_Submatrices_Sum_K {
	public static void main(String[] args) {

	}
}

class Solution {
	public int numSubmatrixSumTarget(int[][] matrix, int target) {

		int n = matrix.length;
		int m = matrix[0].length;

		for (int i = 0; i < n; i++) {
			for (int j = 1; j < m; j++) {
				matrix[i][j] = matrix[i][j] + matrix[i][j - 1];
			}
		}
		// System.out.println(Arrays.deepToString(matrix));
		int curr = 0;
		int res = 0;
		for (int i = 0; i < m; i++) {
			for (int j = i; j < m; j++) {
				HashMap<Integer, Integer> hm = new HashMap();
				hm.put(0, 1);
				curr = 0;

				for (int k = 0; k < n; k++) {
					curr += matrix[k][j] - (i > 0 ? matrix[k][i - 1] : 0);
					res += hm.getOrDefault(curr - target, 0);
					hm.put(curr, hm.getOrDefault(curr, 0) + 1);
				}

			}
		}
		return res;
	}
}
