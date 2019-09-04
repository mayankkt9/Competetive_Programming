package amazon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class Reorder_log_files {
	public static void main(String[] args) {

		String o1 = "Hi! My name is Mayank";
		String y = "Hello";

		// System.out.println(x.split(" ")[1]);

		String logs[] = { "a1 9 2 3 1", "g1 act car", "zo4 4 7",
				"ab1 off key dog", "a8 act zoo" };
		String logs1[]={"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo","a2 act car"};

		// System.out.println(o1.substring(o1.indexOf(" ")+1));

		System.out.println(Arrays.toString(reorderLogFiles(logs1)));

	}

	public static String[] reorderLogFiles(String[] logs) {

		Arrays.sort(logs, new comp());
		return logs;
	}
}

class comp implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub

		String spl1 = o1.substring(o1.indexOf(" ") + 1);
		String spl2 = o2.substring(o2.indexOf(" ") + 1);

		if (Character.isAlphabetic(spl1.charAt(0))
				&& Character.isAlphabetic(spl2.charAt(0))) {

			int temp = spl1.compareTo(spl2);
			if (temp != 0)
				return temp;
			else
				return o1.compareTo(o2);
		}

		if (Character.isAlphabetic(spl1.charAt(0))
				&& Character.isDigit(spl2.charAt(0))) {
			return -1;
		} else if (Character.isAlphabetic(spl2.charAt(0))
				&& Character.isDigit(spl1.charAt(0))) {
			return 1;
		}
		else
			return 0;
	}

}
