package amazon;

import java.util.LinkedList;
import java.util.Queue;

class Point {

	int a;
	int b;

	public Point(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}

}

class QueueNode {
	Point point;
	int distance;

	public QueueNode(Point point, int distance) {
		super();
		this.point = point;
		this.distance = distance;
	}

}

public class BFS_Matrix_Path {

	public static boolean Validate(int row, int col, int rlength, int clength) {
		if (row >= 0 && row < rlength && col >= 0 && col < clength)
			return true;
		return false;

	}

	public static void main(String[] args) {

		char matrix[][] = { { 'O', 'O', 'O', 'O' }, { 'D', 'O', 'D', 'O' },
				{ 'O', 'O', 'O', 'O' }, { 'X', 'D', 'D', 'O' } };

		System.out.println(solve(matrix));
	}

	private static int solve(char[][] matrix) {
		// TODO Auto-generated method stub

		int rlength = matrix.length;
		int clength = matrix[0].length;
		Point source = null, dest = null;

		for (int i = 0; i < rlength; i++) {
			for (int j = 0; j < clength; j++) {
				source = new Point(0, 0);
				if (matrix[i][j] == 'X')
					dest = new Point(i, j);
			}
		}

		return solvePath(matrix, source, dest);
	}

	private static int solvePath(char[][] matrix, Point source, Point dest) {
		// TODO Auto-generated method stub

		int row_vector[] = { -1, 0, 0, 1 };
		int col_vector[] = { 0, -1, 1, 0 };

		int r_length = matrix.length;
		int c_length = matrix[0].length;

		boolean visited[][] = new boolean[r_length][c_length];
		visited[source.a][source.b] = true;

		QueueNode src = new QueueNode(source, 0);
		Queue<QueueNode> queue = new LinkedList<>();

		queue.offer(src);

		while (!queue.isEmpty()) {

			QueueNode tempNode = queue.poll();
			Point tempPoint = tempNode.point;

			if (tempPoint.a == dest.a && tempPoint.b == dest.b)
				return tempNode.distance;

			for (int i = 0; i < 4; i++) {
				int r = tempPoint.a + row_vector[i];
				int c = tempPoint.b + col_vector[i];

				if (Validate(r, c, r_length, c_length) && !visited[r][c]
						&& (matrix[r][c] == 'O' || matrix[r][c] == 'X')) {
					QueueNode O_node = new QueueNode(new Point(r, c),
							tempNode.distance + 1);
					queue.offer(O_node);
					visited[r][c]=true;
				}
			}

		}

		return -1;
	}
}
