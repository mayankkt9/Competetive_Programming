package facebook;

public class Max_Consecutive_1_3 {
	public int longestOnes(int[] input, int k) {
		int i = 0;
		int count_of_zeros = 0;
		int result = 0;

		for (int j = 0; j < input.length; j++) {
			if (input[j] == 0)
				count_of_zeros++;

			if (k + 1 <= count_of_zeros) {
				System.out.println(i + "--" + j);
				if (input[i] == 0)
					count_of_zeros--;
				i++;

			}

			result = Math.max(result, j - i + 1);
		}
		return result;
	}
}