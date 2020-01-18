package leetcode_array;

import java.util.HashMap;

public class Subarray_sum_div_k {
	public static int subarraysDivByK(int[] A, int K) {

		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		int n = A.length;
		int sum = 0, c = 0;
		if (n < 1)
			return 0;
		hm.put(0, 1);
		for (int i = 0; i < n; i++) {
			sum = (sum + A[i]) % K;
			if (sum < 0)
				sum += K;
			if (hm.containsKey(sum))
				c += hm.get(sum);
			hm.put(sum, hm.getOrDefault(sum, 0) + 1);
		}

		// System.out.println((Arrays.asList(hm)));
		return c;
	}

	public static void main(String[] args) {

		int nums[] = new int[] { 4,5,0,-2,-3,1 };
		int k = 5;

		System.out.println(subarraysDivByK(nums, k));
	}
}
