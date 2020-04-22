//package codejam_2019_round1;
//
//import java.io.BufferedWriter;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.io.OutputStreamWriter;
//import java.util.ArrayList;
//import java.util.InputMismatchException;
//import java.util.Random;
//
//public class P1 {
//	public static void main(String[] args) throws IOException {
//		Scan scan = new Scan();
//		Print print = new Print();
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		int t = scan.scanInt();
//		int itr = 1;
//		while (t > 0) {
//			int r = scan.scanInt();
//			int c = scan.scanInt();
//			Solve obj = new Solve(r, c);
//			ArrayList<Point> res = obj.start(r, c);
//			if (res == null)
//				System.out.println("Case #" + itr + ": IMPOSSIBLE");
//			else {
//				System.out.println("Case #" + itr + ": POSSIBLE");
//				for (Point p : res) {
//					System.out.println(p.x + " " + p.y);
//				}
//			}
//			itr++;
//			t--;
//
//		}
//	}
//
//}
//
//class Solve {
//
//	ArrayList<Point> res;
//	ArrayList<Point> cur;
//	int count;
//	boolean visited[][];
//	Random rand;
//
//	public Solve(int r, int c) {
//		res = new ArrayList<>();
//		cur = new ArrayList<>();
//		count = 0;
//		visited = new boolean[r][c];
//		rand = new Random();
//	}
//
//	public boolean dfs(int r, int c, int rowLen, int colLen) {
//
//		if (r < 0 || c < 0 || r >= rowLen || c >= colLen)
//			return false;
//		cur.add(new Point(r + 1, c + 1));
//		visited[r][c] = true;
//		count++;
//		if (count == rowLen * colLen) {
//			res = new ArrayList<>(cur);
//			return true;
//		}
//		boolean flag = false;
//		int k = 1;
//		while (k < 50) {
//			
//			int i = Math.abs(rand.nextInt()) % rowLen;
//			int j = Math.abs(rand.nextInt()) % colLen;
//
//			if (i != r && j != c && r - c != i - j && r + c != i + j && !visited[i][j]) {
//				flag = flag || dfs(i, j, rowLen, colLen);
//			}
//			k++;
//		}
//
//		cur.remove(cur.size() - 1);
//		visited[r][c] = false;
//		count--;
//		return flag;
//	}
//
//	public ArrayList<Point> start(int r, int c) {
//		for (int i = 0; i < r; i++) {
//			for (int j = 0; j < c; j++) {
//				if (dfs(i, j, r, c) && res.size() == r * c) {
//					return res;
//				}
//			}
//		}
//		return null;
//	}
//}
//
//class Point {
//	int x;
//	int y;
//
//	public Point(int x, int y) {
//		this.x = x;
//		this.y = y;
//	}
//
//	public String toString() {
//		return "(" + x + "," + y + ")";
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
