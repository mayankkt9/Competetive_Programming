package aug_19_long_challnege;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import sun.applet.Main;

public class P5 {
	public static void main(String[] args) throws IOException {
		Scan scan = new Scan();
		Print print = new Print();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				System.out));
		int t = scan.scanInt();

		while (t > 0) {

			int n = scan.scanInt();
			int a[] = new int[n];

			for (int i = 0; i < n; i++) {
				a[i] = scan.scanInt();
			}

			for (int i = 1; i < n; i++) {
				a[i] = a[i] ^ a[i - 1];
			}
			HashMap<Integer, List<Integer>> hm = new HashMap<>();
			List<Integer> l = new ArrayList<>();
			l.add(-1);
			hm.put(0, l);
			long ans = 0;
			for (int i = 0; i < n; i++) {
				if (hm.containsKey(a[i]) == true) {
					List<Integer> lt = hm.get(a[i]);
					lt.add(i);
					hm.put(a[i], lt);
				} else {
					List<Integer> lt = new ArrayList<>();
					lt.add(i);
					hm.put(a[i], lt);
				}

			}

			HashMap<Integer, List<Integer>> hm1 = new HashMap<>();
			List<Integer> lll=new ArrayList<>();
			lll.add(0);
			lll.add(5);
//			lll.add(8);
//			lll.add(11);
			hm1.put(1, lll);
			for (List<Integer> lt : hm1.values()) {
				int n1=lt.size()-1;
				if (lt.size() > 1) {
					for (int j = 1; j < lt.size(); j++) {
						int len = lt.get(j) - lt.get(j - 1);
						ans += ((len - 1) * j) + (len * (n1 - j) * j);
					}
				}
			}

			System.out.println(ans);
			t--;
		}
	}
}