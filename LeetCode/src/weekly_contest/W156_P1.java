package weekly_contest;

public class W156_P1 {
	public static void main(String[] args) {

		String s = "abcd";
		String t = "cdef";
		int maxCost = 3;
		
		int arr[]=new int[s.length()];
		
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=Math.abs((int)s.charAt(i)-(int)t.charAt(i));
		}
		
		System.out.println(atMostSum(arr, arr.length, maxCost));

	}

	public static int atMostSum(int arr[], int n, int k) {
		int sum = 0;
		int cnt = 0, maxcnt = 0;

		for (int i = 0; i < n; i++) {

			// If adding current element doesn't
			// cross limit add it to current window
			if ((sum + arr[i]) <= k) {
				sum += arr[i];
				cnt++;
			}

			// Else, remove first element of current
			// window.
			else if (sum != 0) {
				sum = sum - arr[i - cnt] + arr[i];
			}

			// keep track of max length.
			maxcnt = Math.max(cnt, maxcnt);
		}
		return maxcnt;
	}
}
