package codejam_2020_roun1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;

public class P2 {
	static int size = 10;

	public static void main(String[] args) throws IOException {
		Scan scan = new Scan();
		Print print = new Print();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = scan.scanInt();
		int itr = 1;
		while (t > 0) {
			int sum = scan.scanInt();

			int arr[][] = printPascal(size);
			Solve obj = new Solve();
			obj.dfs(arr, 0, 0, sum);
			// System.out.println(obj.res);
			// System.out.println(Arrays.deepToString(arr));
			System.out.println("Case #" + itr + ": ");
			for (int x[] : obj.res) {
				System.out.println(x[0] + " " + x[1]);
			}
			itr++;
			t--;

		}
	}

	public static int[][] printPascal(int n) {

		int[][] arr = new int[n][n];
		for (int line = 0; line < n; line++) {

			for (int i = 0; i <= line; i++) {
				if (line == i || i == 0)
					arr[line][i] = 1;
				else
					arr[line][i] = arr[line - 1][i - 1] + arr[line - 1][i];

			}

		}
		return arr;

	}

}

class Solve {
	static int size = 10;
	boolean visited[][] = new boolean[size][size];
	List<int[]> current = new ArrayList<>();
	List<int[]> res = new ArrayList<>();
	int vec[][] = new int[][] { { -1, 0 }, { -1, -1 }, { 0, -1 }, { 0, 1 }, { 1, 0 }, { 1, 1 } };

	public void dfs(int arr[][], int i, int j, int sum) {
		if (i < 0 || i >= size || j < 0 || j > i || sum < 0 || visited[i][j])
			return;

		visited[i][j] = true;
		sum = sum - arr[i][j];
		current.add(new int[] { i, j });
		if (sum == 0) {
			res = new ArrayList<>(current);
			return;
		}

		for (int x[] : vec) {

			int row = i + x[0];
			int col = j + x[1];
			dfs(arr, row, col, sum);
		}

		visited[i][j] = false;
		current.remove(current.size() - 1);

//		dfs(arr, i - 1, j, sum);
//		dfs(arr, i - 1, j - 1, sum);
//		dfs(arr, i, j - 1, sum);
//		dfs(arr, i, j + 1, sum);
//		dfs(arr, i + 1, j, sum);
//		dfs(arr, i + 1, j + 1, sum);

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
