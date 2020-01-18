package weekly_contest;

import java.util.Arrays;

public class W144_P2 {
	public static void main(String[] args) {
		int bookings[][]={{1,2,10},{2,3,20},{2,5,25}};
		corpFlightBookings(bookings, 5);
	}

	private static void corpFlightBookings(int[][] bookings, int n) {
		// TODO Auto-generated method stub
		
		
		int[] arr=new int[n];
		
		for(int i=0;i<bookings.length;i++)
		{
			for(int j=bookings[i][0]-1;j<=bookings[i][1]-1;j++)
			{
				arr[j]+=bookings[i][2];
			}
		}
		System.out.println(Arrays.toString(arr));
		
		
	}
}
