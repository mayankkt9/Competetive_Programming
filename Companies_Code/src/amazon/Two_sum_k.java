package amazon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Two_sum_k {
	public static void main(String[] args) {
		
		int arr[]={100, 85, 75, 60, 120, 150, 130};
		int d = 250;
		System.out.println(solve(arr,d));
		
		
		
	}

	private static int solve(int[] arr,int d) {
		// TODO Auto-generated method stub
		
		Map<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if(hm.containsKey(d-arr[i])){
				System.out.println(arr[i]+" "+(d-arr[i]));
				
			}
			hm.put(arr[i], 0);
		}
		
		
		
		
		return 0;
	}
}
