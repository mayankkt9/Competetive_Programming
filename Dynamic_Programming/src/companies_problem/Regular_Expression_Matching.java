package companies_problem;

import java.util.Scanner;

import utility_method.Print_2D_array;

public class Regular_Expression_Matching {
	
	public static boolean solve(String str,String ptr) {

		if(str.length()==0 && ptr.length()==0) return true;
		if(str.length()!=0 && ptr.length()==0) return false;
		if(ptr.length()==2 && ptr.charAt(0)=='.' && ptr.charAt(1)=='*') return true;
		
		int n=str.length();
		int m=ptr.length();
		
		boolean dp[][]=new boolean[n+1][m+1];
		
		for(int i=1;i<=n;i++)
		{
			dp[i][0]=false;
		}
		for(int i=1;i<=m;i++)
		{
			dp[0][i]=false;
		}
		int tk=1;
		while(tk<ptr.length() && ptr.charAt(tk-1)=='*')
		{
			dp[0][tk]=true;
			++tk;
		}
		tk=1;
		while(tk<ptr.length() && ptr.charAt(tk-1)!='*' && ptr.charAt(tk)=='*')
		{
			dp[0][tk]=true;
			dp[0][tk+1]=true;
			tk=tk+2;
		}
		
		dp[0][0]=true;
		
//		if(ptr.charAt(0)=='*')
//			dp[0][1]=true;
		
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=m;j++)
			{
				if(str.charAt(i-1)==ptr.charAt(j-1) || ptr.charAt(j-1)=='.')
					dp[i][j]=dp[i-1][j-1];
				else 
				{
					if (ptr.charAt(j-1)=='*')
					{
						if(dp[i][j-2]==true)
							dp[i][j]=dp[i][j-2];
						else
						{
							if(str.charAt(i-1)==ptr.charAt(j-2))
								dp[i][j]=dp[i-1][j];
							else if(ptr.charAt(j-2)=='.')
								dp[i][j]=dp[i-1][j];
							else
								dp[i][j]=false;
						}
					}
					
						
				}
				
			}
		}
		Print_2D_array.solve(dp);
		return dp[n][m];
	}


	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String ptrn = sc.nextLine();
		System.out.println(solve(str,ptrn));
	}
}
