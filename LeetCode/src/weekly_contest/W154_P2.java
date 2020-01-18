package weekly_contest;

import java.util.Stack;

public class W154_P2 {
	public static void main(String[] args) {

		String s = "yh(())";

		System.out.println(reverseParentheses(s));
	}

	public static String reverseParentheses(String s) {

		Stack<String> st = new Stack<String>();
		String sb = new String(s);
		for (int i = 0; i < sb.length(); i++) {

			if (sb.charAt(i) == '(') {
				st.add(new String("("));
			} else if (sb.charAt(i) == ')') {
				
				if(st.size()>0 && st.peek().charAt(0)=='('){
					st.pop();
					continue;
				}
				String temp = st.pop();
				temp = reverse(temp);
				if (st.peek() != null && st.peek().equals(new String("("))) {
					st.pop();
				}

				if (st.size()>0 && st.peek().equals(new String("(")) == false) {
					String temp1 = st.pop();
					temp = temp1 + temp;
					
				}
				st.push(new String(temp));
			} else {
				//System.out.println(st.peek());
				if (st.size()>0 && st.peek().charAt(0) == '(')
					st.push(String.valueOf(sb.charAt(i)));
				else {
					String temp="";
					if(st.size()>0)
						temp = st.pop();
					temp = temp + sb.charAt(i);
					st.push(temp);
				}
			}

		}
		return st.peek().toString();
	}

	public static String reverse(String str) {
		if (str.length() <= 1) {
			return str;
		}
		return reverse(str.substring(1)) + str.charAt(0);
	}
}



