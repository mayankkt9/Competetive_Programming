package leetcode_problems;

public class Maximum_Product_Subarray {
	static void swap(int x,int y){
		x = x ^ y; // x now becomes 15 (1111) 
	    y = x ^ y; // y becomes 10 (1010) 
	    x = x ^ y; // x becomes 5 (0101) 
	}
	static int maxProduct(int A[], int n) {
	    // store the result that is the max we have found so far
	    int r = A[0];
	    int temp;
	    // imax/imin stores the max/min product of
	    // subarray that ends with the current number A[i]
	    for (int i = 1, imax = r, imin = r; i < n; i++) {
	        // multiplied by a negative makes big number smaller, small number bigger
	        // so we redefine the extremums by swapping them
	        if (A[i] < 0)
	        {
	        	temp=imin;
	        	imin=imax;
	        	imax=temp;
	        }

	        // max/min product for the current number is either the current number itself
	        // or the max/min by the previous number times the current one
	        imax = Math.max(A[i], imax * A[i]);
	        imin = Math.min(A[i], imin * A[i]);
	        System.out.println(imax+" "+imin);
	        // the newly computed max value is a candidate for our global result
	        r = Math.max(r, imax);
	    }
	    return r;
	}

	public static void main(String args[]) {
		
		int x=3;int y=4;
		swap(x, y);
		System.out.println(x+"----"+y);
		
		int[] arr = new int[] {2,3,-2,4,3,-3,-2,5,-4};
	    System.out.println("Answer -> "+maxProduct(arr,9));
	}
}
