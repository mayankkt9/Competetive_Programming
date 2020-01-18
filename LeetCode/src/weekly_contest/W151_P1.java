package weekly_contest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

class trans {
	int time;
	int amount;
	String city;
	boolean ans;
}

public class W151_P1 {
	public static void main(String[] args) {
		String transactions[] = {"bob,899,1971,budapest","maybe,850,824,budapest","alex,505,187,tokyo","lee,953,1572,toronto","alex,622,61,frankfurt","lee,191,1261,madrid","iris,740,925,luxembourg","iris,681,401,moscow","chalicefy,298,731,madrid","maybe,549,988,moscow","alex,28,1683,singapore","chalicefy,894,550,rome","xnova,892,990,rome","lee,353,1522,shanghai","xnova,804,549,taipei","maybe,716,1727,shenzhen","chalicefy,770,1156,taipei","alex,957,466,munich","bob,381,1136,tokyo","alex,496,1662,luxembourg","xnova,849,354,munich","bob,486,1751,barcelona","xnova,350,14,moscow","iris,858,583,chicago","maybe,511,1002,toronto","maybe,838,585,amsterdam","bob,536,217,toronto","iris,24,1596,hongkong","chalicefy,894,1074,beijing","maybe,502,530,barcelona","lee,95,1916,madrid","maybe,313,1394,madrid","chalicefy,160,1591,hongkong","xnova,280,1023,tokyo","chalicefy,224,920,singapore","bob,725,501,prague","alex,481,35,frankfurt","xnova,336,423,guangzhou","xnova,535,382,istanbul","lee,806,1597,chicago","lee,124,1012,tokyo","iris,627,665,shenzhen","alex,160,651,amsterdam","bob,674,193,dubai","alex,290,770,tokyo","maybe,406,659,shenzhen","lee,493,1002,warsaw","alex,929,591,taipei","bob,456,6,luxembourg","iris,985,1959,newdelhi","xnova,816,1147,singapore","bob,110,73,frankfurt","chalicefy,80,85,warsaw","xnova,266,162,munich","xnova,295,1944,newdelhi","chalicefy,47,141,madrid","xnova,78,205,shanghai","bob,487,260,bangkok","bob,880,628,hongkong","maybe,162,406,mexico","xnova,390,1187,hongkong","chalicefy,810,289,zurich","alex,534,96,jakarta","chalicefy,768,1412,moscow","chalicefy,594,840,milan","xnova,844,1048,luxembourg","xnova,15,274,tokyo","alex,756,1473,hongkong","alex,54,1760,singapore","xnova,353,1644,zurich","lee,353,475,zurich","lee,973,1591,munich","bob,262,120,hongkong","alex,759,31,barcelona","bob,257,803,mexico","alex,353,1074,prague","lee,854,604,chicago","lee,354,140,warsaw","lee,827,521,prague","chalicefy,73,439,zurich","bob,365,899,shanghai","chalicefy,490,1473,beijing","lee,115,531,rome","maybe,358,774,istanbul","xnova,95,824,frankfurt","lee,532,712,hongkong","lee,766,616,newdelhi","lee,231,1150,zurich","maybe,237,71,bangkok","bob,255,747,taipei","lee,520,1825,montreal","bob,744,401,guangzhou","alex,284,877,toronto","maybe,129,1999,frankfurt","xnova,293,294,jakarta","chalicefy,283,901,beijing","lee,884,881,luxembourg","alex,168,1279,shenzhen","alex,348,1434,rome","iris,958,537,paris"};

		List<String> lt = invalidTransactions(transactions);
		for(int i=0;i<lt.size();i++)
		{
			System.out.println(lt.get(i));
		}

	}

	public static List<String> invalidTransactions(String[] transactions) {

		HashMap<String, List<trans>> hm = new HashMap<String, List<trans>>();

		for (int i = 0; i < transactions.length; i++) {

			String temp[] = transactions[i].split(",");
			trans tr = new trans();
			tr.time = Integer.parseInt(temp[1]);
			tr.amount = Integer.parseInt(temp[2]);
			tr.city = temp[3];

			if (hm.containsKey(temp[0]) == false) {
				List<trans> lt = new ArrayList<trans>();
				lt.add(tr);
				hm.put(temp[0], lt);
			} else {
				List<trans> lt = hm.get(temp[0]);
				lt.add(tr);
			}
		}
		
		
		
		
		for (Map.Entry<String, List<trans>> me : hm.entrySet()) {
			List<trans> lt = me.getValue();
			Collections.sort(lt, new Comparator<trans>() {

				public int compare(trans o1, trans o2) {
					// TODO Auto-generated method stub
					return o1.time - o2.time;

				}

			});
		}
//		for (Map.Entry<String, List<trans>> me : hm.entrySet()) {
//			List<trans> lt = me.getValue();
//			System.out.println(lt.get(0).time);
//			System.out.println(lt.get(1).time);
//		}

		for (Map.Entry<String, List<trans>> me : hm.entrySet()) {
			List<trans> lt = me.getValue();
			int k = 0;
			while (k < lt.size()) {
				trans a = lt.get(k);
				k++;
				if (a.amount > 1000)
					a.ans = true;
				if (k < lt.size()) {
					trans b = lt.get(k);
					k++;
					if (b.amount > 1000)
						b.ans = true;

					if (Math.abs(a.time - b.time) <= 60
							&& a.city.equals(b.city) == false) {
						a.ans = true;
						b.ans = true;
					}

				}
				
				
				
			}
			if(lt.size()>=2){
				trans a = lt.get(lt.size()-1);
				trans b = lt.get(lt.size()-2);
				k++;
				
				if (b.amount > 1000)
					b.ans = true;

				if (Math.abs(a.time - b.time) <= 60
						&& a.city.equals(b.city) == false) {
					a.ans = true;
					b.ans = true;
				}
			}
		}
		List<String> lt2 = new ArrayList<String>();
		for (Map.Entry<String, List<trans>> me : hm.entrySet()) {
			List<trans> lt = me.getValue();
			int k = 0;

			while (k < lt.size()) {
				trans a = lt.get(k);
				k++;

				if (a.ans == true) {
					String ans = me.getKey() + "," + a.time + "," + a.amount
							+ "," + a.city;
					lt2.add(ans);
				}
			}
		}

		Collections.sort(lt2, new Comparator<String>() {

			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				String temp1[] = o1.split(",");
				String temp2[] = o2.split(",");
				return temp1[0].compareTo(temp1[0]);

			}

		});
		return lt2;

	}
}
