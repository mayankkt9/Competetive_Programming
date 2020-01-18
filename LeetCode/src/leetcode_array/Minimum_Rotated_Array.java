package leetcode_array;

public class Minimum_Rotated_Array {
	 public static int findMin(int[] nums) {
	     
		 int start=0,end=nums.length-1,mid;
		 while(start<end)
		 {
			 mid=start+(end-start)/2;
			 
			 if(nums[mid]>nums[end])
				 start=mid+1;
			 else if(nums[mid]<nums[end])
				 end=mid;
			 else
				 end--;
			 
			 System.out.println(start+" "+mid+" "+end);
		 }
		 
		 
		 
		 
		 return nums[start];
	    }
	 public static void main(String[] args) {
		
		 int arr[]=new int[]{3,4,5,6,7,8,9,0,1,2};
		 System.out.println(findMin(arr));
	}
}
