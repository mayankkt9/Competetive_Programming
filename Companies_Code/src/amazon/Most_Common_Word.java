package amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Most_Common_Word {
	public static void main(String[] args) {

		String a[] = { "hit" };
		System.out.println(mostCommonWord(
				"Bob hit a ball, the hit BALL flew far after it was hit.", a));
	}

	public static String mostCommonWord(String paragraph, String[] banned) {

		paragraph = paragraph.toLowerCase();
		HashMap<String, Integer> hm = new HashMap<>();
		HashMap<String, Integer> ban = new HashMap<>();

		for (int i = 0; i < banned.length; i++) {
			ban.put(banned[i], 0);
		}

		paragraph = paragraph.replaceAll("[^A-Za-z]+", " ");
		String words[] = paragraph.split(" ");

		for (String string : words) {
			if (ban.containsKey(string) == false) {
				hm.put(string, hm.getOrDefault(string, 0) + 1);
			}
		}
		
		Iterator hmIterator = hm.entrySet().iterator();
		String res="";
		int max=0;
		while (hmIterator.hasNext()) { 
			
			
            Map.Entry mapElement = (Map.Entry)hmIterator.next(); 
            int val = ((int)mapElement.getValue()); 
            if(val>max)
            {
            	res=(String) mapElement.getKey();
            	max=val;
            }
            //System.out.println(mapElement.getKey() + " : " + marks); 
        }

		return res;
	}
}
