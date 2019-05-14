package companies_problem;

import java.util.Arrays;
import java.util.Scanner;

public class Subset_sum_partition {

	public static boolean subset_sum(int[] arr, int sum)
	{
		int calc[][]=new int[arr.length+1][sum+1];
		
		for(int i=0;i<=arr.length;i++)
		{
			
			
			for(int j=0;j<=sum;j++)
			{
				if(j==0)
					calc[i][j]=1;
				else if(i==0)
					calc[i][j]=0;
				else if(j<arr[i-1])
					calc[i][j]=calc[i-1][j];
				else
					calc[i][j]=Math.max(calc[i-1][j], calc[i-1][j-arr[i-1]]);
			}
			
			//System.out.println(Arrays.deepToString(calc));
		}
		if(calc[arr.length][sum]==1)
			return true;
		else
			return false;
		
	}
	
	
	public static boolean solve(int[] nums) {
		
		int sum=0;
		for(int i=0;i<nums.length;i++)
		{
			sum=sum+nums[i];
		}
		if(sum%2!=0)
			return false;
		int sum_c=sum/2;
		
		return subset_sum(nums,sum_c);
		

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();

		System.out.println(solve(arr));
	}

}
