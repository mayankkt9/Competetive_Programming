package facebook;

import java.util.HashMap;

public class Minimum_Window_Substring {
	public static String minWindowSubstring(String str, String target) {

		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();

		int start = 0;
		int end = 0;
		int result = Integer.MAX_VALUE;
		int start_index = 0;

		for (int i = 0; i < target.length(); i++) {
			hm.put(target.charAt(i), hm.getOrDefault(target.charAt(i), 0) + 1);
		}

		System.out.println(hm);

		int t_count = hm.size();
		while (end < str.length()) {

			if (hm.containsKey(str.charAt(end))) {
				hm.put(str.charAt(end), hm.get(str.charAt(end)) - 1);
				if (hm.get(str.charAt(end)) == 0)
					t_count--;
			}
			end++;

			while (t_count == 0) {

				if (hm.containsKey(str.charAt(start))) {
					hm.put(str.charAt(start), hm.get(str.charAt(start)) + 1);
					if (hm.get(str.charAt(start)) > 0)
						t_count++;
				}
				if (end - start < result) {
					result = end - start;
					start_index = start;
				}
				start++;
			}

		}
		if (result == Integer.MAX_VALUE)
			return "";

		return str.substring(start_index, start_index + result);

	}
}
