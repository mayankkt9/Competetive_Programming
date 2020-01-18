package facebook;

import java.util.HashMap;

public class Longest_Substring_With_Distinct_Characters {
	public static int longestSubstring(String str) {

		HashMap<Character, Integer> hm = new HashMap<>();
		int start = 0;
		int end = 0;
		int counter = 0;
		int result = 0;
		while (end < str.length()) {

			char c = str.charAt(end);
			hm.put(c, hm.getOrDefault(c, 0) + 1);
			if (hm.get(c) > 1)
				counter++;

			end++;

			while (counter > 0) {
				char c2 = str.charAt(start);

				if (hm.get(c2) > 1) {
					counter--;
				}
				hm.put(c2, hm.get(c2) - 1);
				start++;

			}
			result = Math.max(result, end - start);

		}
		return result;

	}


}
