package amazon;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class K_substring_K_distinct {
	public static void main(String[] args) {

		String str = "awaglknagawunagwkwagl";
		int k = 4;
		System.out.println(solve(str, k));
	}

	private static Set<String> solve(String str, int k) {
		// TODO Auto-generated method stub
		int prev = 0;
		HashSet<Character> hs = new HashSet<>();
		Set<String> res = new HashSet<>();
		for (int i = 0; i < str.length(); i++) {

			while (hs.contains(str.charAt(i))) {
				hs.remove(str.charAt(prev));
				prev++;
			}
			hs.add(str.charAt(i));
			if (hs.size() == k) {
				res.add(str.substring(prev, i + 1));
				hs.remove(str.charAt(prev));
				prev++;
			}

		}

		return res;
	}

}
