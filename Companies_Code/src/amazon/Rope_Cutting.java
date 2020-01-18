package amazon;

import java.util.PriorityQueue;

public class Rope_Cutting {
	public static void main(String[] args) {

		int rope[] = { 20, 4, 8, 2 };
		int x = solve(rope);
		System.out.println(x);
	}

	private static int solve(int[] rope) {
		// TODO Auto-generated method stub

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < rope.length; i++) {
			pq.add(rope[i]);
		}
		int res = 0;
		while (pq.size() != 1) {
			int a = pq.poll();
			int b = pq.poll();
			res += a + b;
			pq.offer(a + b);
		}

		return res;
	}

}
