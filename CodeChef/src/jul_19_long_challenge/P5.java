package jul_19_long_challenge;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class P5 {
	public static void main(String[] args) throws Throwable {

		Scan scan = new Scan();
		Print print = new Print();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				System.out));
		int t = scan.scanInt();

		while (t > 0) {
			t--;

			int n = scan.scanInt();
			List<Integer> lt = new LinkedList<Integer>();
			for (int i = 0; i < n; i++) {
				int x = scan.scanInt();
				lt.add(x);
			}
			long ans = 0;
			while (lt.size() >= 2) {
				int sum = 0;
				int min = Integer.MAX_VALUE;
				int index = 0;
				for (int i = 0; i < lt.size() - 1; i++) {
					sum = lt.get(i) + lt.get(i + 1);
					if (sum < min) {
						min = sum;
						index = i;
					}
				}
				if (lt.get(0) + lt.get(lt.size() - 1) < min) {
					min = lt.get(0) + lt.get(lt.size() - 1);
					index = -1;
				}
				int more_min = Integer.MAX_VALUE;
				List<Integer> temp = new LinkedList<>();
				if (lt.size() > 2) {
					for (int i = 0; i < lt.size() - 1; i++) {
						sum = lt.get(i) + lt.get(i + 1);
						if (sum == min) {
							int x1 = 0, x2 = 0;
							if (i == 0) {
								x1 = sum + lt.get(lt.size() - 1);
							} else {
								x1 = sum + lt.get(i - 1);
							}
							x2 = sum + lt.get((i + 2) % lt.size());
							
							if(x1<more_min)
							{
								index=i;
								more_min=x1;
							}
							if(x2<more_min)
							{
								index=i;
								more_min=x2;
							}

						}
					}
				}
				ans = ans + min;
				temp=null;
				if (index < 0) {

					lt.remove(0);
					lt.remove(lt.size() - 1);
					lt.add(0, min);
				} else {

					lt.remove(index);
					lt.remove(index);
					lt.add(index, min);
				}

			}
			lt=null;
			System.out.println(ans);
		}
	}
}
