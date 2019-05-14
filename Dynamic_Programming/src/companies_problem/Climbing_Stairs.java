package companies_problem;

import java.util.Scanner;

public class Climbing_Stairs {
	public static int solve(int x) {

		if(x<=0) return 0;
		if(x==1) return 1;
		if(x==2) return 2;
		
		int curr=2;
		int prev=1;
		int val=0;
		for(int i=2;i<x;i++)
		{
			val=curr+prev;
			prev=curr;
			curr=val;
		}
		
		return val;
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println(solve(sc.nextInt()));
	}
}
