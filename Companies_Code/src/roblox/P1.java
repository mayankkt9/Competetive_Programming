package roblox;

import java.util.Stack;

public class P1 {
	public static void main(String[] args) {

		String pre_exp = "*-A/BC-/AKL";
		System.out.println("Postfix : " + preToPost(pre_exp));
	}

	static boolean checkOp(char x) {
		switch (x) {
		case '+':
		case '-':
		case '/':
		case '*':
			return true;
		}
		return false;
	}

	static String preToPost(String input) {

		Stack<StringBuilder> stack = new Stack<StringBuilder>();
		int lt = input.length();
		for (int i = lt - 1; i >= 0; i--) {
			if (checkOp(input.charAt(i))) {
				StringBuilder op1 = stack.peek();
				stack.pop();
				StringBuilder op2 = stack.peek();
				stack.pop();

				StringBuilder calculate = op1.append(op2).append(input.charAt(i));
				stack.push(calculate);
			} else {
				stack.push(new StringBuilder(input.charAt(i) + ""));
			}
		}
		return String.valueOf(stack.peek());
	}
}