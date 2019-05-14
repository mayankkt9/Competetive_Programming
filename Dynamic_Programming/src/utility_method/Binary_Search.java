package utility_method;

public class Binary_Search {
	
	//Gives right index if not found
	public static int solve_for_LIS(int arr[],int l,int r,int key) {
		
		while(r-l>1)
		{
			int m=l+(r-l)/2;
			if(arr[m]>=key)
				r=m;
			else
				l=m;
		}
		
		return r;
	}
}
