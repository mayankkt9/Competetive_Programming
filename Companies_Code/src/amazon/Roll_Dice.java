package amazon;

import java.util.Arrays;

public class Roll_Dice {
	public static void main(String[] args) {

		int nums[] = { 1, 2, 3, 6, 2, 3 };
		System.out.println(solve(nums));

	}

	private static int solve(int[] nums) {
		// TODO Auto-generated method stub

		int count[] = new int[7];
		for (int i = 0; i < nums.length; i++) {
			count[nums[i]]++;
		}

		// System.out.println(Arrays.toString(count));
		int min=Integer.MAX_VALUE;
		for (int i = 1; i < 7; i++) {

			int temp=2*count[7-i]+nums.length - count[i]-count[7-i];
			if(temp<min)
				min=temp;
		}

		return min;
	}

}
