package weekly_contest;

import java.util.*;

public class W143_P1 {
	public static void main(String[] args) {

		System.out.println(Arrays.toString(distributeCandies(1000000000,1000)));
	}

	public static int[] distributeCandies(int candies, int num_people) {

		int[] my_array = new int[num_people];
		int my_c = 0;

		long l = 0, h = candies;
		while (l <= h) {

			long mid = (l + h) / 2;
			long sum = (mid * (mid + 1)) / 2;
			if (sum <= candies) {
				my_c = (int)(mid) / num_people;
				l = mid + 1;
			} else {
				h = mid - 1;
			}
		}

		int pl=my_c * num_people;
		candies -= ((pl) * ((pl) + 1)) / 2;
		int var_1 = (pl) + 1;

		int var = 0;
		while (candies > 0) {
			if (var_1 <= candies) {
				my_array[var++] = (int) var_1;
				candies =candies - var_1;
				var_1 = var_1 + 1;
			} else {
				my_array[var] =(int) (my_array[var] + candies);
				candies = 0;
			}
		}

		for (int i = 0; i < num_people; i++)
			my_array[i] = (int) ((my_c * (i + 1))+my_array[i]+ (num_people * (my_c * (my_c - 1)) / 2));

		return my_array;

	}

}
