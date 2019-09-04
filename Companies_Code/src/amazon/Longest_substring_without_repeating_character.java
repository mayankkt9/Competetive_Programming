package amazon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Longest_substring_without_repeating_character {
	public static void main(String[] args) {

		String str = "pwwkew";
		int k = 4;
		System.out.println(solve(str));
	}

	private static int solve(String str) {
		// TODO Auto-generated method stub
		int prev = 0;
		HashSet<Character> hs = new HashSet<>();
		List<String> res = new ArrayList<>();
		int max=0;
		for (int i = 0; i < str.length(); i++) {

			while (hs.contains(str.charAt(i))) {
				hs.remove(str.charAt(prev));
				prev++;
			}
			hs.add(str.charAt(i));
			if(hs.size()>max)
				max=hs.size();

		}

		return max;
	}

}
