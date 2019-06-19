package leetcode_array;

import java.util.Arrays;

public class Partition_Array_Disjoing_Interval {
	 public static int partitionDisjoint(int[] A) {
	     
		 int n=A.length;
		 int min[]=new int[n];
		 min[n-1]=A[n-1];
		 for(int i=n-2;i>=0;i--)
		 {
			 min[i]=Math.min(A[i], min[i+1]);
		 }
		 //System.out.println(Arrays.toString(min));
		 int max=0;
		 int ans=0;
		 for(int i=1;i<n;i++)
		 {
			 max=Math.max(A[i-1], max);
			 //System.out.print(i+"-"+max+ "-"+min[i]+"\n");
			 
			 if(max<=min[i])
			 {
				 ans=i;
				 break;
			 }
		 }
		 
		 
		return ans;
	    }
	 public static void main(String[] args) {
		int a[]=new int[]{1,1,1,0,6,12};
		System.out.println(partitionDisjoint(a));
	}
}
