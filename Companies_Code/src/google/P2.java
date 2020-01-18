package google;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class P2 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int test = 1;
		while (test <= t) {
			int n = sc.nextInt(); // number of pages
			int m = sc.nextInt(); // torn out
			int q = sc.nextInt(); // Total reader
			int torn[] = new int[m];
			int reader[] = new int[q];
			HashSet<Integer> hs = new HashSet<>();

			for (int i = 0; i < m; i++) {
				torn[i] = sc.nextInt();
				hs.add(torn[i]);
			}
			for (int i = 0; i < q; i++) {
				reader[i] = sc.nextInt();
			}
			long total_read = 0;
			for (int i = 0; i < q; i++) {
				total_read = total_read + n / reader[i];
			}

			int max = 0;
			for (int i = 0; i < m; i++) {
				max = Math.max(max, torn[i]);
			}

			for (int i = 0; i < q; i++) {
				int x = reader[i];
				int count = 1;
				int y = 0;
				while (y <= max) {
					y = x * count;
					count++;
					if (hs.contains(y))
						total_read--;
				}
			}
			hs = null;
			System.out.println("Case #" + test + ":" + " " + total_read);
			test++;

		}
		sc.close();
	}
}
