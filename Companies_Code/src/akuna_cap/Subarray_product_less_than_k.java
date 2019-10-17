package akuna_cap;

public class Subarray_product_less_than_k {
	public static void main(String[] args) {

		int arr[] = new int[] { 5,2,1,100,200,300,1,2,5 };
		int k = 20;
		System.out.println(numSubarrayProductLessThanK(arr, k));
	}

	public static int numSubarrayProductLessThanK(int[] nums, int k) {

		int i = 0, j = 0;
		int result = 0;
		int current_product = nums[i];
		while (j < nums.length && i < nums.length) {
			while (j < nums.length && current_product < k) {
				System.out.println(j+" "+i+" "+result+" "+current_product);
				result += j - i + 1;
				
				j++;
				if (j < nums.length)
					current_product *= nums[j];

			}
			
			if (i < nums.length && nums[i] != 0)
				if (j >= i)
					current_product /= nums[i];
				else {
					current_product = 1;
					j = i;
				}
			i++;

		}

		return result;
	}
}
