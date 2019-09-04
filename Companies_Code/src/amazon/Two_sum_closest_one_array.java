package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class Pair{
	int a;
	int b;
	public Pair(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}
	
}


public class Two_sum_closest_one_array {
	public static void main(String[] args) {

		int arr[] = { 90, 85, 65, 60, 120, 150, 125 };
		int d = 250;
		System.out.println();

		List<Pair> res = solve(arr, d);
		for (Iterator iterator = res.iterator(); iterator.hasNext();) {
			Pair pair = (Pair) iterator.next();
			System.out.println(pair.a+" "+pair.b);
		}
	}

	private static List<Pair> solve(int[] arr, int d) {
		// TODO Auto-generated method stub
		d=d-30;
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));

		int i = 0;
		int j = arr.length - 1;
		int min = Integer.MAX_VALUE;
		List<Pair> res=null;
		while (i < j) {

			if (d - arr[i] - arr[j] == min){
				res.add(new Pair(arr[i], arr[j]));
			}
			
			if (d - arr[i] - arr[j]>=0 && d - arr[i] - arr[j] < min) {
				min = d - arr[i] - arr[j];
				res   = new ArrayList<>();
				res.add(new Pair(arr[i], arr[j]));
			}
			
			if(arr[i]+arr[j]>d)
				j--;
			else
				i++;
		}

		return res;
	}
}
