package facebook;

import java.util.HashMap;

public class Verifying_alien_dictionary {
	public boolean isAlienSorted(String[] words, String order) {
		HashMap<Character, Integer> hm = new HashMap<>();
		for (int i = 0; i < order.length(); i++) {
			hm.put(order.charAt(i), i);
		}
		// System.out.println(hm);
		for (int k = 1; k < words.length; k++) {

			String str1 = words[k - 1];
			String str2 = words[k];
			int i = 0, j = 0;
			int count = 1;
			while (i < str1.length() && j < str2.length()) {

				if (str1.charAt(i) != str2.charAt(j)) {
					if (hm.get(str1.charAt(i)) > hm.get(str2.charAt(j))) {
						return false;
					}
					// System.out.println(i);
					count = 0;
					break;
				}
				i++;
				j++;
			}
			if (count == 1 && str2.length() < str1.length())
				return false;
		}

		return true;
	}
}
