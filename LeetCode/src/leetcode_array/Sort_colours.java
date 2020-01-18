package leetcode_array;

import java.util.Arrays;

public class Sort_colours {
	
	 public static  void sortColors(int[] nums) {
	     
		 
		 int i=0,l=0,h=nums.length-1;
		 if(h<0) return;
		 
		 while(i<=h)
		 {
			 if(nums[i]==0)
			 {
				 nums[i]=nums[l]+ -nums[i] + (nums[l]=nums[i]);
			 	 i++;l++;
			 }
			 else if(nums[i]==2)
			 {
				 nums[i]=nums[h]+ -nums[i] + (nums[h]=nums[i]);
				 h--;
			 }
			 else
				 i++;
			 	 
		 }
		 
		 
		 
	    }

	public static void main(String[] args) {
		
		
		int arr[] = new int[]{2,2,0,1,1,0};
		System.out.println(Arrays.toString(arr));
		sortColors(arr);
		System.out.println(Arrays.toString(arr));
	}
}
