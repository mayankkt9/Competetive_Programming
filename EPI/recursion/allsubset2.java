import java.io.*;
import java.util.*;

class allsubset2{
	public static void main(String args[])throws IOException{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++){
			arr[i]=sc.nextInt();
		}
		solve(arr);
	}
	public static void solve(int arr[]){
		int n = arr.length;
		for(int i=0;i<(1<<n);i++){
			for(int j=0;j<n;j++){
				if((i & (1<<j))==1){
					System.out.print(arr[j]+" ");
				}
			}
			System.out.println();
		}
	}
}
