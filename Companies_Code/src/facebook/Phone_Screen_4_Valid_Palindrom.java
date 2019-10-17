package facebook;

public class Phone_Screen_4_Valid_Palindrom {
	public static void main(String[] args) {

	}

	public boolean validPalindrome(String s) {
		int i = 0;
		for (i = 0; i < s.length(); i++) {
			if (s.charAt(i) == s.charAt(s.length() - 1 - i))
				continue;
			else
				break;
		}
		int temp1 = i + 1;
		int temp2 = s.length() - i - 1;
		int temp3 = i;
		int temp4 = s.length() - 1 - i - 1;

		int flag = 0;
		for (int j = temp1; j <= temp2; j++) {
			if (s.charAt(j) == s.charAt(temp2)) {
				temp2--;
				continue;
			} else {
				flag = 1;
				break;
			}
		}
		if (flag == 0)
			return true;

		flag = 0;
		for (int j = temp3; j <= temp4; j++) {
			if (s.charAt(j) == s.charAt(temp4)) {
				temp4--;
				continue;
			} else {
				flag = 1;
				break;
			}
		}

		if (flag == 0)
			return true;
		else
			return false;

	}
}
