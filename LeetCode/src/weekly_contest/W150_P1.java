package weekly_contest;

import java.util.HashMap;

public class W150_P1 {
	public static void main(String[] args) {

		String x[] = {
				"dyiclysmffuhibgfvapygkorkqllqlvokosagyelotobicwcmebnpznjbirzrzsrtzjxhsfpiwyfhzyonmuabtlwin",
				"ndqeyhhcquplmznwslewjzuyfgklssvkqxmqjpwhrshycmvrb",
				"ulrrbpspyudncdlbkxkrqpivfftrggemkpyjl",
				"boygirdlggnh",
				"xmqohbyqwagkjzpyawsydmdaattthmuvjbzwpyopyafphx",
				"nulvimegcsiwvhwuiyednoxpugfeimnnyeoczuzxgxbqjvegcxeqnjbwnbvowastqhojepisusvsidhqmszbrnynkyop",
				"hiefuovybkpgzygprmndrkyspoiyapdwkxebgsmodhzpx",
				"juldqdzeskpffaoqcyyxiqqowsalqumddcufhouhrskozhlmobiwzxnhdkidr",
				"lnnvsdcrvzfmrvurucrzlfyigcycffpiuoo",
				"oxgaskztzroxuntiwlfyufddl",
				"tfspedteabxatkaypitjfkhkkigdwdkctqbczcugripkgcyfezpuklfqfcsccboarbfbjfrkxp",
				"qnagrpfzlyrouolqquytwnwnsqnmuzphne",
				"eeilfdaookieawrrbvtnqfzcricvhpiv",
				"sisvsjzyrbdsjcwwygdnxcjhzhsxhpceqz",
				"yhouqhjevqxtecomahbwoptzlkyvjexhzcbccusbjjdgcfzlkoqwiwue",
				"hwxxighzvceaplsycajkhynkhzkwkouszwaiuzqcleyflqrxgjsvlegvupzqijbornbfwpefhxekgpuvgiyeudhncv",
				"cpwcjwgbcquirnsazumgjjcltitmeyfaudbnbqhflvecjsupjmgwfbjo",
				"teyygdmmyadppuopvqdodaczob",
				"qaeowuwqsqffvibrtxnjnzvzuuonrkwpysyxvkijemmpdmtnqxwekbpfzs",
				"qqxpxpmemkldghbmbyxpkwgkaykaerhmwwjonrhcsubchs" };
		String w = "usdruypficfbpfbivlrhutcgvyjenlxzeovdyjtgvvfdjzcmikjraspdfp";

		String n[] = { "hello", "world", "leetcode" };
		System.out.println(countCharacters(x, w));
	}

	public static int countCharacters(String[] words, String chars) {

		if (chars.length() == 0 || words.length == 0)
			return 0;
		int res = 0;
		for (String string : words) {
			HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
			for (int i = 0; i < chars.length(); i++)
				hm.put(chars.charAt(i), hm.getOrDefault(chars.charAt(i), 0) + 1);
			int c = 0;
			int length=string.length();
			for (int i = 0; i < string.length(); i++) {
				char cd=string.charAt(i);
				if (hm.containsKey(string.charAt(i)) && hm.get(string.charAt(i)) >= 1) {
					c++;
					hm.put(string.charAt(i), hm.get(string.charAt(i)) - 1);
				}
			}
			if (c == string.length())
				res += string.length();
			hm = null;
		}

		return res;

	}

}
