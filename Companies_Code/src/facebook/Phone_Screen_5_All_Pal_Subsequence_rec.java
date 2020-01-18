package facebook;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Phone_Screen_5_All_Pal_Subsequence_rec {

	public static void main(String[] args) {
		String s = "abacab";
		Set<String> palindromes = new HashSet<>();
		Set<String> res = new HashSet<>();
		dfs(s, 0, res, new ArrayList<Character>());
		System.out.println(res);
	}

	static void dfs(String s, int cur, Set<String> res, List<Character> tmp) {
		if (isPalindrome(tmp)) {
			StringBuilder sb = new StringBuilder();
			for (char c : tmp)
				sb.append(c);
			res.add(sb.toString());
		}
		for (int i = cur; i < s.length(); i++) {
			char c = s.charAt(i);
			tmp.add(c);
			dfs(s, i + 1, res, tmp);
			tmp.remove(tmp.size() - 1);
		}
	}

	private static boolean isPalindrome(List<Character> tmp) {
		if (tmp.size() == 0)
			return false;
		int l = 0, r = tmp.size() - 1;
		while (l < r) {
			if (tmp.get(l) != tmp.get(r))
				return false;
			l++;
			r--;
		}
		return true;
	}
}
