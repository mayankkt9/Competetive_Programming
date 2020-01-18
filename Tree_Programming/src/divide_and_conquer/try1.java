package divide_and_conquer;

class Solution {
	public static void main(String args[]) {
		int input[] = new int[] { 1, 2, 2, 4, 3, 5 };
		int k = 4;
		int start = 0, end = start + k - 1;
		for (int i = 1; i <= input.length - k; i++) {
			if (input[i] > input[start]) {
				start = i;
				end = start + k - 1;
			} else if (input[i] == input[start])
				start++;
		}
		for (int i = input.length - k + 1; i < input.length; i++) {
			if (input[i] == input[start])
				start++;
			else if (input[i] < input[start])
				break;
			else {
				end = input.length - 1;
				break;
			}
		}
		start = end - k + 1;
		for (int i = start; i <= end; i++)
			System.out.print(input[i] + " ");
	}
}