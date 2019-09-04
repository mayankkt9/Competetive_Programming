package jul_19_long_challenge;

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
			t--;

			// long n = scan.scanInt();
			BigInteger nb = new BigInteger(scan.scanString());
			BigInteger kb = new BigInteger(scan.scanString());

			BigInteger a = kb.divide(nb);
			
			//System.out.println(a);
			BigInteger xb = nb.multiply(a.add(BigInteger.ONE)).subtract(kb);
			//System.out.println(xb);
			BigInteger sum = BigInteger.ZERO;
			BigInteger two = new BigInteger("2");
			if (nb.subtract(xb).compareTo(xb)==1) {
				sum = xb.multiply(two);
			} else if (nb.subtract(xb).compareTo(xb)==-1) {
				sum = nb.subtract(xb).multiply(two);
			} else {
				sum = xb.multiply(two).subtract(BigInteger.ONE);
			}
			System.out.println(sum);

		}

	}
}



