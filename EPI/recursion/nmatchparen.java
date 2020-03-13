
import java.io.*;
import java.util.*;


class nmatchparen{
	public static void main(String args[])throws IOException{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<String> answer = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		solve(n,n,n,answer,"");
		System.out.println(answer);
	}
	public static void solve(int n,int open,int close,List<String> answer,String sb){
		if(sb.length()==2*n){
			answer.add(new String(sb));
			return;
		}
		if(open>0){
			solve(n,open-1,close,answer,sb+"(");
		}
		if(close>open){
			solve(n,open,close-1,answer,sb+")");
		}
	}
}
