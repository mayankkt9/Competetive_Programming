package akuna_cap;

import java.util.ArrayList;
import java.util.List;

public class GS {
	public static void main(String[] args) {

		String originalString = "abcdefghi";
		List<Integer> direction = new ArrayList<>();
		List<Integer> amount = new ArrayList<>();
		direction.add(0);
		direction.add(0);
		direction.add(0);
		direction.add(0);
		direction.add(0);
		direction.add(1);
		amount.add(1000000000);
		amount.add(1000000000);
		amount.add(1000000000);
		amount.add(1000000000);
		amount.add(1000000000);
		amount.add(1000000000);

		String s = originalString;
		// System.out.println(s);
		long left = 0;
		long right = 0;
		for (int i = 0; i < direction.size(); i++) {
			if (direction.get(i) == 0) {
				left += amount.get(i);
			} else {
				right += amount.get(i);
			}
		}
		System.out.println(left);
		System.out.println(right);

		if (left > right) {
			long temp = (left - right);
			System.out.println(temp);
			temp = temp % s.length();
			int temp2 = (int) temp;
			s = s.substring(temp2, s.length()) + s.substring(0, temp2);
		} else if (right > left) {
			long temp = (right - left);
			temp = temp % s.length();
			int temp2 = (int) temp;
			s = s.substring(s.length() - temp2, s.length())
					+ s.substring(0, s.length() - temp2);
		}
		System.out.println(s);
	}
}
