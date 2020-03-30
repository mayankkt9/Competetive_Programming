package disjoint_ds;

import java.util.Arrays;

public class Disjoint_DS {
	int[] rank, parent;
	int n;

	public Disjoint_DS(int n) {
		rank = new int[n];
		parent = new int[n];
		this.n = n;
		makeSet();
	}

	void makeSet() {
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
	}

	int find(int x) {
		if (parent[x] != x) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}

	void union(int x, int y) {
		int xParent = find(x);
		int yParent = find(y);
		if (xParent == yParent)
			return;
		if (rank[xParent] < rank[yParent])
			parent[xParent] = yParent;
		else if (rank[yParent] < rank[xParent])
			parent[yParent] = xParent;
		else {
			parent[yParent] = xParent;
			rank[xParent] = rank[xParent] + 1;
		}
	}

	void printParent() {
		System.out.println(Arrays.toString(parent));
	}

	public static void main(String[] args) {
		int n = 7;
		Disjoint_DS dj = new Disjoint_DS(n);

		dj.printParent();

		dj.union(0, 1);
		dj.printParent();
		dj.union(3, 4);
		dj.printParent();
		dj.union(2, 3);
		dj.printParent();
		dj.union(1, 5);
		dj.printParent();
		dj.union(2, 4);
		dj.printParent();
		dj.union(0, 3);
		dj.printParent();
		dj.union(2, 6);
		dj.printParent();

	}
}
