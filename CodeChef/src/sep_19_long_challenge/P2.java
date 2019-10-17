package sep_19_long_challenge;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.InputMismatchException;

public class P2 {

	static int min = Integer.MAX_VALUE;
	static int count = 0;

	public static void main(String[] args) throws IOException {

		Scan scan = new Scan();
		int t = scan.scanInt();

		while (t > 0) {
			int n = scan.scanInt();
			int k = scan.scanInt();
			int arr[] = new int[n];
			for (int i = 0; i < n; i++) {

				arr[i] = scan.scanInt();

			}
			int temp[] = new int[k];
			combinationUtil(arr, n, k, 0, temp, 0);
			System.out.println(count);
			t--;
		}
	}

	public static void combinationUtil(int arr[], int n, int r, int index,
			int data[], int i) {
		// Current combination is ready to be printed,
		// print it
		if (index == r) {
			for (int j = 0; j < r; j++) {
				
				//System.out.print(data[j] + " ");
				sum(data);
			}
			//System.out.println("");
			return;
		}

		// When no more elements are there to put in data[]
		if (i >= n)
			return;

		// current is included, put next at next
		// location
		data[index] = arr[i];
		combinationUtil(arr, n, r, index + 1, data, i + 1);

		// current is excluded, replace it with
		// next (Note that i+1 is passed, but
		// index is not changed)
		combinationUtil(arr, n, r, index, data, i + 1);
	}

	private static void sum(int[] data) {
		// TODO Auto-generated method stub
		int sum=0;
		for(int i=0;i<data.length;i++){
			sum+=data[i];
		}
		//System.out.println(Arrays.toString(data)+"->"+sum+"->"+count);
		if(sum<min){
			count=0;
			min=sum;
		}
		if(sum==min){
			count++;
		}
		

	}

}
