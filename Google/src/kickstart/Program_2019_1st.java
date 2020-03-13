package kickstart;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

public class Program_2019_1st {
	public static void main(String[] args) throws IOException {
		Scan scan = new Scan();
		Print print = new Print();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = scan.scanInt();
		int itr = 1;
		while (t > 0) {
			int numStu = scan.scanInt();
			int pick = scan.scanInt();
			int skill[] = new int[numStu];

			for (int i = 0; i < numStu; i++) {
				skill[i] = scan.scanInt();
			}
			Arrays.sort(skill);
			int max = 0;
			long sum = 0;
			long min = Long.MAX_VALUE;

			int currentSum = 0;
			for (int i = 0; i < pick; i++) {
				currentSum += skill[i];
			}
			int val = skill[pick - 1] * pick;
			if ((val - currentSum) < min)
				min = val - currentSum;
			for (int i = pick; i < numStu; i++) {
				currentSum = currentSum + skill[i] - skill[i - pick];
				val = skill[i] * pick;
				if (val - currentSum < min)
					min = val - currentSum;
			}

			System.out.println("Case #" + itr + ": " + min);
			itr++;
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

	public long scanLong() throws IOException {
		long integer = 0;
		long n = scan();
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

	private boolean isWhiteSpace(long n) {
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

//O(NXP)
//package kickstart;
//
//import java.io.BufferedWriter;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.io.OutputStreamWriter;
//import java.util.Arrays;
//import java.util.InputMismatchException;
//
//public class Program_2019_1st {
//	public static void main(String[] args) throws IOException {
//		Scan scan = new Scan();
//		Print print = new Print();
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		int t = scan.scanInt();
//		int itr = 1;
//		while (t > 0) {
//			int numStu = scan.scanInt();
//			int pick = scan.scanInt();
//			int skill[] = new int[numStu];
//
//			for (int i = 0; i < numStu; i++) {
//				skill[i] = scan.scanInt();
//			}
//			Arrays.sort(skill);
////3 5
//			int max = 0;
//			long sum = 0;
//			long min = Long.MAX_VALUE;
//			for (int i = pick - 1; i < numStu; i++) {
//				max = skill[i];
//				sum = 0;
//				for (int j = i; j > i - pick; j--) {
//					sum += max - skill[j];
//				}
//				if (sum < min)
//					min = sum;
//
//			}
//			System.out.println("Case #" + itr + ": " + min);
//			itr++;
//			t--;
//		}
//	}
//}
//
//class Scan {
//	private byte[] buf = new byte[1024];
//	private int index;
//	private InputStream in;
//	private int total;
//
//	public Scan() {
//		in = System.in;
//	}
//
//	public int scan() throws IOException {
//		if (total < 0)
//			throw new InputMismatchException();
//		if (index >= total) {
//			index = 0;
//			total = in.read(buf);
//			if (total <= 0)
//				return -1;
//		}
//		return buf[index++];
//	}
//
//	public int scanInt() throws IOException {
//		int integer = 0;
//		int n = scan();
//		while (isWhiteSpace(n))
//			n = scan();
//		int neg = 1;
//		if (n == '-') {
//			neg = -1;
//			n = scan();
//		}
//		while (!isWhiteSpace(n)) {
//			if (n >= '0' && n <= '9') {
//				integer *= 10;
//				integer += n - '0';
//				n = scan();
//			} else
//				throw new InputMismatchException();
//		}
//		return neg * integer;
//	}
//
//	public long scanLong() throws IOException {
//		long integer = 0;
//		long n = scan();
//		while (isWhiteSpace(n))
//			n = scan();
//		int neg = 1;
//		if (n == '-') {
//			neg = -1;
//			n = scan();
//		}
//		while (!isWhiteSpace(n)) {
//			if (n >= '0' && n <= '9') {
//				integer *= 10;
//				integer += n - '0';
//				n = scan();
//			} else
//				throw new InputMismatchException();
//		}
//		return neg * integer;
//	}
//
//	public double scanDouble() throws IOException {
//		double doub = 0;
//		int n = scan();
//		while (isWhiteSpace(n))
//			n = scan();
//		int neg = 1;
//		if (n == '-') {
//			neg = -1;
//			n = scan();
//		}
//		while (!isWhiteSpace(n) && n != '.') {
//			if (n >= '0' && n <= '9') {
//				doub *= 10;
//				doub += n - '0';
//				n = scan();
//			} else
//				throw new InputMismatchException();
//		}
//		if (n == '.') {
//			n = scan();
//			double temp = 1;
//			while (!isWhiteSpace(n)) {
//				if (n >= '0' && n <= '9') {
//					temp /= 10;
//					doub += (n - '0') * temp;
//					n = scan();
//				} else
//					throw new InputMismatchException();
//			}
//		}
//		return doub * neg;
//	}
//
//	public String scanString() throws IOException {
//		StringBuilder sb = new StringBuilder();
//		int n = scan();
//		while (isWhiteSpace(n))
//			n = scan();
//		while (!isWhiteSpace(n)) {
//			sb.append((char) n);
//			n = scan();
//		}
//		return sb.toString();
//	}
//
//	private boolean isWhiteSpace(int n) {
//		if (n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1)
//			return true;
//		return false;
//	}
//
//	private boolean isWhiteSpace(long n) {
//		if (n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1)
//			return true;
//		return false;
//	}
//}
//
//class Print {
//	private final OutputStream out;
//
//	/*
//	 * public Print(OutputStream outputStream) { writer=new PrintWriter(new
//	 * BufferedWriter(new OutputStreamWriter(outputStream))); }
//	 */
//	public Print() {
//		this.out = System.out;
//	}
//
//	public void print(String str) throws IOException {
//		// buf=str.getBytes();
//		for (int i = 0; i < str.length(); i++) {
//			/*
//			 * if (i != 0) out.write(' ');
//			 */
//			out.write(str.charAt(i));
//		}
//	}
//
//	public void printLine(String str) throws IOException {
//		print(str);
//		out.write('\n');
//	}
//
//	public void close() throws IOException {
//		out.close();
//	}
//}
