package random_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Neu_2_greedy {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		HashMap<Integer, List<Integer>> adjList = new HashMap<Integer, List<Integer>>();
		int n = sc.nextInt();
		int people[] = new int[n];

		for (int i = 0; i < n; i++) {
			people[i] = sc.nextInt();
			adjList.put(people[i], new ArrayList<Integer>());
		}

		int m = sc.nextInt();
		int pairs[][] = new int[m][2];

		for (int i = 0; i < m; i++) {
			pairs[i][0] = sc.nextInt();
			pairs[i][1] = sc.nextInt();

			if (adjList.containsKey(pairs[i][0]) && adjList.containsKey(pairs[i][1])) {
				List<Integer> list1 = adjList.get(pairs[i][0]);
				if (!list1.contains(pairs[i][1]))
					list1.add(pairs[i][1]);
				List<Integer> list2 = adjList.get(pairs[i][1]);
				if (!list2.contains(pairs[i][0]))
					list2.add(pairs[i][0]);

			} else {
				System.out.println("No such friend exist");
			}

		}

		List<Integer> totalPeople = new ArrayList<Integer>();
		for (int i = 0; i < people.length; i++)
			totalPeople.add(people[i]);
		System.out.println(adjList);
		solve(adjList, totalPeople);
		sc.close();

	}

	public static void solve(HashMap<Integer, List<Integer>> adjList, List<Integer> totalPeople) {

		int n = totalPeople.size();
		boolean change = false;
		do {
			change = false;
			n = totalPeople.size();
			for (int i = 0; i < n; i++) {
				int currentSize = adjList.size();
				int knownFriends = adjList.get(totalPeople.get(i)).size();
				int unknownFriends = currentSize - knownFriends;
				if (knownFriends < 4 || unknownFriends < 4) {
					List<Integer> friend = adjList.get(totalPeople.get(i));
					for (int j = 0; j < friend.size(); j++) {
						adjList.get(friend.get(j)).remove(totalPeople.get(i));
					}
					adjList.remove(totalPeople.get(i));
					totalPeople.remove(i);
					change = true;
				}
			}
		} while (change);
	}
}

/*


10
1 2 3 4 5 6 7 8 9 10
 
 21
 1 3
 1 4
 2 3 
 2 5 
 3 9
 4 8
 8 9
 5 6
 3 9
 1 9
 8 3
 9 2
 2 6
 2 8
 2 9
 5 3
 5 8
 6 10
 1 10
 2 10
 9 4
 
 




 */
