package aug_19_long_challnege;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class P3 {
	public static void main(String[] args) throws IOException {

		Scan scan = new Scan();
		Print print = new Print();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				System.out));
		int t = scan.scanInt();

		while (t > 0) {
			String s = scan.scanString();
			int c = 0;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '1')
					c++;
			}
			if (c % 2 == 1)
				System.out.println("WIN");
			else
				System.out.println("LOSE");
			t--;
		}
	}
}
