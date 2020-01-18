package google;

import java.util.Scanner;

public class P3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int test = 1;
		while (test <= t) {
			int n = sc.nextInt();
			long m = sc.nextLong();
			long arr[] = new long[n];

			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextLong();
			}
			long result2 = 0;
			if (m == 0) {
				for (int i = 0; i < arr.length; i++) {
					result2 += arr[i];
				}
				System.out.println("Case #" + test + ":" + " " + result2);
				test++;
				continue;
			}
			
			long low = 0;
			long high = 1000L;
			long mid = 0;
			long result = 0;
			long val = 0;
			long val1 = 0;
			while (low != high) {

				mid = low + (high - low) / 2;
				val = xora(arr, mid);
				val1 = xora(arr, mid + 1);
				if (val == m) {
					result = mid;
					break;
				}
				if (xora(arr, mid) > m) {
					high = mid - 1;
				} else if (xora(arr, mid) < m) {
					low = mid;
				}

			}
			long ans = mid;
			long val3 = xora(arr, ans + 1);
			while (xora(arr, ans + 1) <= m) {
				ans++;
			}
			
			if (ans == 0)
				result = -1;
			result = ans;
			System.out.println("Case #" + test + ":" + " " + result);

			test++;
		}
	}

	public static long xora(long arr[], long k) {
		long result = 0;
		for (int i = 0; i < arr.length; i++) {
			result += arr[i] ^ k;
		}
		return result;
	}
}
