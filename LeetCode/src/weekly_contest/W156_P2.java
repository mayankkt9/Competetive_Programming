package weekly_contest;

import java.util.Stack;

class stck {
	char ch;
	int count;

	public stck(char ch, int count) {
		super();
		this.ch = ch;
		this.count = count;
	}

}

public class W156_P2 {
	public static void main(String[] args) {

		String s = "abcd";
		int k = 2;

		Stack<stck> sk = new Stack<stck>();

		for (int i = 0; i < s.length(); i++) {

			if (sk.isEmpty()) {

				sk.push(new stck(s.charAt(i), 1));
				continue;
			}
			if (sk.peek().ch == s.charAt(i) && sk.peek().count == k - 1) {
				int pk = k - 1;
				while (pk > 0) {
					sk.pop();
					pk--;
				}
				
				continue;
			}
			if (sk.peek().ch == s.charAt(i)) {
				sk.push(new stck(s.charAt(i), sk.peek().count + 1));
			} else {
				sk.push(new stck(s.charAt(i), 1));
			}

		}
		String str = "";
		while (sk.isEmpty() == false) {
			str = sk.pop().ch + str;
		}
		System.out.println(str);

	}
}
