import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Even_Index_Try {
	public static void main(String[] args) {

		int n = 1000;

		List<Integer> lt = new LinkedList<>();

		for (int i = 1; i <= n; i++) {
			lt.add(i);
		}

		ListIterator<Integer> r;
		System.out.println(lt);
		while (lt.size() > 1) {

			int i = 0;
			while (i < lt.size()) {
				lt.remove(i);
				i=i+1;
			}
			System.out.println(lt);
			// System.out.println(lt.size());
		}

	}
}
