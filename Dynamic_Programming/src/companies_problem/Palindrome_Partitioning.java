package companies_problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import jdk.internal.util.xml.impl.Input;

import utility_method.Is_Palindrome;
import utility_method.Print_2D_array;

//n^3

public class Palindrome_Partitioning {

	public static int solve(String str) {

		int n = str.length();
		int dp[][] = new int[n][n];

		for (int i = 0; i < n; i++)
			dp[i][i] = 0;

		for (int k = 2; k <= n; k++) {
			for (int j = 0; j < n - k + 1; j++) {
				int tr = j + k - 1;

				if (k == 2) {
					if (Is_Palindrome.solve(str, j, tr))
						dp[j][tr] = 0;
					else
						dp[j][tr] = 1;
				} else {
					if (Is_Palindrome.solve(str, j, tr))
						dp[j][tr] = 0;
					else {
						int min = Integer.MAX_VALUE;
						int calc;
						for (int i = j; i < tr; i++) {
							calc = 1 + dp[j][i] + dp[i + 1][tr];
							if (calc < min)
								min = calc;
						}
						dp[j][tr] = min;
					}

				}
				//Print_2D_array.solve(dp);

			}
		}

		return dp[0][n-1];
	}

	
	
	
	
	
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		//Scanner sc = new Scanner(System.in);
		//String str = "ababbbabbababa";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test>0)
		{
			String str= br.readLine();
			System.out.println(solve(str));
			test--;
		}
		
		
	}
}
