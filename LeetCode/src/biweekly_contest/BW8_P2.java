package biweekly_contest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class BW8_P2 {
	public static void main(String[] args) {

		List<String> res = new ArrayList();
		res = beforeAndAfterPuzzles(new String[] {"nrop xshcva twecfm twecfm twecfm xshcva twecfm","ggwznmv twecfm nrop nrop nrop xshcva ggwznmv ggwznmv p twecfm nrop xshcva p p","p p nrop ggwznmv twecfm nrop p p","xshcva twecfm ggwznmv twecfm nrop p ggwznmv p twecfm","xshcva"});

	}

	public static List<String> beforeAndAfterPuzzles(String[] phrases) {
		HashMap<String, List<String>> first = new HashMap<String, List<String>>();
		HashMap<String, String> last = new HashMap<String, String>();
		Set<String> res = new HashSet<String>();

		for (int i = 0; i < phrases.length; i++) {
			String temp = phrases[i];
			String array[] = temp.split(" ");
			if (first.containsKey(array[0])) {
				List<String> ltS = first.get(array[0]);
				ltS.add(temp);
			} else {
				List<String> tempString = new ArrayList<String>();
				tempString.add(temp);
				first.put(array[0], tempString);
			}
			// last.put(array[array.length - 1], temp);

		}

		for (int i = 0; i < phrases.length; i++) {
			String temp = phrases[i];
			String array[] = temp.split(" ");
			String lastS = array[array.length - 1];

			if (first.containsKey(lastS)) {
				if (lastS.equals(first.get(lastS).get(0))
						&& first.get(lastS).size() == 1) {
					continue;
				}
				for (int j = 0; j < first.get(lastS).size(); j++) {
					if(temp.equals(first.get(lastS).get(j)))
						continue;
					int lastL = lastS.length();
					int lastsize = temp.length() - lastL - 1;
					if (lastsize < 0)
						lastsize = 0;
					String substring1 = temp.substring(0, lastsize);
					String form = "";
					if (substring1.length() == 0)
						form = first.get(lastS).get(j);
					else
						form = substring1 + " " + first.get(lastS).get(j);
					res.add(form);
				}
			}

		}

		// for (Iterator iterator = res.iterator(); iterator.hasNext();) {
		// String string = (String) iterator.next();
		// System.out.println(string);
		//
		// }

		List<String> t1 = new ArrayList<String>(res);
		Collections.sort(t1);
		for (Iterator S = t1.iterator(); S.hasNext();) {
			String string = (String) S.next();
			System.out.println(string);
		}

		return t1;

	}
}
