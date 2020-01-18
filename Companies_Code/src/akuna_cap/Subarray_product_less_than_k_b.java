package akuna_cap;

public class Subarray_product_less_than_k_b {
	public static void main(String[] args) {

		int arr[] = new int[] { 5,2,1,100,200,300,1,2,5 };
		int k = 20;
		System.out.println(numSubarrayProductLessThanK(arr, k));
	}

	public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        long p = 1l;
        int i = 0;
        int j = 0;
        int total = 0;
        while(j < n){
            p *= nums[j];
            while(i <= j&&p >= k){
                p /= nums[i];
                i++;
            }
            total += (j - i + 1);
            j++;
        }
        return total;
    }
}
