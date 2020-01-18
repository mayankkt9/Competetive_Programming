package junk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class P1 {
	public static void main(String[] args) {

		int capacity = 15;
		int fg[][]=new int[][]{{1,8},{2,6},{3,4},{4,5},{5,9},{6,1},{7,10}};
		int bg[][]=new int[][]{{1,1},{2,6},{3,8},{4,3},{5,10},{6,2},{7,6},{8,3}};

		//String arr[][]=Arrays.deepToString(solve(fg,bg,capacity));
		System.out.println();
		
//		ArrayList<Integer[]> a = new ArrayList<Integer[]>();
//		a.addAll(Arrays.asList(solve(fg,bg,capacity)));
		//List<Integer> col = Arrays.stream(solve(fg,bg,capacity)).flatMap(Arrays::stream)
	}

	private static int[][] solve(int[][] fg, int[][] bg, int capacity) {
		// TODO Auto-generated method stub
		

		sort2Darray(fg);
		sort2Darray(bg);
		
		System.out.println(Arrays.deepToString(fg));
		System.out.println(Arrays.deepToString(bg));
		
		int arr[][]=store_closest(fg,bg,fg.length,bg.length,capacity);
		
		
		return arr;
	}

	private static int[][] store_closest(int[][] fg, int[][] bg, int length,
			int length2, int capacity) {
		// TODO Auto-generated method stub
		
		int d= Integer.MAX_VALUE;
		int start=0;
		int end=length2-1;
		int destroy=0;
		int inc=0;
		int ans[][]=new int[10][10];
		while(start<length && end>=0)
		{
			
			if(capacity-(fg[start][1]+bg[end][1])>=0 && capacity-(fg[start][1]+bg[end][1])<d)
			{
				d=capacity-(fg[start][1]+bg[end][1]);
				//System.out.println("Difference "+d);
				destroy=1;
			}
			
			if(destroy==1)
			{
				ans=null;
				ans=new int[10][2];
				destroy=0;
				inc=0;
			}
			if(d==capacity-(fg[start][1]+bg[end][1]))
			{
				
				ans[inc][0]=fg[start][0];
				ans[inc][1]=bg[end][0];
				inc++;
				
				//System.out.println(fg[start][0]+" "+bg[end][0]);
			}
		
		if(fg[start][1]+bg[end][1]>capacity)
			end--;
		else 
			start++;
		}
		//System.out.println(d);
		
		start=0;
		end=length2-1;
		
		while(start<length && end>=0)
		{
			
			if(capacity-(fg[start][1]+bg[end][1])>=0 && capacity-fg[start][1]+bg[end][1]<d)
				d=capacity-(fg[start][1]+bg[end][1]);
		
		if(fg[start][1]+bg[end][1]>capacity)
			end--;
		else 
			start++;
		}
		
		
		
		return ans;
	}

	private static void sort2Darray(int[][] fg) {
		// TODO Auto-generated method stub
		
		Arrays.sort(fg, new Comparator<int[]>() {
			public int compare(final int[] entry1, final int[] entry2) {

				if (entry1[1] > entry2[1])
					return 1;
				else
					return -1;
			}
		});
		
	}
	
	
	
	
}
