package utility_method;

import java.math.BigInteger;

public class Generate_Factorial_Array {
	public static long[] solve(int n) {

		long  arr[]=new long[n+1];
		arr[1]=1;
		for(int i=2;i<=n;i++)
			arr[i]=arr[i-1]*i;
		return arr;
	}
	
	public static BigInteger[] solve(String str)
	{
		
		int n=Integer.valueOf(str);
		n=n+1;
		str=String.valueOf(n);
		//System.out.println(str);
		BigInteger total = new BigInteger(str);
		BigInteger[] array = new BigInteger[total.intValue()];
		array[1]=BigInteger.ONE;
		for(int i=2;i<n;i++)
		{
			array[i]=array[i-1].multiply(BigInteger.valueOf(i));
		}
		
		return array;
		
	}


}
