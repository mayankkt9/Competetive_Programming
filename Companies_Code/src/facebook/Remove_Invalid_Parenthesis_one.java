package facebook;
import java.util.Arrays;

public class Remove_Invalid_Parenthesis_one {
	public static void main(String[] args) {

		System.out.println(balanceParens("(())))"));
	}

	public static String balanceParens(String str) {
		int n = str.length();
		StringBuilder sb = new StringBuilder(n);
		boolean[] remove = new boolean[n];
		int open = 0;
		for (int i = 0; i < n; i++) {
			if (str.charAt(i) == '(') {
				open++;
			} else if (str.charAt(i) == ')') {
				if (open > 0) {
					open--;
				} else {
					remove[i] = true;
				}
			}
		}
		System.out.println(Arrays.toString(remove));
		int close = 0;
		for (int i = n - 1; i >= 0; i--) {
			if (str.charAt(i) == ')') {
				close++;
			} else if (str.charAt(i) == '(') {
				if (close > 0) {
					close--;
				} else {
					remove[i] = true;
				}
			}
		}

		System.out.println(Arrays.toString(remove));
		for (int i = 0; i < n; i++) {
			if (!remove[i])
				sb.append(str.charAt(i));
		}

		return sb.toString();
	}
}
