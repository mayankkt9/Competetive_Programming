import java.io.*;
import java.util.*;

class permutation{
	public static void main(String args[])throws IOException{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> arr = new ArrayList<>(n);
		for(int i=0;i<n;i++){
			arr.add(sc.nextInt());
		}	
		List<List<Integer>> answer = new ArrayList<>();
		solve_perm(answer,arr,0,n);
		System.out.println(answer);
	}	
	public static void solve_perm(List<List<Integer>> answer,ArrayList<Integer> arr,int l,int h){
		if(l==h){
			answer.add(new ArrayList<>(arr));
		}		

		for(int i=l;i<h;i++){
			Collections.swap(arr,i,l);
			solve_perm(answer,arr,l+1,h);
			Collections.swap(arr,i,l);
		}
	}
	public static void swap(List<Integer> list, int low,int high){
		int temp = list.get(low);
		list.set(low,list.get(high));
		list.set(high,temp);
	}

}
