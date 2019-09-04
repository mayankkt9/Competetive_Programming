package weekly_contest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class W146_P1 {
	public static void main(String[] args) {

		int arr[][] = new int[][] { { 1, 2 }, { 1, 2 }, { 1, 2 }, { 1, 1 },{ 2, 2 } };
		System.out.println(numEquivDominoPairs(arr));

	}

	private static int numEquivDominoPairs(int[][] arr) {
		// TODO Auto-generated method stub
		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(final int[] entry1, final int[] entry2) {

				if (entry1[0] > entry2[0])
					return 1;
				else if (entry1[0] < entry2[0])
					return -1;
				else
				{
					if(entry1[1] > entry2[1])
						return 1;
					else if(entry1[1] < entry2[1])
						return -1;
					return 0;
				}
			}
		});

		System.out.println(Arrays.deepToString(arr));

		int c = 0;
		for (int i = 0; i < arr.length; i++) {
			while (i + 1 < arr.length && arr[i][0] == arr[i + 1][0]) {
				if (arr[i][1]==arr[i+1][1])
					c++;
				i++;
			}
			int s;
			int e;
			//System.out.println(i);
			if (arr[i][0] > arr[i][1]) {
				s = i;
				e = arr.length - 1;
			} else {
				s = i;
				e = arr.length - 1;
			}

			int x = arr[i][1];
			int y = arr[i][0];
			while (s <= e) {
				int m = s + (e - s) / 2;
				if (arr[m][0] == x && arr[m][1]==y) {
					c++;
					break;
				}
				if (arr[m][0] < x)
					s = m + 1;
				else
					e = m - 1;
			}

		}

		return c;

	}
}
