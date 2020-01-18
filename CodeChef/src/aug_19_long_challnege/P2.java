package aug_19_long_challnege;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class P2 {
	public static void main(String[] args) throws IOException {
		Scan scan = new Scan();
		Print print = new Print();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				System.out));
		int t = scan.scanInt();

		while (t > 0) {
			long n = scan.scanLong();
			long k = scan.scanLong();

			//System.out.println("THISSSSSS"+n);
			BigInteger n1 = new BigInteger(String.valueOf(n));
			BigInteger k1 = new BigInteger(String.valueOf(k));

			BigInteger k2 = k1.multiply(k1);
			BigInteger modulo = n1.mod(k2);

			long val = modulo.longValue();

			if (val == 0)
				System.out.println("NO");
			else
				System.out.println("YES");

			t--;
		}
	}
}
