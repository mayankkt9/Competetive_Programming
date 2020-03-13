import java.io.*;
import java.util.*;


class palinpartition
{
	public static void main(String args[])throws IOException{
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		List<String> temp = new ArrayList<>();
		List<List<String>> answer = new ArrayList<>();
		solve(s,0,0,temp,answer);
		System.out.println(answer);
	}
	public static void solve(String s, int low,int high,List<String> temp,List<List<String>> answer){
		
		if(low==s.length()){
			answer.add(new ArrayList<>(temp));
		}	
	
		for(int i=low;i<s.length();i++){
			temp.add(s.substring(low,i+1));
			if(isPalin(s,low,i))
				solve(s,i+1,high,temp,answer);
			temp.remove(temp.size()-1);
		}
	}
	public static boolean isPalin(String s, int low,int high){
		if(low==high) return true;
		while(low<high){
			if(s.charAt(low)!=s.charAt(high))
				return false;
			low++;
			high--;
		}
		return true;
	}
}
