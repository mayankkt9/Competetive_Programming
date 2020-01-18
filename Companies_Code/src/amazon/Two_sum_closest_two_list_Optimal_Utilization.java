package amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Two_sum_closest_two_list_Optimal_Utilization {
	public static void main(String[] args) {
		int x1[]=new int[]{1,3};
		int x2[]=new int[]{2,5};
		int x3[]=new int[]{3,7};
		int x4[]= new int[]{4,10};
		
		int y1[]=new int[]{1,2};
		int y2[]=new int[]{2,3};
		int y3[]=new int[]{3,4};
		int y4[]=new int[]{4,5};
		
		
		List<int[]> a = new ArrayList<>();
		List<int[]> b = new ArrayList<>();
		
		a.add(x1);
		a.add(x2);
		a.add(x3);
		a.add(x4);
		
		b.add(y1);
		b.add(y2);
		b.add(y3);
		b.add(y4);
		System.out.println(getPairs(a, b, 10));
		
		
	}
	
	
	
	private static List<int[]> getPairs(List<int[]> a, List<int[]> b, int target) {
		
       // Collections.sort(a, (i,j) -> i[1] - j[1]);
       // Collections.sort(b, (i,j) -> i[1] - j[1]);
        List<int[]> result = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        int m = a.size();
        int n = b.size();
        int i =0;
        int j =n-1;
        while(i<m && j >= 0) {
            int sum = a.get(i)[1] + b.get(j)[1];
            if(sum > target) {
                 --j;
            } else {
                if(max <= sum) {
                    if(max < sum) {
                        max = sum;
                        result.clear();
                    }
                    result.add(new int[]{a.get(i)[0], b.get(j)[0]});
                    int index = j-1;
                    while(index >=0 && b.get(index)[1] == b.get(index+1)[1]) {
                         result.add(new int[]{a.get(i)[0], b.get(index--)[0]});
                    }
                }
                ++i;
            }
        }
        return result;
    } 
}
