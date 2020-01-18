package roblox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class P3 {
	public static void main(String[] args) {

		HashMap<Integer, List<int[]>> hm = new LinkedHashMap<>();
		HashMap<Integer, Integer> count = new HashMap<>();
		int n = 7;
		int arr[] = new int[] { 3, 3, 3, 3, 3, 1, 3 };
		for (int i = 0; i < n; i++) {
			if (count.containsKey(arr[i]) == true) {
				count.put(arr[i], count.get(arr[i]) + 1);
			} else {
				count.put(arr[i], 1);
			}
			if (hm.containsKey(arr[i]) == false) {
				int temp[] = new int[arr[i]];
				List<int[]> lt = new ArrayList<int[]>();
				lt.add(temp);
				temp[0] = i;
				hm.put(arr[i], lt);
			} else {
				List<int[]> lt = hm.get(arr[i]);

			}

		}

	}
}
