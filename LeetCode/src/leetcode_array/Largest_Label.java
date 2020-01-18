package leetcode_array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Largest_Label {
	public static void main(String[] args) {
		int[] values = { 9,8,8,7,6};
		int[] labels = { 0,0,0,1,1};
		int num_wanted = 3;
		int use_limit = 1;

		System.out.println(largestValueFromLabel(values, labels, num_wanted,
				use_limit));
	}

	public static int largestValueFromLabel(int[] values, int[] labels,
			int num_wanted, int use_limit) {

		HashMap<Integer, Integer> hash_label = new HashMap<Integer, Integer>();

		for (int i : labels) {
			hash_label.put(i, 0);
		}

		int size = values.length;
		int[][] val_lab = new int[size][2];

		for (int i = 0; i < size; i++) {
			val_lab[i][0] = values[i];
			val_lab[i][1] = labels[i];
		}

		Arrays.sort(val_lab, new Comparator<int[]>() {
			// Compare values according to columns
			public int compare(final int[] entry1, final int[] entry2) {

				// To sort in descending order revert
				// the '>' Operator
				if (entry1[0] < entry2[0])
					return 1;
				else
					return -1;
			}
		}); // End
		int sum = 0;

		for (int i = 0; i < size; i++) {
			int val = val_lab[i][0];
			int lab = val_lab[i][1];

			if (num_wanted > 0 && hash_label.get(lab) < use_limit) {

				sum += val;
				hash_label.put(lab, hash_label.get(lab) + 1);
				num_wanted--;
			}
		}

		return sum;

	}
}
