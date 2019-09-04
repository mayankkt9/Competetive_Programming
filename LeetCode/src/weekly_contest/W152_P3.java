package weekly_contest;

import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class W152_P3 {
	public static void main(String[] args) {
		String s = "abcda";
		int arr[][]={{3,3,0},{1,2,0},{0,3,1},{0,3,2},{0,4,1}};
		System.out.println(canMakePaliQueries(s,arr));
	}

	 public static List<Boolean> canMakePaliQueries(String s, int[][] queries) {
		 
		 List<Boolean> lt = new ArrayList<Boolean>();
		 for(int i =0 ;i<queries.length;i++)
		 {
			 int l=queries[i][0];
			 int r=queries[i][1];
			 int edit=queries[i][2];
			 int c=0;
			 while(l<=r){
				 if(s.charAt(l)!=s.charAt(r))
					 c++;
				 l++;
				 r--;
			 }
			 if(c<=edit)
				 lt.add(true);
			 else
				 lt.add(false);
				 
			 
			 
		 }
		 
		return lt;
	        
		 
	    }
}
