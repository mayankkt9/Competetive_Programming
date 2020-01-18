package array;

import java.util.Arrays;
import java.util.TreeSet;

public class Max_subarray_less_than_k {
	public static void main(String[] args) {
		int arr[] = new int[] { -2,-5,6 };
		System.out.println(solve(arr, 8));
	}

	public static int solve(int arr[], int k) {
		TreeSet<Integer> set = new TreeSet<Integer>();
		int sum = 0;
		int result = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
			//System.out.print(sum+" ");
			Integer ceiling = set.ceiling(sum - k);
			if (ceiling != null) {
				result = Math.max(result, sum - ceiling);
				System.out.println(ceiling);
			}

			set.add(sum);
		}
		System.out.println();
		return result;
	}
}
//