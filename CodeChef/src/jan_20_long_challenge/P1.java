package jan_20_long_challenge;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;

public class P1 {
	public static void main(String[] args) throws IOException {
		Scan scan = new Scan();
		Print print = new Print();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = scan.scanInt();

		while (t > 0) {
			int max = 0;
			int S = scan.scanInt();
			int W1 = scan.scanInt();
			int W2 = scan.scanInt();
			int W3 = scan.scanInt();

			if (W1 + W2 + W3 <= S)
				System.out.println("1");
			else if (W1 + W2 <= S || W2 + W3 <= S)
				System.out.println("2");
			else
				System.out.println("3");
			t--;
		}
	}
}

class Scan {
	private byte[] buf = new byte[1024];
	private int index;
	private InputStream in;
	private int total;

	public Scan() {
		in = System.in;
	}

	public int scan() throws IOException {
		if (total < 0)
			throw new InputMismatchException();
		if (index >= total) {
			index = 0;
			total = in.read(buf);
			if (total <= 0)
				return -1;
		}
		return buf[index++];
	}

	public int scanInt() throws IOException {
		int integer = 0;
		int n = scan();
		while (isWhiteSpace(n))
			n = scan();
		int neg = 1;
		if (n == '-') {
			neg = -1;
			n = scan();
		}
		while (!isWhiteSpace(n)) {
			if (n >= '0' && n <= '9') {
				integer *= 10;
				integer += n - '0';
				n = scan();
			} else
				throw new InputMismatchException();
		}
		return neg * integer;
	}

	public double scanDouble() throws IOException {
		double doub = 0;
		int n = scan();
		while (isWhiteSpace(n))
			n = scan();
		int neg = 1;
		if (n == '-') {
			neg = -1;
			n = scan();
		}
		while (!isWhiteSpace(n) && n != '.') {
			if (n >= '0' && n <= '9') {
				doub *= 10;
				doub += n - '0';
				n = scan();
			} else
				throw new InputMismatchException();
		}
		if (n == '.') {
			n = scan();
			double temp = 1;
			while (!isWhiteSpace(n)) {
				if (n >= '0' && n <= '9') {
					temp /= 10;
					doub += (n - '0') * temp;
					n = scan();
				} else
					throw new InputMismatchException();
			}
		}
		return doub * neg;
	}

	public String scanString() throws IOException {
		StringBuilder sb = new StringBuilder();
		int n = scan();
		while (isWhiteSpace(n))
			n = scan();
		while (!isWhiteSpace(n)) {
			sb.append((char) n);
			n = scan();
		}
		return sb.toString();
	}

	private boolean isWhiteSpace(int n) {
		if (n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1)
			return true;
		return false;
	}
}

class Print {
	private final OutputStream out;

	/*
	 * public Print(OutputStream outputStream) { writer=new PrintWriter(new
	 * BufferedWriter(new OutputStreamWriter(outputStream))); }
	 */
	public Print() {
		this.out = System.out;
	}

	public void print(String str) throws IOException {
		// buf=str.getBytes();
		for (int i = 0; i < str.length(); i++) {
			/*
			 * if (i != 0) out.write(' ');
			 */
			out.write(str.charAt(i));
		}
	}

	public void printLine(String str) throws IOException {
		print(str);
		out.write('\n');
	}

	public void close() throws IOException {
		out.close();
	}
}
