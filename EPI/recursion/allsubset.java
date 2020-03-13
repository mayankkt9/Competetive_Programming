import java.io.*;
import java.util.*;

class allsubset{
	public static void main(String args[])throws IOException{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<n;i++){
			list.add(sc.nextInt());
		}
		List<Integer> temp = new ArrayList<>();
		List<List<Integer>> answer = new ArrayList<>();
		solve_subset(answer,temp,list,0);
		System.out.println(answer);
	}
	public static void solve_subset(List<List<Integer>> answer ,List<Integer> temp,List<Integer> inp,int curr){
		if(curr==inp.size()){
			answer.add(new ArrayList<>(temp));
			return;
		}
		temp.add(inp.get(curr));
		solve_subset(answer,temp,inp,curr+1);
		temp.remove(temp.size()-1);
		solve_subset(answer,temp,inp,curr+1);
	}
}
