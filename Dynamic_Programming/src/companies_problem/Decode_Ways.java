package companies_problem;

import java.util.Scanner;

public class Decode_Ways {
	public static int solve(String str) {
		
		int n=str.length();
		if(n==0 || str.charAt(0)=='0') return 0;
		if(n==1) return 1;
		int dp[]=new int[n+1];
		
		dp[0]=1;
		dp[1]=str.charAt(1)=='0'?0:1;
		for(int i=2;i<=n;i++)
		{
			int f=Integer.valueOf(str.substring(i-1,i));
			int s=Integer.valueOf(str.substring(i-2,i));
			if(f>=1&&f<=9)
				dp[i]+=dp[i-1];
			if(s>=10&&s<=26)
				dp[i]+=dp[i-2];
		}
		return dp[n];
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println(solve(sc.nextLine()));
	}
}
