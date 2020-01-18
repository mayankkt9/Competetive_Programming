package leetcode_array;

import java.util.HashMap;

public class Subarray_sum_k {
	  public static int subarraySum(int[] nums, int k) {
	       
		  HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		  int n=nums.length;
		  int sum=0,c=0;
		  if(n<1) return 0;
		  hm.put(0, 1);
		  for(int i=0;i<n;i++)
		  {
			  sum+=nums[i];
			  if(hm.containsKey(sum-k))
				  c+=hm.get(sum-k);
			  hm.put(sum, hm.getOrDefault(sum,0)+1);
		  }
		  
		 //System.out.println((Arrays.asList(hm)));
		  return c;
	    }
	  public static void main(String[] args) {
		
		  int nums[]=new int[]{3,4,7,2,-3,1,4,2,1};
		  int k=7;
		  
		  //System.out.println(subarraySum(nums,k));
	}
}
