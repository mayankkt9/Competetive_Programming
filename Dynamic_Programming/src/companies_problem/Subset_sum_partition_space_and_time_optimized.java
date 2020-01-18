package companies_problem;

import java.util.Arrays;
import java.util.Scanner;

public class Subset_sum_partition_space_and_time_optimized {

	public static boolean subset_sum(int[] arr, int sum)
	{
		boolean calc[]=new boolean[sum+1];
		
		calc[0]=true;
		for(int i=1;i<=arr.length;i++)
		{
			for(int j=sum;j>=arr[i-1];j--)
			{
				calc[j]=calc[j]  || calc[j-arr[i-1]];
			}
			if(calc[sum]==true)
				return true;
			//System.out.println(Arrays.toString(calc));
		}
		return calc[sum];
		
	}
	
	
	public static boolean solve(int[] nums) {
		
		int sum=0;
		if (nums == null || nums.length == 0) {
            return true;
        }
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
