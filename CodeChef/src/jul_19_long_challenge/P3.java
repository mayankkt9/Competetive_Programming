package jul_19_long_challenge;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class P3 {
	public static void main(String[] args) throws IOException {

		Scan scan = new Scan();
		Print print = new Print();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				System.out));
		int t = scan.scanInt();

		while (t > 0) {
			t--;

			Set<Integer> hs = new HashSet<>();
			int q = scan.scanInt();
			int E = 0, O = 0;
			while (q > 0) {
				q--;
				Set<Integer> temp = new HashSet<>();
				int X = scan.scanInt();

				if (hs.contains(X) == false) {
					for (Integer i : hs) {

						int xor1 = X ^ i;
						if (hs.contains(xor1) == false
								&& temp.contains(xor1) == false) {
							int bitCount = Integer.bitCount(xor1);
							if (bitCount % 2 == 0)
								E++;
							else
								O++;
							temp.add(xor1);
						}
					}

					hs.addAll(temp);
					temp=null;
					if (hs.contains(X) == false) {
						if (Integer.bitCount(X) % 2 == 0)
							E++;
						else
							O++;
					}
					hs.add(X);
				}
				System.out.println(E + " " + O);
				

			}
		}

	}
}
