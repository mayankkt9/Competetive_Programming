package amazon;

import java.util.ArrayList;
import java.util.HashSet;

public class Substring_with_K_distinct_characters {
	public static void main(String[] args) {
		String input = "pqpqs";
		int k = 2;
		int j = 0;

		System.out.println(solve(input, k) - solve(input, k - 1));
	}

	public static int solve(String input, int k) {
		int j = 0;

		int start = 0;
		int end = 0;

		HashSet<Character> hs = new HashSet<>();
		while (end < input.length()) {

			
			
			end++;
		}

		return j;
	}
}
