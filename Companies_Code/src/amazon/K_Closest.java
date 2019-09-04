package amazon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class K_Closest {
	public static void main(String[] args) {
		
		
		int points[][]={{3,3},{5,-1},{-2,4},{3,10},{12,-2}};
		int K=2;
		System.out.println(Arrays.deepToString(kClosest(points, K)));
	}
	
public static int[][] kClosest(int[][] points, int K) {
        
	int res[][]=new int[K][2];
	PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new kclose_comparator());
	for(int p[] : points){
		pq.offer(p);
	}
	
	while(K>0){
		res[--K]=pq.poll();
	}
	
	return res;
    }
}

class kclose_comparator implements Comparator<int[]>{

	@Override
	public int compare(int[] o1, int[] o2) {
		// TODO Auto-generated method stub
		int val1=(o1[0]*o1[0])+(o1[1]*o1[1]);
		int val2=(o2[0]*o2[0])+(o2[1]*o2[1]);
		return (val1-val2);
	}

	
}
