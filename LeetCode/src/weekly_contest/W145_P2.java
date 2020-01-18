package weekly_contest;

import java.util.Arrays;
import java.util.HashMap;

public class W145_P2 {
	public static void main(String[] args) {
		int[] arr = new int[] { 6,6,9 };
		System.out.println(longestWPI(arr));
	}

	private static int longestWPI(int[] arr) {
		// TODO Auto-generated method stub
		// Creates an empty hashMap hM

		int n = arr.length;
	int c=0;
		for (int i = 0; i < n; i++) {
			if(arr[i]<=8)
				c++;
			arr[i] = (arr[i] < 8) ? 0 : 1;
			
		}
		if(c==arr.length)
			return 0;
		for (int i = 1; i < n; i++) {
			arr[i]+=arr[i-1];
		}
		System.out.println(Arrays.toString(arr));
		int ans=0,max=0;
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i;j<arr.length;j++)
			{
				if(Math.abs(arr[i]-arr[j])>0)
				{
					
					ans=j-i+1;
					if(ans>max)
						max=ans;
				}
			}
		}
		
		return max;

	}
}
