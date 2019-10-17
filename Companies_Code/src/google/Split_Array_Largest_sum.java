package google;

public class Split_Array_Largest_sum {
	public static void main(String[] args) {

		System.out.println(splitArray(new int[] { 10,5,13,4,8,4,5,11,14,9,16,10,20,8 }, 8));
	}

	public static int splitArray(int[] nums, int m) {
		
		
		
		long sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		if(m==1) return (int)sum;
		long div = sum / m;
		int i = 0;
		long res = 0;
		while (i < nums.length) {

			long sum2 = 0;
			int j = i;
			for (j = i; j < nums.length; j++) {
				sum2 += nums[j];
				if (sum2 > div)
					break;
			}
			if (i==0||j < nums.length-1) {
				if (Math.abs(sum2 - div) < Math.abs(div - (sum2 - nums[j]))) {
					i = j + 1;
					res = Math.max(res, sum2);
				} else {
					i = j;
					res = Math.max(res, sum2 - nums[j]);
				}
			} else {
				res = Math.max(res, sum2);
				i = j+1;
			}

		}

		return (int)res;
	}
}
