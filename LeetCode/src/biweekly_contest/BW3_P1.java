package biweekly_contest;

import java.util.Arrays;

public class BW3_P1 {
	public static void main(String[] args) {
		int arr[]=new int[]{34,23,1,24,75,33,54,8};
		int arr1[]=new int[]{10,20};
		int k =40;
		System.out.println(twoSumLessThanK(arr1,k));
	}
	 public static int twoSumLessThanK(int[] A, int K) {
	        
		 if(A.length<=0) return -1;
		 Arrays.sort(A);
		 int i=0;
		 int j=A.length-1;
		int res=Integer.MAX_VALUE;
		int flag=0;
	     while(i<j)
	     {
	    	 if(A[i]+A[j]<K)
	    	 {
	    		res=Math.min(res,K-A[i]-A[j]);
	    		flag=1;
	    		i++;
	    	 }
	    	 else
	    	 {
	    		 j--;
	    	 }
	     }
		 if(flag==1)
			 return K-res;
		 else
			 return -1;
	    }
}
