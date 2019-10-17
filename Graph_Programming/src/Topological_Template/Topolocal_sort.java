package Topological_Template;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;

public class Topolocal_sort {
	public static void main(String[] args) {

		int numCourse = 10;
		int dep_arr[][] = { { 1, 0 }, { 1, 2 }, { 3, 1 }, { 4, 1 }, { 5, 3 },
				{ 6, 3 }, { 7, 4 }, { 8, 4 }, { 9, 5 }, { 9, 6 }, { 9, 8 },
				{ 9, 7 } };
		System.out.println(Arrays.toString(findOrder(numCourse, dep_arr)));

	}

	public static int[] findOrder(int numCourse, int[][] dep_arr) {
		HashMap<Integer, List<Integer>> hs = new HashMap<>();
		int toDegree[] = new int[numCourse];
		Queue<Integer> queue = new ArrayDeque<>();
		int result[] = new int[numCourse];

		for (int i = 0; i < dep_arr.length; i++) {
			toDegree[dep_arr[i][1]]++;
            if (hs.containsKey(dep_arr[i][1])) {
				List<Integer> neighbour = hs.get(dep_arr[i][1]);
				for (int j = 0; j < neighbour.size(); j++) {
					if(neighbour.get(j)==dep_arr[i][0]) return new int[0];
				}
			}
			if (hs.containsKey(dep_arr[i][0]) == false) {
				List<Integer> temp = new ArrayList<>();
				temp.add(dep_arr[i][1]);
				hs.put(dep_arr[i][0], temp);
			} else {
				List<Integer> temp = hs.get(dep_arr[i][0]);
				temp.add(dep_arr[i][1]);
			}
		}
		int flag = 1;
		for (int i = 0; i < toDegree.length; i++) {
			if (toDegree[i] == 0) {
				queue.add(i);
				flag = 0;
			}
		}
		if (flag == 1)
			return new int[0];
		int index = 0;

		while (queue.isEmpty() == false) {
			int poll = queue.poll();
			result[index++] = poll;
			List<Integer> neighbour = hs.get(poll);
			if (neighbour == null) {
				continue;
			}
			for (int i = 0; i < neighbour.size(); i++) {
				toDegree[neighbour.get(i)]--;
				if (toDegree[neighbour.get(i)] == 0) {
					queue.add(neighbour.get(i));

				}
			}

		}
		for (int i = 0; i < result.length / 2; i++) {
			int temp = result[i];
			result[i] = result[result.length - 1 - i];
			result[result.length - 1 - i] = temp;
		}
		return index == numCourse ? result : new int[0];
	}
}
