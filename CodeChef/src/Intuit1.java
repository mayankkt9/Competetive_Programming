import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Intuit1 {
	public static void main(String[] args) {
		// String pairs[][] = new String[][] { { "DS", "ALGO" }, { "FCS", "OS" }, {
		// "CN", "CA" }, { "ALGO", "FCS" },
		// { "CA", "DS" }, { "SD", "CN" }};
		String pairs[][] = new String[][] { { "CW", "PT" }, { "PT", "BF" }, { "BF", "IG" } };
		int total_course = pairs.length + 1;
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		int j = 0;
		for (int i = 0; i < pairs.length; i++) {
			if (hm.containsKey(pairs[i][0]) == false) {
				hm.put(pairs[i][0], j);
				j++;
			}
			if (hm.containsKey(pairs[i][1]) == false) {
				hm.put(pairs[i][1], j);
				j++;
			}
		}
		System.out.println(hm);
		int noIndegree = 0;
		HashSet<String> set = new HashSet<String>();
		for (int i = 0; i < pairs.length; i++) {
			set.add(pairs[i][1]);
		}
		System.out.println(set);
		for (int i = 0; i < pairs.length; i++) {
			if (set.contains(pairs[i][0]) == false) {
				noIndegree = hm.get(pairs[i][0]);
			}
		}
		int total_traversal = total_course / 2;
		if (total_course % 2 == 0)
			total_traversal -= 1;
		int pred[] = new int[total_course];
		for (int i = 0; i < pairs.length; i++) {
			pred[hm.get(pairs[i][0])] = hm.get(pairs[i][1]);

		}
		int x = 0;
		for (int i = 0; i < total_traversal; i++) {
			x = pred[noIndegree];
			noIndegree = x;
		}
		for (Map.Entry<String, Integer> map : hm.entrySet()) {
			if (map.getValue() == x) {
				System.out.println(map.getKey());
			}
		}
	}
}
