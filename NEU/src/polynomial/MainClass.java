package polynomial;

import java.util.Arrays;

public class MainClass {
	public static void main(String[] args) {

		String input = "3x2 - 5 + 2x - 18";
		input = "+ " + input;
		String input_2 = "";
		input_2 += input.charAt(0);
		for (int i = 1; i < input.length() - 1; i++) {
			if ((input.charAt(i - 1) == '+' || input.charAt(i - 1) == '-')
					&& ((Character.isDigit(input.charAt(i + 1))) || input
							.charAt(i + 1) == 'x')) {
				continue;
			}
			input_2 += input.charAt(i);
		}
		input_2 += input.charAt(input.length() - 1);

		System.out.println(input_2);
		String word[] = input_2.split(" ");
		System.out.println(Arrays.toString(word));
		Term obj = formTerm("-5x");
		System.out.println(obj);
		Node_Term result = null;
		Node_Term node = recursion(result, word, 0);
		System.out.println("1");

	}

	private static Node_Term recursion(Node_Term list,String[] word, int i) {
		// TODO Auto-generated method stub
		if (i == word.length) {
			return  null;
		}
		Term obj = formTerm(word[i]);
		list=new Node_Term();
		list.term=obj;
		list.list=recursion(list.list, word, i+1);
		return list;
	}

	private static Term formTerm(String str) {
		Term obj = new Term();

		String coefficient = "";
		String power = "0";
		int j;
		for (j = 1; j < str.length(); j++) {
			if (Character.isDigit(str.charAt(j)) == false) {
				break;
			}
			coefficient += str.charAt(j);

		}
		if (j < str.length() && str.charAt(j) == 'x') {
			j++;
			power = "1";
		}
		while (j < str.length()) {
			if (Character.isDigit(str.charAt(j)))
				power += str.charAt(j);
			j++;
		}
		obj.sign = str.charAt(0);
		obj.coefficient = coefficient;
		obj.power = power;
		return obj;
	}
}
