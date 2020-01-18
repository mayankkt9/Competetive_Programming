package facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Phone_Screen_3_Caeser_Cipher {
	public static void main(String[] args) {

		String words[] = { "abc", "bcd", "acd", "dfg" };
		HashMap<String, List<String>> hm = new HashMap<>();

		for (int i = 0; i < words.length; i++) {
			if (words[i].charAt(0) == 'a') {
				if (hm.containsKey(words[i]) == false)
					hm.put(words[i], new ArrayList<String>());
			} else {
				String s = "";
				int diff = words[i].charAt(0) - 'a';
				for (int j = 0; j < words[i].length(); j++) {
					char newstr = (char) ( (words[i].charAt(j) - diff));
					
					s = s + String.valueOf(newstr);
				}
				//System.out.println(s+"--"+words[i]);
				if (hm.containsKey(s) == true) {
					List<String> temp = hm.get(s);
					temp.add(words[i]);
					hm.put(s, temp);
				} else {
					hm.put(words[i], new ArrayList<String>());
				}
			}
		}

		System.out.println(hm);

	}
}
