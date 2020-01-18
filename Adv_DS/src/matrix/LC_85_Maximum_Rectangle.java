package matrix;

public class LC_85_Maximum_Rectangle {
	public static void main(String[] args) {

	}
}

class Solution {
	public int maximalRectangle(char[][] matrix) {
		if (matrix.length == 0)
			return 0;
		int n = matrix.length;
		int m = matrix[0].length;
		int height[] = new int[m];
		int area = 0, max = 0;
		System.out.println((int) matrix[0][0]);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int temp = ((int) matrix[i][j]) - 48;
				int temp2 = height[j];
				// System.out.println(temp);
				// height[j]= temp + matrix[i][j]=='0'?0:temp2;
				if (matrix[i][j] == '0')
					height[j] = 0;
				else
					height[j] += 1;
			}

			// System.out.println(Arrays.toString(height));
			area = method2(height);
			if (area > max)
				max = area;
		}
		return max;
	}

	public int method2(int heights[]) {
		if (heights.length == 0)
			return 0;
		Stack<Integer> s = new Stack();
		s.add(0);
		int area = 0, max = 0;
		int temp = 0;
		int i;
		for (i = 1; i < heights.length; i++) {
			if (heights[i] >= heights[s.peek()]) {
				s.push(i);
				continue;
			}

			while (!s.isEmpty() && heights[i] < heights[s.peek()]) {
				area = 0;
				temp = s.pop();
				if (s.isEmpty())
					area = heights[temp] * i;
				else
					area = heights[temp] * (i - s.peek() - 1);

				if (area > max)
					max = area;
			}
			s.push(i);

		}
		while (!s.isEmpty()) {
			area = 0;
			temp = s.pop();
			if (s.isEmpty())
				area = heights[temp] * i;
			else
				area = heights[temp] * (i - s.peek() - 1);

			if (area > max)
				max = area;
		}
		return max;

	}
}
