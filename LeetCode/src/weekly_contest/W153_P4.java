package weekly_contest;

import java.util.ArrayList;
import java.util.TreeMap;

public class W153_P4 {
	public static void main(String[] args) {

		//[5,16,19,2,1,12,7,14,5,16]
		//		[6,17,4,3,6,13,4,3,18,17,16,7,14,1,16]
		
		
		int arr1[] = new int[] { 5,16,19,2,1,12,7,14,5,16};
		int arr2[] = new int[] { 6,17,4,3,6,13,4,3,18,17,16,7,14,1,16};
		System.out.println(makeArrayIncreasing(arr1, arr2));

	}

	public static int makeArrayIncreasing(int[] arr1, int[] arr2) {

		TreeMap<Integer,Integer> ts = new TreeMap<Integer,Integer>();
		ArrayList<Integer> lt = new ArrayList<Integer>();
		for (int i = 0; i < arr2.length; i++) {
			if(ts.containsKey(arr2[i])==false){
				ts.put(arr2[i],1);
			}
			else
			{
				int c = ts.get(arr2[i]);
				ts.put(arr2[i], c+1);
			}
			
		}
		int ans=0;
		for (int i = 0; i < arr1.length; i++) {
			if ((i+1<=arr1.length-1)&&arr1[i] >= arr1[i + 1] || (i-1>=0 && arr1[i]<=arr1[i-1])) {
				int x;
				if (i - 1 >= 0) {
					if(ts.higherEntry(arr1[i - 1])==null) return -1;
					x = ts.higherEntry(arr1[i - 1]).getKey();
					//if(x>=arr1[i+1]) return -1;
				} else {
					if(ts.lowerEntry(arr1[i + 1])==null) return -1;
					x = ts.lowerEntry(arr1[i + 1]).getKey();
					//if(x>=arr1[i+1]) return -1;
				}
				
				//System.out.println("hello");
				arr1[i]=x;
				ans++;
				
				int count=ts.get(x);
				if(count>1){
					ts.put(x,count-1);
				}
				else
					ts.remove(x);

			}
		}

		return ans;

	}
}
