package random_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Neu_2_greedy1 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		HashMap<Integer, HashSet<Integer>> adjList = new HashMap<Integer, HashSet<Integer>>();
		int n = sc.nextInt();
		int people[] = new int[n];

		for (int i = 0; i < n; i++) {
			people[i] = sc.nextInt();
			adjList.put(people[i], new HashSet<Integer>());
		}

		int m = sc.nextInt();
		int pairs[][] = new int[m][2];

		for (int i = 0; i < m; i++) {
			pairs[i][0] = sc.nextInt();
			pairs[i][1] = sc.nextInt();

			if (adjList.containsKey(pairs[i][0]) && adjList.containsKey(pairs[i][1])) {
				HashSet<Integer> list1 = adjList.get(pairs[i][0]);
				if (!list1.contains(pairs[i][1]))
					list1.add(pairs[i][1]);
				HashSet<Integer> list2 = adjList.get(pairs[i][1]);
				if (!list2.contains(pairs[i][0]))
					list2.add(pairs[i][0]);

			} else {
				System.out.println("No such friend exist");
			}

		}

		List<Integer> totalPeople = new ArrayList<Integer>();
		for (int i = 0; i < people.length; i++)
			totalPeople.add(people[i]);
		System.out.println();
		System.out.println(totalPeople);
		System.out.println(adjList);
		List<Integer> answer = solve(adjList, totalPeople);
		System.out.println(answer);
		sc.close();

	}

	public static List<Integer> solve(HashMap<Integer, HashSet<Integer>> adjList, List<Integer> totalPeople) {

		int n = totalPeople.size();
		boolean change = false;
		do {
			change = false;
			n = totalPeople.size();
			for (int i = 0; i < totalPeople.size(); i++) {
				int currentSize = adjList.size();
				//System.out.println(totalPeople+" "+i);
				int knownFriends = adjList.get(totalPeople.get(i)).size();
				int unknownFriends = currentSize - knownFriends;
				if (knownFriends < 4 || unknownFriends < 4) {
					HashSet<Integer> friend = adjList.get(totalPeople.get(i));
					for(Integer ing : friend) {
						adjList.get(ing).remove(totalPeople.get(i));
					}
					adjList.remove(totalPeople.get(i));
					totalPeople.remove(i);
					change = true;
				}
			}
		} while (change);
		return totalPeople;
	}
}

/*


14
1 2 3 4 5 6 7 8 9 10 11 12 13 14
 
 22
 1 2
 1 3
 1 4
 1 13
 2 13
 3 13
 4 13
 2 3 
 2 4
 3 4
 5 6
 5 7
 5 8
 6 7
 6 8
 7 8
 5 14
 6 14
 7 14
 8 14
 9 10
 11 12
 
 output 
[1, 2, 3, 4, 5, 6, 7, 8, 13, 14]



 */
