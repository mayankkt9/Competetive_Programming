package stck;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class P2 {
	public static void main(String[] args) {

		List<Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		arr.add(2);
		arr.add(2);
		arr.add(2);

		System.out.println(solve(3, arr));

	}

	public static int solve(int arrival, List<Integer> arr) {

		int i = 0;
		int k = 0;

		HashSet<Integer> hs = new HashSet<Integer>();
		int time = 1;
		while (i < arr.size()) {
			k = 0;
			for (int j = 1; j <= arrival; j++) {
				if (k == 0) {

					if (arr.get(i) == time || hs.contains(time) == true) {
						i++;
						k++;
						continue;
					} else {
						return time;
					}
				}
				//1 2 3 4 5 6 7 8
				if (i<arr.size() && arr.get(i) > time) {
					hs.add(arr.get(i));
				}
				k++;
				i++;

			}
			time++;
		}

		return -1;

	}
}
