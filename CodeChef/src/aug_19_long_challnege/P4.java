package aug_19_long_challnege;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;

public class P4 {
	public static void main(String[] args) throws IOException {
		Scan scan = new Scan();
		Print print = new Print();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				System.out));
		int t = scan.scanInt();

		while (t > 0) {
			int n = scan.scanInt();
			int a[] = new int[n];
			int c[] = new int[n];
			HashMap<Integer, Integer> hm = new HashMap<>(n);
			for (int i = 0; i < n; i++) {
				a[i] = scan.scanInt();
			}
			for (int i = 0; i < n; i++) {
				int b = scan.scanInt();
				hm.put(b, hm.getOrDefault(b, 0) + 1);
			}
			for (int i = 0; i < n; i++) {
				if (i - a[i] < 0)
					c[0] += 1;
				else
					c[i - a[i]] += 1;

				if (i + a[i] + 1 < n)
					c[i + a[i] + 1] -= 1;
			}
			for (int i = 1; i < n; i++) {
				c[i] += c[i - 1];
			}

			int flag=1;
			for (int i = 0; i < n; i++) {

				if (hm.containsKey(c[i]) && hm.get(c[i])>0) {
					hm.put(c[i], hm.get(c[i])-1);
				}
				else
				{
					flag=0;
					break;
				}
			}
			if(flag==1){
				System.out.println("YES");
			}
			else{
				System.out.println("NO");
			}

			hm = null;
			t--;

		}
	}
}
