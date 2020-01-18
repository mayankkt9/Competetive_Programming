package matrix;

import java.util.Arrays;
import java.util.Stack;

public class LC_84_Largest_Rectangle_in_Histogram_2 {
	public static void main(String[] args) {

	}
}

class Solution {
	public int largestRectangleArea(int[] heights) {

		// return method1(heights);
		return method2(heights);
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

	public int method1(int heights[]) {
		if (heights.length == 0)
			return 0;
		int ans = 0;
		int n = heights.length;
		int left[] = new int[n];
		int right[] = new int[n];
		getLeft(heights, left);
		getRight(heights, right);

		System.out.println(Arrays.toString(left));
		System.out.println(Arrays.toString(right));

		for (int i = 0; i < heights.length; i++) {
			ans = Math.max(ans, heights[i] * (right[i] - left[i] - 1));
		}
		return ans;
	}

	public void getRight(int arr[], int right[]) {

		Stack<Integer> s = new Stack();
		s.add(0);
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] >= arr[s.peek()]) {
				s.push(i);
				continue;
			}
			while (!s.isEmpty() && arr[s.peek()] > arr[i]) {
				right[s.peek()] = i;
				s.pop();
			}
			s.push(i);
		}
		while (!s.isEmpty()) {
			right[s.peek()] = arr.length;
			s.pop();
		}
	}

	public void getLeft(int arr[], int left[]) {

		Stack<Integer> s = new Stack();
		s.add(arr.length - 1);
		for (int i = arr.length - 2; i >= 0; i--) {
			if (arr[i] >= arr[s.peek()]) {
				s.push(i);
				continue;
			}
			while (!s.isEmpty() && arr[s.peek()] > arr[i]) {
				left[s.peek()] = i;
				s.pop();
			}
			s.push(i);
		}
		while (!s.isEmpty()) {
			left[s.peek()] = -1;
			s.pop();
		}
	}

}