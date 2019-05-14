package companies_problem;

import java.util.Scanner;

import utility_method.Print_2D_array;


//Time n^2

public class Longest_Palindromic_Substring {
	public static String solve(String str) {

		int n=str.length();
		boolean dp[][]=new boolean[n][n];
		
		for(int i=0;i<n;i++)
			dp[i][i]=true;
		int max=1;
		int length=2;
		int start=0;
		while(length==2)
		{
			for(int i=0;i<n-1;i++)
			{
				int nextindex=i+length-1;
				
				if(str.charAt(i)==str.charAt(nextindex))
				{
					dp[i][nextindex]=true;
					start=i;
					max=2;
				}
			}
			length++;
		}
		
		
		for(int lt=3;lt<=n;lt++)
		{
			for(int i=0;i<n-lt+1;i++)
			{
				int last=i+lt-1;
				
				if(dp[i+1][last-1]==true && str.charAt(i)==str.charAt(last))
				{
					dp[i][last]=true;
					if(lt>max)
					{
						max=lt;
						start=i;
					}
				}
			}
			//Print_2D_array.solve(dp);
		}
		
		return str.substring(start,start+max);
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String str=sc.nextLine();
		System.out.println(solve(str));
	}
}
