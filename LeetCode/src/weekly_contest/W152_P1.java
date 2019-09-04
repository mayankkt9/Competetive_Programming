package weekly_contest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class W152_P1 {

	

	public static void main(String[] args) {
		// int arr[]={};
		int k = 100;
		System.out.println(solve(k));
	}

	private static int solve(int k) {

		int c=0;
		
		for (int i = 2; i <= k; i++) {
			int counter = 0;
			for (int num = i; num >= 1; num--) {
				if (i % num == 0) {
					counter = counter + 1;
				}
			}
			if (counter == 2) {
				// Appended the Prime number to the String
				c++;
			}
		}
		
		long sum=1;
		for(int i=1;i<=c;i++){
			sum=sum*i;
			sum=sum%1000000007;
		}
		for(int i=1;i<=Math.abs(c-k);i++){
			sum=sum*i;
			sum=sum%1000000007;
		}
		
		return (int) sum;
	}
}
