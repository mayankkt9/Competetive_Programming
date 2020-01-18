package facebook;

public class Phone_Screen_2_Cut_Woods {
	public static boolean isValid(int[] wood, int cutLength, int k) {
		int count = 0;
		for (int w : wood) {
			count += w / cutLength;
		}
		return count >= k;
	}

	public static int cutWood(int[] wood, int k) {
		// corner cases:
		if (wood.length == 0 || k == 0)
			return 0;
		int left = 1, right = Integer.MAX_VALUE;
		int res = 0;
		if (!isValid(wood, left, k))
			return 0;
		while (left < right) {
			int mid = left + (right - left) / 2;
			boolean valid = isValid(wood, mid, k);
			if (valid) {
				left = mid + 1;
				res = mid;
			} else
				right = mid;
		}
		return res;
	}

	public static void main(String[] args) {
		// Main main = new Main();
		int[][] testcases_wood = { { 1, 2, 3, 4, 5, 6, 7, 12, 5, 6, 7 },
				{ 5, 9, 7 }, { 232, 124, 456 } };
		int[] testcases_k = { 3, 4, 7 };
		for (int i = 0; i < testcases_wood.length; ++i)
			System.out.println(cutWood(testcases_wood[i], testcases_k[i]));
	}
}
