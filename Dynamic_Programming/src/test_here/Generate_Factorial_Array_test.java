package test_here;

import java.math.BigInteger;
import java.util.Arrays;

import utility_method.Generate_Factorial_Array;

public class Generate_Factorial_Array_test {
	public static void main(String[] args) {
		long arr[]=Generate_Factorial_Array.solve(200);
		System.out.println(Arrays.toString(arr));
		
		BigInteger a[]=Generate_Factorial_Array.solve("6");
		for(int i=1;i<7;i++)
		{
			System.out.print(a[i]+"-");
		}
		//System.out.println(a.toString());
	}
}
