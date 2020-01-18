package junk;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Strinf_prog {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int n = str.length();

		str = str.substring(0, n - 1);
		// System.out.println(str);
		int max = Integer.MAX_VALUE;
		String ans = "";
		String words[] = str.split(" ");
		HashMap<String, Integer> hs = new LinkedHashMap<String, Integer>();
		// System.out.println(words[0]+ " "+words[1]);
		int flag = 0;
		for (int i = 0; i < words.length; i++) {
			String rev = new StringBuilder(words[i]).reverse().toString();
			// System.out.println(rev);
			if (hs.containsKey(words[i])) {

				flag = 1;

				if (hs.get(words[i]) < max) {
					max = hs.get(words[i]);
					ans = new StringBuilder(words[i]).reverse().toString();
				}

			} else {
				if (hs.containsKey(rev) == false)
					hs.put(rev, i);
			}

		}
		if (flag == 0)
			System.out.println("$");
		else
			System.out.println(ans);
	}

}
