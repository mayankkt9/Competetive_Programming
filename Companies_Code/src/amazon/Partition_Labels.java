package amazon;

import java.util.ArrayList;
import java.util.List;

public class Partition_Labels {
	public static void main(String[] args) {

		System.out.println(partitionLabels("eaaaabaaec"));
	}

	public static List<Integer> partitionLabels(String S) {

		List<Integer> res = new ArrayList<>();
		int j = 0;
		for (int i = 0; i < S.length(); i++) {
			int end = S.lastIndexOf(S.charAt(i));

			if (i == end) {
				res.add(1);
				continue;
			}
			if (i + 1 < S.length())
				j = i + 1;

			while (j != end && j < S.length()) {
				end = Math.max(end, S.lastIndexOf(S.charAt(j++)));
			}
			res.add(j - i + 1);
			i = j;
		}

		// System.out.println(res.toString());
		return res;
	}

}

//
// class Solution {
// public List<Integer> partitionLabels(String S) {
// List<Integer> res= new ArrayList<>();
// int[] last= new int[26];
// int len=S.length();
// char[] sc= S.toCharArray();
// for(int i=0;i<len;i++){
// last[sc[i]-'a']=i;
// }
// int start=-1,end=-1;
// for(int i=0;i<len;i++){
// if(start==-1) start=i;
// end= Math.max(end,last[sc[i]-'a']);
// if(end==i){ res.add(end-start+1);
// start=-1;
// }
// }
// return res;
// }
