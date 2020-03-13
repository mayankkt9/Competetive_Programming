package weekly_contest;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class W174_P1 {

	public static void main(String[] args) {
		int arr[] = new int[] { 10 };
		// System.out.println(minSetSize(arr));
		// int arr[] = new int[] { 1, 1, 1, 1, 1, 1, 1, 7, 7, 7, 7, 7, 7, 7 };
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(1);
		list.add(1);
		list.add(1);
		list.add(1);
		list.add(1);
		list.add(1);
		list.add(7);
		list.add(7);
		list.add(7);
		list.add(7);
		list.add(7);
		list.add(7);
		list.add(7);

		System.out.println(solve(list));
	}

	public static int minSetSize(int[] arr) {

		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (!hm.containsKey(arr[i]))
				hm.put(arr[i], 1);
			else
				hm.put(arr[i], hm.get(arr[i]) + 1);
		}

		ArrayList<Integer> a = new ArrayList<Integer>();
		// for(Integer a : hm.entrySet())
		for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
			// entry.getValue()
			a.add(entry.getValue());
		}

		Collections.sort(a);
		int c = 0;
		int answer = 0;
		for (int i = a.size() - 1; i >= 0; i--) {
			c += a.get(i);
			answer++;
			if (c >= arr.length / 2)
				return answer;
		}

		// System.out.println(a);
		return 1;
	}

	public static List<String> solve(List<Integer> dailyPrice) {
		dailyPrice.add(0, 0);
		int current_sum = 0; 
		for (int i = 0; i < dailyPrice.size(); i++) {
			current_sum += dailyPrice.get(i);
			dailyPrice.set(i, current_sum);
		}
		List<String> answer = new ArrayList<String>();
		for (int i = 7; i < dailyPrice.size(); i++) {
			int sum = dailyPrice.get(i) - dailyPrice.get(i - 7);
			double avg = sum / 7.0;
			answer.add(String.format( "%.2f", avg ));
		}
		return answer;
	}
}