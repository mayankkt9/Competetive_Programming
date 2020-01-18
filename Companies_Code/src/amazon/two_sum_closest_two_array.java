package amazon;

import java.util.Arrays;
import java.util.Comparator;

public class two_sum_closest_two_array {
	public static void main(String[] args) {
		int max=10000;
		int fd[][]={{1,3000},{2,5000},{3,7000},{4,10000}};
		int bd[][]={{1,2000},{2,3000},{3,4000},{4,5000}};
		
		int res[][]=solve(fd,bd,max);
		System.out.println(Arrays.deepToString(res));
	}

	private static int[][] solve(int[][] fd, int[][] bd, int max) {
		// TODO Auto-generated method stub
		
		fd=sortme(fd);
		System.out.println(Arrays.deepToString(fd));
		bd=sortme(bd);
		System.out.println(Arrays.deepToString(bd));
		
		int i=0;
		int j=bd.length-1;
		
		int min=Integer.MAX_VALUE;
		int res[][]=null;
		int traverse=0;
		while(i<fd.length && j>=0)
		{
			if(max-fd[i][1]-bd[j][1]==min)
			{
				res[traverse][0]=fd[i][0];
				res[traverse][1]=bd[j][0];
				traverse++;
			}
			
			if(max-fd[i][1]-bd[j][1]>=0 && max-fd[i][1]-bd[j][1]<min)
			{
				min=max-fd[i][1]-bd[j][1];
				res=new int[10][2];
				traverse=0;
				res[traverse][0]=fd[i][0];
				res[traverse][1]=bd[j][0];
				traverse++;
			}
			
			
			if(fd[i][1]+bd[j][1]>max)
				j--;
			else
				i++;
			
		}
		return res;
	}
	
	
	public static int[][] sortme(int arr[][]){
		
		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(final int[] entry1, final int[] entry2) {

				if (entry1[1] > entry2[1])
					return 1;
				else
					return -1;
			}
		});
		
		return arr;
	}
}
